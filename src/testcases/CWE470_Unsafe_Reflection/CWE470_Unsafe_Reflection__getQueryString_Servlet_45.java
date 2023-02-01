/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getQueryString_Servlet_45.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-45.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;

public class CWE470_Unsafe_Reflection__getQueryString_Servlet_45 extends AbstractTestCaseServlet
{

    private String bad_data;
    private String goodG2B_data;

    private void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_data;

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        bad_data = data;
        bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    private void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_data;

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded class name */
        data = "Testing.test";

        goodG2B_data = data;
        goodG2B_sink(request, response);
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
