/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_random_sub_66a.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__int_random_sub_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a random value */
        SecureRandom r = new SecureRandom();
        data = r.nextInt();

        int[] data_array = new int[5];
        data_array[2] = data;
        (new CWE191_Integer_Underflow__int_random_sub_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        int[] data_array = new int[5];
        data_array[2] = data;
        (new CWE191_Integer_Underflow__int_random_sub_66b()).goodG2B_sink(data_array  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Set data to a random value */
        SecureRandom r = new SecureRandom();
        data = r.nextInt();

        int[] data_array = new int[5];
        data_array[2] = data;
        (new CWE191_Integer_Underflow__int_random_sub_66b()).goodB2G_sink(data_array  );
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
