/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_16.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 319 Cleartext Transmission of Sensitive Information
* BadSource:  Establish data as a password
* GoodSource: Use a regular string (non-sensitive string)
* Sinks:
*    GoodSink: encrypted channel
*    BadSink : unencrypted channel
* Flow Variant: 16 Control flow: while(true) and while(local_f)
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

public class CWE319_Cleartext_Tx_Sensitive_Info__send_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
            break;
        }

        while(true)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
            break;
        }

        while(true)
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
            break;
        }

        while(local_f)
        {
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
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
            break;
        }

        while(true)
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
            break;
        }

        while(local_f)
        {
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
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a regular string (non-sensitive string) */
            data = "Hello World";
            break;
        }

        while(true)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
             * channel in the sink */
            data = new String(creds.getPassword());
            break;
        }

        while(local_f)
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
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
