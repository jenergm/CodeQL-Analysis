/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_81_bad.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_81_bad extends CWE319_Cleartext_Tx_Sensitive_Info__send_81_base
{

    public void action(String data ) throws Throwable
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

}
