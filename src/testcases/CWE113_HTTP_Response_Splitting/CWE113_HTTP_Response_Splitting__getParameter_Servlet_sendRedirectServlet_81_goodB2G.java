/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getParameter_Servlet_sendRedirectServlet_81_goodB2G.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks: sendRedirectServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to sendRedirect()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getParameter_Servlet_sendRedirectServlet_81_goodB2G extends CWE113_HTTP_Response_Splitting__getParameter_Servlet_sendRedirectServlet_81_base
{

    public void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-8");
            response.sendRedirect("/author.jsp?lang=" + data);
        }

    }

}
