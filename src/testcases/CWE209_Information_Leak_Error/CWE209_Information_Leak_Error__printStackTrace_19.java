/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_19.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace
*    GoodSink: Print generic error message to console
*    BadSink : Print stack trace to console
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

public class CWE209_Information_Leak_Error__printStackTrace_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

