/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE327_Use_Broken_Crypto__DES_14.java
Label Definition File: CWE327_Use_Broken_Crypto__DES.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 327 Use of Broken or Risky Cryptographic Algorithm
* Sinks:
*    GoodSink: use AES
*    BadSink : use DES
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE327_Use_Broken_Crypto;

import testcasesupport.*;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CWE327_Use_Broken_Crypto__DES_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_five==5)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            /* Perform initialization of KeyGenerator */
            keygen.init(256);
            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();
            /* FLAW: Use a weak crypto algorithm, DES */
            SecretKeySpec skSpec = new SecretKeySpec(raw, "DES");
            Cipher c = Cipher.getInstance("DES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);
            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            final String CIPHER_INPUT = "ABCDEFG123456";

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            /* Perform initialization of KeyGenerator */
            keygen.init(256);

            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();

            /* FIX: Use a stronger crypto algorithm, AES */
            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");

            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);

            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(encrypted));

        }
    }

    /* good1() changes IO.static_five==5 to IO.static_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            /* Perform initialization of KeyGenerator */
            keygen.init(256);
            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();
            /* FLAW: Use a weak crypto algorithm, DES */
            SecretKeySpec skSpec = new SecretKeySpec(raw, "DES");
            Cipher c = Cipher.getInstance("DES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);
            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
        else {

            final String CIPHER_INPUT = "ABCDEFG123456";

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            /* Perform initialization of KeyGenerator */
            keygen.init(256);

            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();

            /* FIX: Use a stronger crypto algorithm, AES */
            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");

            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);

            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(encrypted));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_five==5)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            /* Perform initialization of KeyGenerator */
            keygen.init(256);
            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();
            /* FIX: Use a stronger crypto algorithm, AES */
            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);
            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            final String CIPHER_INPUT = "ABCDEFG123456";

            KeyGenerator keygen = KeyGenerator.getInstance("DES");

            /* Perform initialization of KeyGenerator */
            keygen.init(256);

            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();

            /* FLAW: Use a weak crypto algorithm, DES */
            SecretKeySpec skSpec = new SecretKeySpec(raw, "DES");

            Cipher c = Cipher.getInstance("DES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);

            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(encrypted));

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
