/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_12.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 319 Cleartext Transmission of Sensitive Information
* BadSource: URLConnection Read password from a web server with URLConnection
* GoodSource: Set password to a hardcoded value (one that was not sent over the network)
* Sinks: passwordAuth
*    GoodSink: Decrypt password before using in PasswordAuthentication()
*    BadSink : Use password directly in PasswordAuthentication()
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String password;
        if(IO.static_returns_t_or_f())
        {
            password = ""; /* init password */
            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read password from a web server with URLConnection */
                    password = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
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
        }
        else {

            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";

        }
        if(IO.static_returns_t_or_f())
        {
            if (password != null)
            {
                /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }
        }
        else {

            if (password != null)
            {
                /* FIX: Decrypt password before using in PasswordAuthentication() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        String password;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";
        }
        else {

            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";

        }
        if(IO.static_returns_t_or_f())
        {
            if (password != null)
            {
                /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }
        }
        else {

            if (password != null)
            {
                /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        String password;
        if(IO.static_returns_t_or_f())
        {
            password = ""; /* init password */
            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read password from a web server with URLConnection */
                    password = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
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
        }
        else {

            password = ""; /* init password */

            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read password from a web server with URLConnection */
                    password = buffread.readLine(); // This will be reading the first "line" of the response body,
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

        }
        if(IO.static_returns_t_or_f())
        {
            if (password != null)
            {
                /* FIX: Decrypt password before using in PasswordAuthentication() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }
        }
        else {

            if (password != null)
            {
                /* FIX: Decrypt password before using in PasswordAuthentication() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }

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
