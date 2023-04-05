/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_17.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__equals_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int a = 1, b = 5;
            IO.writeLine(a);
            /* FIX: Assign b to a */
            a = b;
            IO.writeLine(a);
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int a = 1, b = 5; /* INCIDENTAL: CWE 563: Unused Variable (b is not used) */
            IO.writeLine(a);
            /* FLAW: The statement below has no effect since it is setting a variable to itself */
            a = a;
            IO.writeLine(a);
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
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
