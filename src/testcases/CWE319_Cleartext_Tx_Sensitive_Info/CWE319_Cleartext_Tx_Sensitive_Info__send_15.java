/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_15.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 319 Cleartext Transmission of Sensitive Information
* BadSource:  Establish data as a password
* GoodSource: Use a regular string (non-sensitive string)
* Sinks:
*    GoodSink: encrypted channel
*    BadSink : unencrypted channel
* Flow Variant: 15 Control flow: switch(6) and switch(7)
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

public class CWE319_Cleartext_Tx_Sensitive_Info__send_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
        }
        break;
        default:
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        default:
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
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
