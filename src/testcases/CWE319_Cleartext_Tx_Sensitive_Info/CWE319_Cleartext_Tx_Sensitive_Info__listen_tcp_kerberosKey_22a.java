/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_22a.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-22a.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: kerberosKey
 *    GoodSink: Decrypt password before using in KerberosKey()
 *    BadSink : Use password directly in KerberosKey()
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_22a extends AbstractTestCase
{

    /* The public static variable below is used to drive control flow in the sink function.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean bad_public_static = false;

    public void bad() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* Read data using a listening tcp connection */
        {
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;

            try {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read password using a listening tcp connection */
                password = buffread.readLine();
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

                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                }
            }
        }

        bad_public_static = true;
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_22b()).bad_sink(password );
    }

    /* The public static variables below are used to drive control flow in the sink functions.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodB2G1_public_static = false;
    public static boolean goodB2G2_public_static = false;
    public static boolean goodG2B_public_static = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* Read data using a listening tcp connection */
        {
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;

            try {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read password using a listening tcp connection */
                password = buffread.readLine();
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

                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                }
            }
        }

        goodB2G1_public_static = false;
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_22b()).goodB2G1_sink(password );
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* Read data using a listening tcp connection */
        {
            ServerSocket listener = null;
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;

            try {
                /* read input from socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read password using a listening tcp connection */
                password = buffread.readLine();
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

                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                }
            }
        }

        goodB2G2_public_static = true;
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_22b()).goodB2G2_sink(password );
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String password;

        /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
        /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
        password = "Password1234!";

        goodG2B_public_static = true;
        (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_22b()).goodG2B_sink(password );
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
