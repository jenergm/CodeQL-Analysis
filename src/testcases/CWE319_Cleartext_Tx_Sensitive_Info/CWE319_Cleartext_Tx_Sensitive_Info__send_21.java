/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_21.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

import java.net.PasswordAuthentication;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

    public void bad() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(creds.getPassword());

        bad_private = true;
        bad_sink(data );
    }

    private void bad_sink(String data ) throws Throwable
    {
        if(bad_private)
        {
            Socket sock = null;
            PrintWriter out = null;
            try
            {
                sock = new Socket("remote_host", 1337);
                out = new PrintWriter(sock.getOutputStream(), true);
                /* POTENTIAL FLAW: sending data over an unencrypted (non-SSL) channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            PrintWriter out = null;

            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);
                out = new PrintWriter(sslsocket.getOutputStream(), true);
                /* FIX: sending data over an SSL encrypted channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing SSLSocket", ioe);
                }
            }

        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1_private = false;
    private boolean goodB2G2_private = false;
    private boolean goodG2B_private = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(creds.getPassword());

        goodB2G1_private = false;
        goodB2G1_sink(data );
    }

    private void goodB2G1_sink(String data ) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Socket sock = null;
            PrintWriter out = null;
            try
            {
                sock = new Socket("remote_host", 1337);
                out = new PrintWriter(sock.getOutputStream(), true);
                /* POTENTIAL FLAW: sending data over an unencrypted (non-SSL) channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", ioe);
                }
            }
        }
        else {

            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            PrintWriter out = null;

            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);
                out = new PrintWriter(sslsocket.getOutputStream(), true);
                /* FIX: sending data over an SSL encrypted channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing SSLSocket", ioe);
                }
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(creds.getPassword());

        goodB2G2_private = true;
        goodB2G2_sink(data );
    }

    private void goodB2G2_sink(String data ) throws Throwable
    {
        if(goodB2G2_private)
        {
            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            PrintWriter out = null;
            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);
                out = new PrintWriter(sslsocket.getOutputStream(), true);
                /* FIX: sending data over an SSL encrypted channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing SSLSocket", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Socket sock = null;
            PrintWriter out = null;

            try
            {
                sock = new Socket("remote_host", 1337);
                out = new PrintWriter(sock.getOutputStream(), true);
                /* POTENTIAL FLAW: sending data over an unencrypted (non-SSL) channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", ioe);
                }
            }

        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a regular string (non-sensitive string) */
        data = "Hello World";

        goodG2B_private = true;
        goodG2B_sink(data );
    }

    private void goodG2B_sink(String data ) throws Throwable
    {
        if(goodG2B_private)
        {
            Socket sock = null;
            PrintWriter out = null;
            try
            {
                sock = new Socket("remote_host", 1337);
                out = new PrintWriter(sock.getOutputStream(), true);
                /* POTENTIAL FLAW: sending data over an unencrypted (non-SSL) channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            PrintWriter out = null;

            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);
                out = new PrintWriter(sslsocket.getOutputStream(), true);
                /* FIX: sending data over an SSL encrypted channel */
                out.println(data);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to the socket", ioe);
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }

                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing SSLSocket", ioe);
                }
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
