/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement_in_Switch__basic_03.java
Label Definition File: CWE484_Omitted_Break_Statement_in_Switch__basic.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement in Switch
* Sinks:
*    GoodSink: Each case in switch has a break statement
*    BadSink : Missing break statement in one case of switch
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE484_Omitted_Break_Statement_in_Switch;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE484_Omitted_Break_Statement_in_Switch__basic_03 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (5==5)
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

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if(5!=5)
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
        if(5==5)
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
