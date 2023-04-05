/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Property_write_67a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Property Read count from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__Property_write_67a extends AbstractTestCase
{

    static class Container
    {
        public int a;
    }

    public void bad() throws Throwable
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

        Container count_container = new Container();
        count_container.a = count;
        (new CWE400_Resource_Exhaustion__Property_write_67b()).bad_sink(count_container  );
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

        Container count_container = new Container();
        count_container.a = count;
        (new CWE400_Resource_Exhaustion__Property_write_67b()).goodG2B_sink(count_container  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
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

        Container count_container = new Container();
        count_container.a = count;
        (new CWE400_Resource_Exhaustion__Property_write_67b()).goodB2G_sink(count_container  );
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
