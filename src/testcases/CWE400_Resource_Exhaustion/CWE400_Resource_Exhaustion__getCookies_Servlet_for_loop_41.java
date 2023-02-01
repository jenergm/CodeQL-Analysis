/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getCookies_Servlet_for_loop_41.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getCookies_Servlet Read count from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__getCookies_Servlet_for_loop_41 extends AbstractTestCaseServlet
{

    private void bad_sink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int i = 0;

        /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
        for (i = 0; i < count; i++)
        {
            IO.writeLine("Hello");
        }

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* initialize count in case there are no cookies */

        /* Read count from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read count from the first cookie value */
                String s_data = cookieSources[0].getValue();
                try
                {
                    count = Integer.parseInt(s_data.trim());
                }
                catch(NumberFormatException nfe)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading count from cookie", nfe);
                }
            }
        }

        bad_sink(count , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int i = 0;

        /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
        for (i = 0; i < count; i++)
        {
            IO.writeLine("Hello");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        goodG2B_sink(count , request, response );
    }

    private void goodB2G_sink(int count , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int i = 0;

        /* FIX: Validate count before using it as the for loop variant */
        if (count > 0 && count <= 20)
        {
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* initialize count in case there are no cookies */

        /* Read count from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read count from the first cookie value */
                String s_data = cookieSources[0].getValue();
                try
                {
                    count = Integer.parseInt(s_data.trim());
                }
                catch(NumberFormatException nfe)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading count from cookie", nfe);
                }
            }
        }

        goodB2G_sink(count , request, response );
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
