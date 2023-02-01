/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_URLConnection_51a.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-51a.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * BadSink:  place redirect string directly into redirect api call
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
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
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE601_Open_Redirect__Servlet_URLConnection_51a extends AbstractTestCaseServlet
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

        (new CWE601_Open_Redirect__Servlet_URLConnection_51b()).bad_sink(data , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE601_Open_Redirect__Servlet_URLConnection_51b()).goodG2B_sink(data , request, response );
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
