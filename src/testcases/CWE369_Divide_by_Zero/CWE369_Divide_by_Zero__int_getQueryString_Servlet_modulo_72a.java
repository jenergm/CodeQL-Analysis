/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_getQueryString_Servlet_modulo_72a.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.util.Vector;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import javax.servlet.http.*;
import java.util.StringTokenizer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__int_getQueryString_Servlet_modulo_72a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=33" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    try
                    {
                        data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                    }
                    break; /* exit while loop */
                }
            }
        }

        Vector<Integer> data_vector = new Vector<Integer>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE369_Divide_by_Zero__int_getQueryString_Servlet_modulo_72b()).bad_sink(data_vector , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        Vector<Integer> data_vector = new Vector<Integer>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE369_Divide_by_Zero__int_getQueryString_Servlet_modulo_72b()).goodG2B_sink(data_vector , request, response );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=33" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    try
                    {
                        data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                    }
                    break; /* exit while loop */
                }
            }
        }

        Vector<Integer> data_vector = new Vector<Integer>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE369_Divide_by_Zero__int_getQueryString_Servlet_modulo_72b()).goodB2G_sink(data_vector , request, response );
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
