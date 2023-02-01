/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_block_07.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_block
*    GoodSink: Include some code inside a block
*    BadSink : An empty code block has no effect
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.io.*;

public class CWE398_Poor_Code_Quality__empty_block_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        if (private_five==5)
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

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1() throws Throwable
    {
        if(private_five!=5)
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
        if(private_five==5)
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
