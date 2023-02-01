/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_22b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: addCookieServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addCookie()
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_22b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_22a.bad_public_static)
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
                response.addCookie(cookieSink);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8"));
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                response.addCookie(cookieSink);
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_22a.goodB2G1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
                response.addCookie(cookieSink);
            }
        }
        else {

            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8"));
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                response.addCookie(cookieSink);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_22a.goodB2G2_public_static)
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8"));
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                response.addCookie(cookieSink);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
                response.addCookie(cookieSink);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_22a.goodG2B_public_static)
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
                response.addCookie(cookieSink);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8"));
                /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
                response.addCookie(cookieSink);
            }

        }
    }
}
