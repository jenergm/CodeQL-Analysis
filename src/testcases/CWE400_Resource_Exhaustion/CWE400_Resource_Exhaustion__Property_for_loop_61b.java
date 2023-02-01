/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Property_for_loop_61b.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Property Read count from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__Property_for_loop_61b
{

    public int bad_source() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get system property user.home */
        /* POTENTIAL FLAW: Read count from a system property */
        {
            String s_count = System.getProperty("user.home");
            try {
                count = Integer.parseInt(s_count.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
            }
        }

        return count;
    }

    /* goodG2B() - use goodsource and badsink */
    public int goodG2B_source() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        return count;
    }

    /* goodB2G() - use badsource and goodsink */
    public int goodB2G_source() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get system property user.home */
        /* POTENTIAL FLAW: Read count from a system property */
        {
            String s_count = System.getProperty("user.home");
            try {
                count = Integer.parseInt(s_count.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
            }
        }

        return count;
    }
}
