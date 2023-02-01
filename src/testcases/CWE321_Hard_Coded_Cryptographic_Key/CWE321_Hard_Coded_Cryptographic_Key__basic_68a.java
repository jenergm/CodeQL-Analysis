/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_68a.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  Set data to a hardcoded value
 * GoodSource: Read data from the console using readLine()
 * BadSink:  Use data as a cryptographic key
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_68a extends AbstractTestCase
{

    public static String data;

    public void bad() throws Throwable
    {

        /* FLAW: Set data to a hardcoded value */
        data = "23 ~j;asn!@#/>as";

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_68b()).bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        data = ""; /* Initialize data */

        /* read user input from console with readLine */
        try {
            InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
            BufferedReader buffread = new BufferedReader(isr);

            /* FIX: Read data from the console using readLine() */
            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
        }
        /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_68b()).goodG2B_sink();
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
