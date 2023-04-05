/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_75b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-75b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import java.sql.*;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_passwordAuth_75b
{

    public void bad_sink(byte[] password_serialized ) throws Throwable
    {

        // unserialize password
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(password_serialized);
            in = new ObjectInputStream(bais);
            String password = (String)in.readObject();

            if (password != null)
            {
                /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }

        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(byte[] password_serialized ) throws Throwable
    {

        // unserialize password
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(password_serialized);
            in = new ObjectInputStream(bais);
            String password = (String)in.readObject();

            if (password != null)
            {
                /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
                PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
                IO.writeLine(pa.toString());
            }

        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(byte[] password_serialized ) throws Throwable
    {

        // unserialize password
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(password_serialized);
            in = new ObjectInputStream(bais);
            String password = (String)in.readObject();

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
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }
}
