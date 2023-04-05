/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_12.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: console_readLine Read data from the console using readLine()
* GoodSource: A hardcoded string
* Sinks: addHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addHeader()
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }
        }
        else {

            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8");
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }
        }
        else {

            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {

            data = ""; /* Initialize data */

            /* read user input from console with readLine */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        if(IO.static_returns_t_or_f())
        {
            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8");
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }
        }
        else {

            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8");
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
