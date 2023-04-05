/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_17.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace
*    GoodSink: Print generic error message to console
*    BadSink : Print stack trace to console
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

public class CWE209_Information_Leak_Error__printStackTrace_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                uoe.printStackTrace(); /* FLAW: Print stack trace to console on error */
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                IO.writeLine("There was an unsupported operation error"); /* FIX: print a generic message */
            }
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                uoe.printStackTrace(); /* FLAW: Print stack trace to console on error */
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                IO.writeLine("There was an unsupported operation error"); /* FIX: print a generic message */
            }
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
