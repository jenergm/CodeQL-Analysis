/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__basic_81_bad.java
Label Definition File: CWE256_Plaintext_Storage_of_Password__basic.label.xml
Template File: sources-sinks-81_bad.tmpl.java
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
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class CWE256_Plaintext_Storage_of_Password__basic_81_bad extends CWE256_Plaintext_Storage_of_Password__basic_81_base
{

    public void action(String password ) throws Throwable
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

}
