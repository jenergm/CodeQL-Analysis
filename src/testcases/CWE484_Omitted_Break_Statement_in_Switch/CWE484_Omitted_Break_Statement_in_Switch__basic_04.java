/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement_in_Switch__basic_04.java
Label Definition File: CWE484_Omitted_Break_Statement_in_Switch__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement in Switch
* Sinks:
*    GoodSink: Each case in switch has a break statement
*    BadSink : Missing break statement in one case of switch
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE484_Omitted_Break_Statement_in_Switch;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE484_Omitted_Break_Statement_in_Switch__basic_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
        {
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two"; /* INCIDENTAL: CWE563 Unused Variable (actually unused value) since s gets overwritten in the default case */
                /* FLAW: Case 2 is missing a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            SecureRandom r = new SecureRandom();

            int num = (r.nextInt() % 4);
            String s;

            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                s = "Default";
                break;
            }

            IO.writeLine(s);

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two"; /* INCIDENTAL: CWE563 Unused Variable (actually unused value) since s gets overwritten in the default case */
                /* FLAW: Case 2 is missing a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
        }
        else {

            SecureRandom r = new SecureRandom();

            int num = (r.nextInt() % 4);
            String s;

            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                s = "Default";
                break;
            }

            IO.writeLine(s);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
        {
            SecureRandom r = new SecureRandom();
            int num = (r.nextInt() % 4);
            String s;
            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break; /* FIX: Case 2 has a break statement */
            default:
                s = "Default";
                break;
            }
            IO.writeLine(s);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            SecureRandom r = new SecureRandom();

            int num = (r.nextInt() % 4);
            String s;

            switch (num)
            {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two"; /* INCIDENTAL: CWE563 Unused Variable (actually unused value) since s gets overwritten in the default case */
                /* FLAW: Case 2 is missing a break statement */
            default:
                s = "Default";
                break;
            }

            IO.writeLine(s);

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
