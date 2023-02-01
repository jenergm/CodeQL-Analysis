/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_61b.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

import java.net.PasswordAuthentication;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_61b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
        data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication gsCreds = new PasswordAuthentication("user", "GP@ssw0rd".toCharArray());

        /* FIX: Set data to a hash of credentials */
        {
            String salt = "ThisIsMySalt";
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            String credsToHash = gsCreds.getUserName() + ":" + (new String(gsCreds.getPassword()));
            byte[] bHashedCreds = dig.digest((salt+credsToHash).getBytes("UTF-8"));
            data = IO.toHex(bHashedCreds);
        }

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
        data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));

        return data;
    }
}
