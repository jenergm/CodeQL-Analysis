/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_75b.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-75b.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  Set data to a hardcoded value
 * GoodSource: Read data from the console using readLine()
 * Sinks:
 *    BadSink : Use data as a cryptographic key
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_75b
{

    public void bad_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            String data = (String)in.readObject();

            if (data != null)
            {
                String sToEncrypt = "Super secret Squirrel";
                byte[] bToEncrypt = sToEncrypt.getBytes("UTF-8");
                /* POTENTIAL FLAW: Use data as a cryptographic key */
                SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes("UTF-8"), "AES");
                Cipher aesCipher = Cipher.getInstance("AES");
                aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
                byte[] bCipherText = aesCipher.doFinal(bToEncrypt);
                IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */
            }

        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            String data = (String)in.readObject();

            if (data != null)
            {
                String sToEncrypt = "Super secret Squirrel";
                byte[] bToEncrypt = sToEncrypt.getBytes("UTF-8");
                /* POTENTIAL FLAW: Use data as a cryptographic key */
                SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes("UTF-8"), "AES");
                Cipher aesCipher = Cipher.getInstance("AES");
                aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
                byte[] bCipherText = aesCipher.doFinal(bToEncrypt);
                IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */
            }

        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }

}
