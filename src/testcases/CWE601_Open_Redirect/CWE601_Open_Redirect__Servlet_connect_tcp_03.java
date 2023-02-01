/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_connect_tcp_03.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-03.tmpl.java
*/
/*
* @description
* CWE: 601 Open Redirect
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* BadSink:  place redirect string directly into redirect api call
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;
import java.net.URI;
import java.net.URISyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE601_Open_Redirect__Servlet_connect_tcp_03 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(5==5)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

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

    /* goodG2B1() - use goodsource and badsink by changing 5==5 to 5!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(5==5)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);

                    /* read input from socket */

                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
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

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
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
