/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_81_goodB2G.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Set data to credentials (without hashing or encryption)
 * GoodSource: Set data to a hash of credentials
 * Sinks:
 *    GoodSink: Hash data before storing in cookie
 *    BadSink : Store data directly in cookie
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_81_goodB2G extends CWE315_Plaintext_Storage_in_Cookie__Servlet_81_base
{

    public void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
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
