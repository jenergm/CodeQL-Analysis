/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_rand_add_01.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: rand Set data to result of rand()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before adding 1 to data
*    BadSink : Add 1 to data, which can cause an overflow
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_rand_add_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        short data;

        /* POTENTIAL FLAW: Use a random value */
        data = (short)((new java.security.SecureRandom()).nextInt(1+Short.MAX_VALUE-Short.MIN_VALUE)+Short.MIN_VALUE);

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        short result = (short)(data + 1);

        IO.writeLine("result: " + result);

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        short result = (short)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        short data;

        /* POTENTIAL FLAW: Use a random value */
        data = (short)((new java.security.SecureRandom()).nextInt(1+Short.MAX_VALUE-Short.MIN_VALUE)+Short.MIN_VALUE);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Short.MAX_VALUE)
        {
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too large to perform addition.");
        }

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

