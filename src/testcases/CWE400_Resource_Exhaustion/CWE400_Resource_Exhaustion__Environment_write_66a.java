/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Environment_write_66a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Environment Read count from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__Environment_write_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read count from an environment variable */
        {
            String s_count = System.getenv("ADD");
            if (s_count != null)  // avoid NPD incidental warnings
            {
                try
                {
                    count = Integer.parseInt(s_count.trim());
                }
                catch(NumberFormatException nfe)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                }
            }
        }

        int[] count_array = new int[5];
        count_array[2] = count;
        (new CWE400_Resource_Exhaustion__Environment_write_66b()).bad_sink(count_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        int[] count_array = new int[5];
        count_array[2] = count;
        (new CWE400_Resource_Exhaustion__Environment_write_66b()).goodG2B_sink(count_array  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read count from an environment variable */
        {
            String s_count = System.getenv("ADD");
            if (s_count != null)  // avoid NPD incidental warnings
            {
                try
                {
                    count = Integer.parseInt(s_count.trim());
                }
                catch(NumberFormatException nfe)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                }
            }
        }

        int[] count_array = new int[5];
        count_array[2] = count;
        (new CWE400_Resource_Exhaustion__Environment_write_66b()).goodB2G_sink(count_array  );
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
