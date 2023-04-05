/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_05.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
* BadSource:  Read password from a .properties file (from the property named password)
* GoodSource: Read password from a .properties file (from the property named password) and then decrypt it
* Sinks:
*    GoodSink: Decrypt password and use decrypted password as password to connect to DB
*    BadSink : Use password as password to connect to DB
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
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

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import java.sql.SQLException;

public class CWE256_Plaintext_Storage_of_Password__basic_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        String password;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            password = ""; /* init password */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                password = props.getProperty("password");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: password is decrypted before being used as a database password */
            {
                Cipher aes2 = Cipher.getInstance("AES");
                KeyGenerator kg2 = KeyGenerator.getInstance("AES");
                kg2.init(128);
                /* INCIDENTAL: Hardcoded crypto */
                SecretKeySpec keySpec2 = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes2.init(Cipher.DECRYPT_MODE, keySpec2);

                String pw2 = new String(aes2.doFinal(password.getBytes("UTF-8")), "UTF-8");
                password = pw2;
            }

            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_t to private_f */
    private void goodG2B1() throws Throwable
    {
        String password;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            password = ""; /* init password */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                password = props.getProperty("password");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {

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

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: password is decrypted before being used as a database password */
            {
                Cipher aes2 = Cipher.getInstance("AES");
                KeyGenerator kg2 = KeyGenerator.getInstance("AES");
                kg2.init(128);
                /* INCIDENTAL: Hardcoded crypto */
                SecretKeySpec keySpec2 = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes2.init(Cipher.DECRYPT_MODE, keySpec2);

                String pw2 = new String(aes2.doFinal(password.getBytes("UTF-8")), "UTF-8");
                password = pw2;
            }

            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String password;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            password = ""; /* init password */
            /* retrieve the property */
            Properties props2 = new Properties();
            FileInputStream finstr2 = null;
            try
            {
                finstr2 = new FileInputStream("../common/config.properties");
                props2.load(finstr2);
                password = props2.getProperty("password");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: password is decrypted before being used as a database password */
            {
                Cipher aes2 = Cipher.getInstance("AES");
                KeyGenerator kg2 = KeyGenerator.getInstance("AES");
                kg2.init(128);
                /* INCIDENTAL: Hardcoded crypto */
                SecretKeySpec keySpec2 = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes2.init(Cipher.DECRYPT_MODE, keySpec2);

                String pw2 = new String(aes2.doFinal(password.getBytes("UTF-8")), "UTF-8");
                password = pw2;
            }

            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_t to private_f */
    private void goodB2G1() throws Throwable
    {
        String password;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            password = ""; /* init password */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                password = props.getProperty("password");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }
        }
        else {

            /* FIX: password is decrypted before being used as a database password */
            {
                Cipher aes2 = Cipher.getInstance("AES");
                KeyGenerator kg2 = KeyGenerator.getInstance("AES");
                kg2.init(128);
                /* INCIDENTAL: Hardcoded crypto */
                SecretKeySpec keySpec2 = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes2.init(Cipher.DECRYPT_MODE, keySpec2);

                String pw2 = new String(aes2.doFinal(password.getBytes("UTF-8")), "UTF-8");
                password = pw2;
            }

            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String password;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            password = ""; /* init password */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                password = props.getProperty("password");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* FIX: password is decrypted before being used as a database password */
            {
                Cipher aes2 = Cipher.getInstance("AES");
                KeyGenerator kg2 = KeyGenerator.getInstance("AES");
                kg2.init(128);
                /* INCIDENTAL: Hardcoded crypto */
                SecretKeySpec keySpec2 = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes2.init(Cipher.DECRYPT_MODE, keySpec2);
                String pw2 = new String(aes2.doFinal(password.getBytes("UTF-8")), "UTF-8");
                password = pw2;
            }
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Use password as a password to connect to a DB  (without being decrypted) */

            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", password);
            }
            catch(SQLException se)
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
