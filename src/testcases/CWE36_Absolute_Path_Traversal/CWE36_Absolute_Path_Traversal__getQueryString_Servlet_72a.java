/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__getQueryString_Servlet_72a.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-72a.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;
import java.util.Vector;

import java.io.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;

public class CWE36_Absolute_Path_Traversal__getQueryString_Servlet_72a extends AbstractTestCaseServlet
{

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

        Vector<String> data_vector = new Vector<String>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE36_Absolute_Path_Traversal__getQueryString_Servlet_72b()).bad_sink(data_vector , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        Vector<String> data_vector = new Vector<String>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE36_Absolute_Path_Traversal__getQueryString_Servlet_72b()).goodG2B_sink(data_vector , request, response );
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
