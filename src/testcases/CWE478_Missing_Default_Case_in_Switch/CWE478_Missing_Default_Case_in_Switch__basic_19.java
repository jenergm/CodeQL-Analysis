/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE478_Missing_Default_Case_in_Switch__basic_19.java
Label Definition File: CWE478_Missing_Default_Case_in_Switch__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 478 Missing Default Case in Switch
* Sinks:
*    GoodSink: Use default case in switch statement
*    BadSink : No default case in a switch statement
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE478_Missing_Default_Case_in_Switch;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE478_Missing_Default_Case_in_Switch__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

