/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_connect_tcp_divide_45.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__float_connect_tcp_divide_45 extends AbstractTestCase
{

    private float bad_data;
    private float goodG2B_data;
    private float goodB2G_data;

    private void bad_sink() throws Throwable
    {
        float data = bad_data;

        /* POTENTIAL FLAW: Possibly divide by zero */
        int result = (int)(100.0 / data);
        IO.writeLine(result);

    }

    public void bad() throws Throwable
    {
        float data;

        data = -1.0f; /* Initialize data */

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
                String s_data = buffread.readLine();
                if (s_data != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Float.parseFloat(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }

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

        bad_data = data;
        bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2B_sink() throws Throwable
    {
        float data = goodG2B_data;

        /* POTENTIAL FLAW: Possibly divide by zero */
        int result = (int)(100.0 / data);
        IO.writeLine(result);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        float data;

        /* FIX: Use a hardcoded number that won't a divide by zero */
        data = 2.0f;

        goodG2B_data = data;
        goodG2B_sink();
    }

    private void goodB2G_sink() throws Throwable
    {
        float data = goodB2G_data;

        /* FIX: Check for value of or near zero before dividing */
        if( Math.abs(data) > 0.000001 )
        {
            int result = (int)(100.0 / data);
            IO.writeLine(result);
        }
        else
        {
            IO.writeLine("This would result in a divide by zero");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        float data;

        data = -1.0f; /* Initialize data */

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
                String s_data = buffread.readLine();
                if (s_data != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Float.parseFloat(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }

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

        goodB2G_data = data;
        goodB2G_sink();
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
