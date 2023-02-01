/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_54d.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_54d
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE315_Plaintext_Storage_in_Cookie__Servlet_54e()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE315_Plaintext_Storage_in_Cookie__Servlet_54e()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE315_Plaintext_Storage_in_Cookie__Servlet_54e()).goodB2G_sink(data , request, response);
    }
}
