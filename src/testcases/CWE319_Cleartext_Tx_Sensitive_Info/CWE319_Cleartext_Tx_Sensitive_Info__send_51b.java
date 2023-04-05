/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_51b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
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

public class CWE319_Cleartext_Tx_Sensitive_Info__send_51b
{

    public void bad_sink(String data ) throws Throwable
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
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
}
