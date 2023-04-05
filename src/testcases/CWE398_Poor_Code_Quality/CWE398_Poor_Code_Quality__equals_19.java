/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_19.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__equals_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */

            IO.writeLine(a);

            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;

            IO.writeLine(a);

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int a = 1, b = 5;

            IO.writeLine(a);

            /* FIX: Assign b to a */
            a = b;

            IO.writeLine(a);

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

            int a = 1, b = 5;

            IO.writeLine(a);

            /* FIX: Assign b to a */
            a = b;

            IO.writeLine(a);

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */

            IO.writeLine(a);

            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;

            IO.writeLine(a);

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

