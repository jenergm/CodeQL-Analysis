/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__aes_encrypted_payload_08.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: aes_encrypted_payload
*    GoodSink: Use a plaintext command
*    BadSink : Use an AES encrypted payload in an attempt to hide the command
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.logging.Level;

import javax.servlet.http.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CWE506_Embedded_Malicious_Code__aes_encrypted_payload_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            /* FLAW: encrytped "calc.exe" */
            String payload = "0297b5eb43e3b81f9c737b353c3ade45";
            Cipher aes = Cipher.getInstance("AES");
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            /* INCIDENTAL: Hardcoded crypto */
            SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aes.init(Cipher.DECRYPT_MODE, keySpec);
            /* Convert hex string to byte array without the use of a library
               adopted from: http://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java */
            int len = payload.length();
            byte[] data = new byte[len/2];
            for (int i = 0; i < len; i+=2)
            {
                data[i/2] = (byte)((Character.digit(payload.charAt(i), 16) << 4) + Character.digit(payload.charAt(i+1), 16));
            }
            String decryptedPayload = new String(aes.doFinal(data), "UTF-8");
            try
            {
                Runtime.getRuntime().exec(decryptedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: encrytped "calc.exe" */
            String payload = "0297b5eb43e3b81f9c737b353c3ade45";
            Cipher aes = Cipher.getInstance("AES");
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            /* INCIDENTAL: Hardcoded crypto */
            SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aes.init(Cipher.DECRYPT_MODE, keySpec);
            /* Convert hex string to byte array without the use of a library
               adopted from: http://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java */
            int len = payload.length();
            byte[] data = new byte[len/2];
            for (int i = 0; i < len; i+=2)
            {
                data[i/2] = (byte)((Character.digit(payload.charAt(i), 16) << 4) + Character.digit(payload.charAt(i+1), 16));
            }
            String decryptedPayload = new String(aes.doFinal(data), "UTF-8");
            try
            {
                Runtime.getRuntime().exec(decryptedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        else {

            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            /* FIX: plaintext command */
            String decodedPayload = "calc.exe";
            try
            {
                Runtime.getRuntime().exec(decodedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: encrytped "calc.exe" */
            String payload = "0297b5eb43e3b81f9c737b353c3ade45";

            Cipher aes = Cipher.getInstance("AES");
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            /* INCIDENTAL: Hardcoded crypto */
            SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
            aes.init(Cipher.DECRYPT_MODE, keySpec);

            /* Convert hex string to byte array without the use of a library
               adopted from: http://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java */
            int len = payload.length();
            byte[] data = new byte[len/2];
            for (int i = 0; i < len; i+=2)
            {
                data[i/2] = (byte)((Character.digit(payload.charAt(i), 16) << 4) + Character.digit(payload.charAt(i+1), 16));
            }

            String decryptedPayload = new String(aes.doFinal(data), "UTF-8");

            try
            {
                Runtime.getRuntime().exec(decryptedPayload);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error executing command", e);
            }

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
