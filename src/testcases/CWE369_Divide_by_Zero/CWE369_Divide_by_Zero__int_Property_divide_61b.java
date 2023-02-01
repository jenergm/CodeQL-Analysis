/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_Property_divide_61b.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__int_Property_divide_61b
{

    public int bad_source() throws Throwable
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

    /* goodG2B() - use goodsource and badsink */
    public int goodG2B_source() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public int goodB2G_source() throws Throwable
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
}
