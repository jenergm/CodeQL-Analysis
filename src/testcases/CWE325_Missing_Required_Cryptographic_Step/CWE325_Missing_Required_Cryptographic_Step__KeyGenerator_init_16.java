/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__KeyGenerator_init_16.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: KeyGenerator_init
*    GoodSink: Include call to KeyGenerator.init()
*    BadSink : Missing call to KeyGenerator.init()
* Flow Variant: 16 Control flow: while(true) and while(local_f)
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

public class CWE325_Missing_Required_Cryptographic_Step__KeyGenerator_init_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
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
            break;
        }

        while(local_f)
        {
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
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        boolean local_f = false;

        while(local_f)
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
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
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
