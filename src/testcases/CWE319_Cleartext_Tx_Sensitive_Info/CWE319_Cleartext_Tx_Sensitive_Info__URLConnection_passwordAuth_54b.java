/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_54b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: URLConnection Read password from a web server with URLConnection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: passwordAuth
 *    GoodSink: Decrypt password before using in PasswordAuthentication()
 *    BadSink : Use password directly in PasswordAuthentication()
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
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

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_54b
{

    public void bad_sink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_54c()).bad_sink(password );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_54c()).goodG2B_sink(password );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_passwordAuth_54c()).goodB2G_sink(password );
    }
}
