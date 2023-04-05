/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__KeyGenerator_init_05.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: KeyGenerator_init
*    GoodSink: Include call to KeyGenerator.init()
*    BadSink : Missing call to KeyGenerator.init()
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE325_Missing_Required_Cryptographic_Step;

import testcasesupport.*;

import java.security.NoSuchAlgorithmException;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CWE325_Missing_Required_Cryptographic_Step__KeyGenerator_init_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        if (private_t)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            /* FLAW: Skip initialization of KeyGenerator (like 'keygen.init(128);') According to the KeyGenerator JavaDoc: "In case the client does not explicitly initialize the KeyGenerator (via a call to an init method), each provider must supply (and document) a default initialization." This means that the cryptographic provider will decide what length the key will be (128, 192, or 256 bits for AES) which may cause a smaller key than desired to be used and may cause interoperability issues when different providers are used. */
            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();
            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);
            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            final String CIPHER_INPUT = "ABCDEFG123456";

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            /* FIX: Perform initialization of KeyGenerator */
            keygen.init(256);

            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();

            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");

            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);

            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));

            IO.writeLine(IO.toHex(encrypted));

        }
    }

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            /* FLAW: Skip initialization of KeyGenerator (like 'keygen.init(128);') According to the KeyGenerator JavaDoc: "In case the client does not explicitly initialize the KeyGenerator (via a call to an init method), each provider must supply (and document) a default initialization." This means that the cryptographic provider will decide what length the key will be (128, 192, or 256 bits for AES) which may cause a smaller key than desired to be used and may cause interoperability issues when different providers are used. */
            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();
            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);
            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
        else {

            final String CIPHER_INPUT = "ABCDEFG123456";

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            /* FIX: Perform initialization of KeyGenerator */
            keygen.init(256);

            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();

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
        if(private_t)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            /* FIX: Perform initialization of KeyGenerator */
            keygen.init(256);
            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();
            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, skSpec);
            byte[] encrypted = c.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            final String CIPHER_INPUT = "ABCDEFG123456";

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            /* FLAW: Skip initialization of KeyGenerator (like 'keygen.init(128);') According to the KeyGenerator JavaDoc: "In case the client does not explicitly initialize the KeyGenerator (via a call to an init method), each provider must supply (and document) a default initialization." This means that the cryptographic provider will decide what length the key will be (128, 192, or 256 bits for AES) which may cause a smaller key than desired to be used and may cause interoperability issues when different providers are used. */

            SecretKey sk = keygen.generateKey();
            byte[] raw = sk.getEncoded();

            SecretKeySpec skSpec = new SecretKeySpec(raw, "AES");

            Cipher c = Cipher.getInstance("AES");
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
