/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_72b.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource:  Read password from a .properties file (from the property named password)
 * GoodSource: Read password from a .properties file (from the property named password) and then decrypt it
 * Sinks:
 *    GoodSink: Decrypt password and use decrypted password as password to connect to DB
 *    BadSink : Use password as password to connect to DB
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;
import java.util.Vector;

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

public class CWE256_Plaintext_Storage_of_Password__basic_72b
{

    public void bad_sink(Vector<String> password_vector ) throws Throwable
    {
        String password = password_vector.remove(2);

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

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(Vector<String> password_vector ) throws Throwable
    {
        String password = password_vector.remove(2);

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

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(Vector<String> password_vector ) throws Throwable
    {
        String password = password_vector.remove(2);

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
