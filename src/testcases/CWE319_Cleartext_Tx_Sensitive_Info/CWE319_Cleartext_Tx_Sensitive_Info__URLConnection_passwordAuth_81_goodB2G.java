/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_81_goodB2G.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: URLConnection Read password from a web server with URLConnection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import java.sql.*;

import java.net.PasswordAuthentication;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_81_goodB2G extends CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_81_base
{

    public void action(String password ) throws Throwable
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

}
