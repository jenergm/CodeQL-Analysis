/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_67b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_67b
{

    public void bad_sink(CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_67a.Container password_container ) throws Throwable
    {
        String password = password_container.a;

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(pa.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_67a.Container password_container ) throws Throwable
    {
        String password = password_container.a;

        if (password != null)
        {
            /* POTENTIAL FLAW: Use password directly in PasswordAuthentication() */
            PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
            IO.writeLine(pa.toString());
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_passwordAuth_67a.Container password_container ) throws Throwable
    {
        String password = password_container.a;

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
