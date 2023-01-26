/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE81_XSS_Error_Message__Servlet_getQueryString_Servlet_19.java
Label Definition File: CWE81_XSS_Error_Message__Servlet.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 81 Cross Site Scripting (XSS) in Error Message
* BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
* GoodSource: A hardcoded string
* BadSink: sendErrorServlet XSS in sendError
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE81_XSS_Error_Message;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;

public class CWE81_XSS_Error_Message__Servlet_getQueryString_Servlet_19 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

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

            if (data != null)
            {
                /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client; The built-in J2EE server automatically does some HTML entity encoding.  Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
                */
                response.sendError(404, "<br>bad() - Parameter name has value " + data);
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

            if (data != null)
            {
                /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client; The built-in J2EE server automatically does some HTML entity encoding.  Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
                */
                response.sendError(404, "<br>bad() - Parameter name has value " + data);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

            if (data != null)
            {
                /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client; The built-in J2EE server automatically does some HTML entity encoding.  Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
                */
                response.sendError(404, "<br>bad() - Parameter name has value " + data);
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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

            if (data != null)
            {
                /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client; The built-in J2EE server automatically does some HTML entity encoding.  Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
                */
                response.sendError(404, "<br>bad() - Parameter name has value " + data);
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
