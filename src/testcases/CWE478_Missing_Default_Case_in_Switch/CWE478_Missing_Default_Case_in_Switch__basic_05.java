/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE478_Missing_Default_Case_in_Switch__basic_05.java
Label Definition File: CWE478_Missing_Default_Case_in_Switch__basic.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 478 Missing Default Case in Switch
* Sinks:
*    GoodSink: Use default case in switch statement
*    BadSink : No default case in a switch statement
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE478_Missing_Default_Case_in_Switch;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE478_Missing_Default_Case_in_Switch__basic_05 extends AbstractTestCase
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
            String s = "";
            int x;
            SecureRandom r = new SecureRandom();
            x = (r.nextInt() % 3);
            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FLAW: x could be 2, and there is no 'default' case for that */
            }
            IO.writeLine(s);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String s = "";
            int x;
            SecureRandom r = new SecureRandom();

            x = (r.nextInt() % 3);

            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FIX: Add a default case */
            default:
                s = "2";
            }

            IO.writeLine(s);

        }
    }

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String s = "";
            int x;
            SecureRandom r = new SecureRandom();
            x = (r.nextInt() % 3);
            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FLAW: x could be 2, and there is no 'default' case for that */
            }
            IO.writeLine(s);
        }
        else {

            String s = "";
            int x;
            SecureRandom r = new SecureRandom();

            x = (r.nextInt() % 3);

            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FIX: Add a default case */
            default:
                s = "2";
            }

            IO.writeLine(s);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            String s = "";
            int x;
            SecureRandom r = new SecureRandom();
            x = (r.nextInt() % 3);
            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FIX: Add a default case */
            default:
                s = "2";
            }
            IO.writeLine(s);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String s = "";
            int x;
            SecureRandom r = new SecureRandom();

            x = (r.nextInt() % 3);

            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FLAW: x could be 2, and there is no 'default' case for that */
            }

            IO.writeLine(s);

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
