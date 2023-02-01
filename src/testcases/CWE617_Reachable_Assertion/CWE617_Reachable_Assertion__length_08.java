/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__length_08.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* Sinks: length
*    GoodSink: assert true, which will never trigger
*    BadSink : assert false, which will always trigger
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

public class CWE617_Reachable_Assertion__length_08 extends AbstractTestCase
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
            /* FLAW: assertion is false */
            assert "".length() > 0;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: assertion is true */
            assert "cwe617".length() > 0;

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: assertion is false */
            assert "".length() > 0;
        }
        else {

            /* FIX: assertion is true */
            assert "cwe617".length() > 0;

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            /* FIX: assertion is true */
            assert "cwe617".length() > 0;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: assertion is false */
            assert "".length() > 0;

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
