/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookies_Servlet_addHeaderServlet_74b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: addHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addHeader()
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getCookies_Servlet_addHeaderServlet_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        /* POTENTIAL FLAW: Input from file not verified */
        if (data != null)
        {
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        if (data != null)
        {
            data = URLEncoder.encode(data, "UTF-8");
            response.addHeader("Location", "/author.jsp?lang=" + data);
        }

    }
}
