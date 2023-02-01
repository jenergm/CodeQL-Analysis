/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_getCookies_Servlet_19.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 601 Open Redirect
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* BadSink:  place redirect string directly into redirect api call
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.*;

public class CWE601_Open_Redirect__Servlet_getCookies_Servlet_19 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            data = ""; /* initialize data in case there are no cookies */

            /* Read data from cookies */
            {
                Cookie cookieSources[] = request.getCookies();
                if (cookieSources != null)
                {
                    /* POTENTIAL FLAW: Read data from the first cookie value */
                    data = cookieSources[0].getValue();
                }
            }

            if (data != null)
            {
                /* This prevents \r\n (and other chars) and should prevent incidentals such
                 * as HTTP Response Splitting and HTTP Header Injection.
                */
                URI u;
                try
                {
                    u = new URI(data);
                }
                catch (URISyntaxException e)
                {
                    response.getWriter().write("Invalid redirect URL");
                    return;
                }
                /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
                response.sendRedirect(data);
                return;
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
                /* This prevents \r\n (and other chars) and should prevent incidentals such
                 * as HTTP Response Splitting and HTTP Header Injection.
                */
                URI u;
                try
                {
                    u = new URI(data);
                }
                catch (URISyntaxException e)
                {
                    response.getWriter().write("Invalid redirect URL");
                    return;
                }
                /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
                response.sendRedirect(data);
                return;
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
                /* This prevents \r\n (and other chars) and should prevent incidentals such
                 * as HTTP Response Splitting and HTTP Header Injection.
                */
                URI u;
                try
                {
                    u = new URI(data);
                }
                catch (URISyntaxException e)
                {
                    response.getWriter().write("Invalid redirect URL");
                    return;
                }
                /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
                response.sendRedirect(data);
                return;
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            data = ""; /* initialize data in case there are no cookies */

            /* Read data from cookies */
            {
                Cookie cookieSources[] = request.getCookies();
                if (cookieSources != null)
                {
                    /* POTENTIAL FLAW: Read data from the first cookie value */
                    data = cookieSources[0].getValue();
                }
            }

            if (data != null)
            {
                /* This prevents \r\n (and other chars) and should prevent incidentals such
                 * as HTTP Response Splitting and HTTP Header Injection.
                */
                URI u;
                try
                {
                    u = new URI(data);
                }
                catch (URISyntaxException e)
                {
                    response.getWriter().write("Invalid redirect URL");
                    return;
                }
                /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
                response.sendRedirect(data);
                return;
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
