/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_block_08.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_block
*    GoodSink: Include some code inside a block
*    BadSink : An empty code block has no effect
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__empty_block_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            /* FLAW: The empty block on the next line has no effect */
            {   }
            IO.writeLine("Hello from bad()");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Include some code inside the block */
            {
                String s = "Inside the block"; /* Define a variable to justify having a block for scoping */
                IO.writeLine(s);
            }

            IO.writeLine("Hello from good()");

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: The empty block on the next line has no effect */
            {   }
            IO.writeLine("Hello from bad()");
        }
        else {

            /* FIX: Include some code inside the block */
            {
                String s = "Inside the block"; /* Define a variable to justify having a block for scoping */
                IO.writeLine(s);
            }

            IO.writeLine("Hello from good()");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            /* FIX: Include some code inside the block */
            {
                String s = "Inside the block"; /* Define a variable to justify having a block for scoping */
                IO.writeLine(s);
            }
            IO.writeLine("Hello from good()");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: The empty block on the next line has no effect */
            {   }

            IO.writeLine("Hello from bad()");

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
