/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_81a.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource:  Read password from a .properties file (from the property named password)
 * GoodSource: Read password from a .properties file (from the property named password) and then decrypt it
 * Sinks:
 *    GoodSink: Decrypt password and use decrypted password as password to connect to DB
 *    BadSink : Use password as password to connect to DB
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE256_Plaintext_Storage_of_Password__basic_81a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            password = props.getProperty("password");
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( finstr != null )
                {
                    finstr.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
            }
        }

        /* POTENTIAL FLAW: The raw password read from the .properties file is passed on (without being decrypted) */

        CWE256_Plaintext_Storage_of_Password__basic_81_base o = new CWE256_Plaintext_Storage_of_Password__basic_81_bad();
        o.action(password );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* retrieve the property */
        Properties props2 = new Properties();

        FileInputStream finstr2 = null;
        try {
            finstr2 = new FileInputStream("../common/config.properties");
            props2.load(finstr2);

            password = props2.getProperty("password");
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( finstr2 != null )
                {
                    finstr2.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
            }
        }

        /* FIX: password is decrypted before being passed on */
        {
            Cipher aes = Cipher.getInstance("AES");
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
            SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aes.init(Cipher.DECRYPT_MODE, keySpec);

            String pw = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
            password = pw;
        }

        CWE256_Plaintext_Storage_of_Password__basic_81_base o = new CWE256_Plaintext_Storage_of_Password__basic_81_goodG2B();
        o.action(password );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String password;

        password = ""; /* init password */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            password = props.getProperty("password");
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( finstr != null )
                {
                    finstr.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
            }
        }

        /* POTENTIAL FLAW: The raw password read from the .properties file is passed on (without being decrypted) */

        CWE256_Plaintext_Storage_of_Password__basic_81_base o = new CWE256_Plaintext_Storage_of_Password__basic_81_goodB2G();
        o.action(password );
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
