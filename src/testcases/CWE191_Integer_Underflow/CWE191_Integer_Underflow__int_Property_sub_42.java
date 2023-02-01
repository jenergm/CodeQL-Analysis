/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_Property_sub_42.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE191_Integer_Underflow__int_Property_sub_42 extends AbstractTestCase
{

    private int bad_source() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        {
            String s_data = System.getProperty("user.home");
            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
            }
        }

        return data;
    }

    public void bad() throws Throwable
    {
        int data = bad_source();

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private int goodG2B_source() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    private void goodG2B() throws Throwable
    {
        int data = goodG2B_source();

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    private int goodB2G_source() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        {
            String s_data = System.getProperty("user.home");
            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
            }
        }

        return data;
    }

    private void goodB2G() throws Throwable
    {
        int data = goodB2G_source();

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Integer.MIN_VALUE)
        {
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
