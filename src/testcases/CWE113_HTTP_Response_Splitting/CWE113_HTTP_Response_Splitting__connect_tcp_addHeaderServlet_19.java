/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_19.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: addHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addHeader()
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__connect_tcp_addHeaderServlet_19 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

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

        {

            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8");
                response.addHeader("Location", "/author.jsp?lang=" + data);
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

            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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

            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

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

        {

            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8");
                response.addHeader("Location", "/author.jsp?lang=" + data);
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* POTENTIAL FLAW: Input from file not verified */
            if (data != null)
            {
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
