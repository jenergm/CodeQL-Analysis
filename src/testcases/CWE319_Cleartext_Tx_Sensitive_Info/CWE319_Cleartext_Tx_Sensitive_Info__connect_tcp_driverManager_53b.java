/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_53b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: connect_tcp Read password using an outbound tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_53b
{

    public void bad_sink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_53c()).bad_sink(password );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_53c()).goodG2B_sink(password );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String password ) throws Throwable
    {
        (new CWE319_Cleartext_Tx_Sensitive_Info__connect_tcp_driverManager_53c()).goodB2G_sink(password );
    }
}
