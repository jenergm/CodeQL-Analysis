/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_67a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getParameter_Servlet Read count from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
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

public class CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_67a extends AbstractTestCaseServlet
{

    static class Container
    {
        public int a;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* POTENTIAL FLAW: Read count from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                count = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading count from parameter 'name'", nfe);
            }
        }

        Container count_container = new Container();
        count_container.a = count;
        (new CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_67b()).bad_sink(count_container , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        Container count_container = new Container();
        count_container.a = count;
        (new CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_67b()).goodG2B_sink(count_container , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* POTENTIAL FLAW: Read count from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                count = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading count from parameter 'name'", nfe);
            }
        }

        Container count_container = new Container();
        count_container.a = count;
        (new CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_67b()).goodB2G_sink(count_container , request, response );
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
