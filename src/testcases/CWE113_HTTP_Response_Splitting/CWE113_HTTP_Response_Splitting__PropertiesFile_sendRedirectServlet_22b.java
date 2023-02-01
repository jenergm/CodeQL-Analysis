/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_22b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: sendRedirectServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to sendRedirect()
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_22b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_22a.bad_public_static)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
                response.sendRedirect("/author.jsp?lang=" + data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                data = URLEncoder.encode(data, "UTF-8");
                response.sendRedirect("/author.jsp?lang=" + data);
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_22a.goodB2G1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (data != null)
            {
                /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
                response.sendRedirect("/author.jsp?lang=" + data);
            }
        }
        else {

            if (data != null)
            {
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                data = URLEncoder.encode(data, "UTF-8");
                response.sendRedirect("/author.jsp?lang=" + data);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_22a.goodB2G2_public_static)
        {
            if (data != null)
            {
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                data = URLEncoder.encode(data, "UTF-8");
                response.sendRedirect("/author.jsp?lang=" + data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
                response.sendRedirect("/author.jsp?lang=" + data);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__PropertiesFile_sendRedirectServlet_22a.goodG2B_public_static)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
                response.sendRedirect("/author.jsp?lang=" + data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                data = URLEncoder.encode(data, "UTF-8");
                response.sendRedirect("/author.jsp?lang=" + data);
            }

        }
    }
}
