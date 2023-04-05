/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_16.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: MessageDigest_update
*    GoodSink: Include call to MessageDigest.update()
*    BadSink : Missing call to MessageDigest.update()
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE325_Missing_Required_Cryptographic_Step;

import testcasesupport.*;

import java.security.NoSuchAlgorithmException;

import java.security.MessageDigest;

public class CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */
            IO.writeLine(IO.toHex(sha.digest()));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FIX: Include call to MessageDigest.update() */
            sha.update(HASH_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(sha.digest()));
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
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */
            IO.writeLine(IO.toHex(sha.digest()));
            break;
        }

        while(true)
        {
            final String HASH_INPUT = "ABCDEFG123456";
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            /* FIX: Include call to MessageDigest.update() */
            sha.update(HASH_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(sha.digest()));
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
