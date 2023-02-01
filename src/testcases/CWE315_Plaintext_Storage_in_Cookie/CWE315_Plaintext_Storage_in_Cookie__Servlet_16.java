/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_Cookie__Servlet_16.java
Label Definition File: CWE315_Plaintext_Storage_in_Cookie__Servlet.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 315 Storing plaintext data in a cookie
* BadSource:  Set data to credentials (without hashing or encryption)
* GoodSource: Set data to a hash of credentials
* Sinks:
*    GoodSink: Hash data before storing in cookie
*    BadSink : Store data directly in cookie
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE315_Plaintext_Storage_in_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

import java.net.PasswordAuthentication;

public class CWE315_Plaintext_Storage_in_Cookie__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
            break;
        }

        while(true)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));
            break;
        }

        while(true)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Hash data before storing in cookie */
            {
                String salt = "ThisIsMySalt";
                MessageDigest dig = MessageDigest.getInstance("SHA-512");
                dig.reset();
                byte[] bHashedCreds = dig.digest((salt+data).getBytes("UTF-8"));
                data = IO.toHex(bHashedCreds);
            }
            response.addCookie(new Cookie("auth", data));
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));
            break;
        }

        while(true)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Hash data before storing in cookie */
            {
                String salt = "ThisIsMySalt";
                MessageDigest dig = MessageDigest.getInstance("SHA-512");
                dig.reset();
                byte[] bHashedCreds = dig.digest((salt+data).getBytes("UTF-8"));
                data = IO.toHex(bHashedCreds);
            }
            response.addCookie(new Cookie("auth", data));
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
            break;
        }

        while(true)
        {
            /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
            PasswordAuthentication bsCreds = new PasswordAuthentication("user", "BP@ssw0rd".toCharArray());
            /* POTENTIAL FLAW: Set data to credentials (without hashing or encryption) */
            data = bsCreds.getUserName() + ":" + (new String(bsCreds.getPassword()));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* POTENTIAL FLAW: Store data directly in cookie */
            response.addCookie(new Cookie("auth", data));
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
