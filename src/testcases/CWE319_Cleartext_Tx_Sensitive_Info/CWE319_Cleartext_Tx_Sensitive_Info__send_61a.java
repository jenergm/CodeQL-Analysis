/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_61a.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data = (new CWE319_Cleartext_Tx_Sensitive_Info__send_61b()).bad_source();

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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = (new CWE319_Cleartext_Tx_Sensitive_Info__send_61b()).goodG2B_source();

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data = (new CWE319_Cleartext_Tx_Sensitive_Info__send_61b()).goodB2G_source();

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
