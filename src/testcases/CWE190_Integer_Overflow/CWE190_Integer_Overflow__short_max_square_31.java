/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_max_square_31.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.lang.Math;

public class CWE190_Integer_Overflow__short_max_square_31 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        short data_copy;
        {
            short data;

            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Short.MAX_VALUE;

            data_copy = data;
        }
        {
            short data = data_copy;

            /* POTENTIAL FLAW: if (data*data) > Short.MAX_VALUE, this will overflow */
            short result = (short)(data * data);

            IO.writeLine("result: " + result);

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        short data_copy;
        {
            short data;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

            data_copy = data;
        }
        {
            short data = data_copy;

            /* POTENTIAL FLAW: if (data*data) > Short.MAX_VALUE, this will overflow */
            short result = (short)(data * data);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        short data_copy;
        {
            short data;

            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Short.MAX_VALUE;

            data_copy = data;
        }
        {
            short data = data_copy;

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Short.MAX_VALUE)))
            {
                short result = (short)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

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
