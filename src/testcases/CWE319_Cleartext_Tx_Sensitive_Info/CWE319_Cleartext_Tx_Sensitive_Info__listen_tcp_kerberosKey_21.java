/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_21.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: kerberosKey
 *    GoodSink: Decrypt password before using in KerberosKey()
 *    BadSink : Use password directly in KerberosKey()
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
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

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_kerberosKey_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

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

        bad_private = true;
        bad_sink(password );
    }

    private void bad_sink(String password ) throws Throwable
    {
        if(bad_private)
        {
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* POTENTIAL FLAW: Use password directly in KerberosKey() */
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
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

        goodB2G1_private = false;
        goodB2G1_sink(password );
    }

    private void goodB2G1_sink(String password ) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* POTENTIAL FLAW: Use password directly in KerberosKey() */
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
        else {

            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
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

        goodB2G2_private = true;
        goodB2G2_sink(password );
    }

    private void goodB2G2_sink(String password ) throws Throwable
    {
        if(goodB2G2_private)
        {
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* POTENTIAL FLAW: Use password directly in KerberosKey() */
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }

        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String password;

        /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
        /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
        password = "Password1234!";

        goodG2B_private = true;
        goodG2B_sink(password );
    }

    private void goodG2B_sink(String password ) throws Throwable
    {
        if(goodG2B_private)
        {
            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* POTENTIAL FLAW: Use password directly in KerberosKey() */
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (password != null)
            {
                KerberosPrincipal principal = new KerberosPrincipal("test");
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
                IO.writeLine(key.toString());
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
