/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__rand_19.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: rand
*    GoodSink: If specific random number generated, print to the console
*    BadSink : If specific random number generated, launch an executable
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE511_Logic_Time_Bomb__rand_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            SecureRandom r = new SecureRandom();

            /* FLAW: PRNG triggered backdoor */
            if (r.nextInt() == 20000)
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            SecureRandom r = new SecureRandom();

            /* FIX: no backdoor exists */
            if (r.nextInt() == 20000)
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
            }

        }
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            SecureRandom r = new SecureRandom();

            /* FIX: no backdoor exists */
            if (r.nextInt() == 20000)
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            SecureRandom r = new SecureRandom();

            /* FLAW: PRNG triggered backdoor */
            if (r.nextInt() == 20000)
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }

        }
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

