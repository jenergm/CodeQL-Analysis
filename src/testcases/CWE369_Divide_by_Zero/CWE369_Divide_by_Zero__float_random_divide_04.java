/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_random_divide_04.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: random Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive)
* GoodSource: A hardcoded non-zero number (two)
* Sinks: divide
*    GoodSink: Check for zero before dividing
*    BadSink : Dividing by a value that may be zero
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_random_divide_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        float data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: Possibly divide by zero */
            int result = (int)(100.0 / data);
            IO.writeLine(result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Check for value of or near zero before dividing */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 / data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a divide by zero");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_final_t to private_final_f */
    private void goodG2B1() throws Throwable
    {
        float data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        else {

            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: Possibly divide by zero */
            int result = (int)(100.0 / data);
            IO.writeLine(result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Check for value of or near zero before dividing */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 / data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a divide by zero");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        float data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: Possibly divide by zero */
            int result = (int)(100.0 / data);
            IO.writeLine(result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Check for value of or near zero before dividing */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 / data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a divide by zero");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_final_t to private_final_f */
    private void goodB2G1() throws Throwable
    {
        float data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Possibly divide by zero */
            int result = (int)(100.0 / data);
            IO.writeLine(result);
        }
        else {

            /* FIX: Check for value of or near zero before dividing */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 / data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a divide by zero");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        float data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
            SecureRandom r = new SecureRandom();
            data = r.nextFloat();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* FIX: Check for value of or near zero before dividing */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 / data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a divide by zero");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Possibly divide by zero */
            int result = (int)(100.0 / data);
            IO.writeLine(result);

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
