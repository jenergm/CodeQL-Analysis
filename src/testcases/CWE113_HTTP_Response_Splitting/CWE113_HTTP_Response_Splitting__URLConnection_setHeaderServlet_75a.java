/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_75a.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-75a.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_75a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            }
        }

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_75b()).bad_sink(data_serialized , request, response );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_75b()).goodG2B_sink(data_serialized , request, response );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            }
        }

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_75b()).goodB2G_sink(data_serialized , request, response );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
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
