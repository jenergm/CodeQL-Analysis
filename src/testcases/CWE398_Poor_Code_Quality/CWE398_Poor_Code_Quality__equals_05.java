/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_05.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__equals_05 extends AbstractTestCase
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
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int a = 1, b = 5;

            IO.writeLine(a);

            /* FIX: Assign b to a */
            a = b;

            IO.writeLine(a);

        }
    }

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }
        else {

            int a = 1, b = 5;

            IO.writeLine(a);

            /* FIX: Assign b to a */
            a = b;

            IO.writeLine(a);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            int a = 1, b = 5;
            IO.writeLine(a);
            /* FIX: Assign b to a */
            a = b;
            IO.writeLine(a);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */

            IO.writeLine(a);

            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;

            IO.writeLine(a);

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
