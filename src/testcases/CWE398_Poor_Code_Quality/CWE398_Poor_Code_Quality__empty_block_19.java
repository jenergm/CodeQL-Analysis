/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_block_19.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_block
*    GoodSink: Include some code inside a block
*    BadSink : An empty code block has no effect
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__empty_block_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            /* FLAW: The empty block on the next line has no effect */
            {   }

            IO.writeLine("Hello from bad()");

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Include some code inside the block */
            {
                String s = "Inside the block"; /* Define a variable to justify having a block for scoping */
                IO.writeLine(s);
            }

            IO.writeLine("Hello from good()");

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

            /* FIX: Include some code inside the block */
            {
                String s = "Inside the block"; /* Define a variable to justify having a block for scoping */
                IO.writeLine(s);
            }

            IO.writeLine("Hello from good()");

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FLAW: The empty block on the next line has no effect */
            {   }

            IO.writeLine("Hello from bad()");

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

