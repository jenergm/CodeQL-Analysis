/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE481_Assigning_Instead_of_Comparing__basic_17.java
Label Definition File: CWE481_Assigning_Instead_of_Comparing__basic.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 481 Assigning Instead of Comparing
* Sinks:
*    GoodSink: Comparing
*    BadSink : Assigning instead of comparing
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE481_Assigning_Instead_of_Comparing;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE481_Assigning_Instead_of_Comparing__basic_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
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
