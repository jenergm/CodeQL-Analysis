/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE478_Missing_Default_Case_in_Switch__basic_12.java
Label Definition File: CWE478_Missing_Default_Case_in_Switch__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 478 Missing Default Case in Switch
* Sinks:
*    GoodSink: Use default case in switch statement
*    BadSink : No default case in a switch statement
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE478_Missing_Default_Case_in_Switch;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE478_Missing_Default_Case_in_Switch__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            String s = "";
            int x;
            SecureRandom r = new SecureRandom();
            x = (r.nextInt() % 3);
            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FLAW: x could be 2, and there is no 'default' case for that */
            }
            IO.writeLine(s);
        }
        else {

            String s = "";
            int x;
            SecureRandom r = new SecureRandom();

            x = (r.nextInt() % 3);

            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FIX: Add a default case */
            default:
                s = "2";
            }

            IO.writeLine(s);

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            String s = "";
            int x;
            SecureRandom r = new SecureRandom();
            x = (r.nextInt() % 3);
            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FIX: Add a default case */
            default:
                s = "2";
            }
            IO.writeLine(s);
        }
        else {

            String s = "";
            int x;
            SecureRandom r = new SecureRandom();

            x = (r.nextInt() % 3);

            switch (x)
            {
            case 0:
                s = "0";
                break;
            case 1:
                s = "1";
                break;
                /* FIX: Add a default case */
            default:
                s = "2";
            }

            IO.writeLine(s);

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
