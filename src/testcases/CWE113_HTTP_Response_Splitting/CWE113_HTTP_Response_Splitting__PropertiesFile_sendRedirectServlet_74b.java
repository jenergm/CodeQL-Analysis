/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_74b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: sendRedirectServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to sendRedirect()
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
            response.sendRedirect("/author.jsp?lang=" + data);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
            response.sendRedirect("/author.jsp?lang=" + data);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(HashMap<Integer,String> data_hashmap , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-8");
            response.sendRedirect("/author.jsp?lang=" + data);
        }

    }
}
