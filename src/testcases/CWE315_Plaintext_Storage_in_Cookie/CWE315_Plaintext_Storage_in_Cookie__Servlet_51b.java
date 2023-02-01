/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_51b.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_51b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

        /* POTENTIAL FLAW: Store data directly in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */

        /* POTENTIAL FLAW: Store data directly in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: Hash data before storing in cookie */
        {
            String salt = "ThisIsMySalt";
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest((salt+data).getBytes("UTF-8"));
            data = IO.toHex(bHashedCreds);
        }
        response.addCookie(new Cookie("auth", data));

    }
}
