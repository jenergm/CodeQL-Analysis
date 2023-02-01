/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_max_multiply_08.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: max Set data to the maximum value for int
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an overflow before multiplying data by 2
*    BadSink : If data is positive, multiply by 2, which can cause an overflow
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_max_multiply_08 extends AbstractTestCase
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
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Use the maximum value for this type */
            data = Integer.MAX_VALUE;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data < (Integer.MAX_VALUE/2))
                {
                    int result = (int)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too large to perform multiplication.");
                }
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_returns_t() to private_returns_f() */
    private void goodG2B1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Use the maximum value for this type */
            data = Integer.MAX_VALUE;
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data < (Integer.MAX_VALUE/2))
                {
                    int result = (int)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too large to perform multiplication.");
                }
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Use the maximum value for this type */
            data = Integer.MAX_VALUE;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data < (Integer.MAX_VALUE/2))
                {
                    int result = (int)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too large to perform multiplication.");
                }
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_returns_t() to private_returns_f() */
    private void goodB2G1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Use the maximum value for this type */
            data = Integer.MAX_VALUE;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
        }
        else {

            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data < (Integer.MAX_VALUE/2))
                {
                    int result = (int)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too large to perform multiplication.");
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Use the maximum value for this type */
            data = Integer.MAX_VALUE;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data < (Integer.MAX_VALUE/2))
                {
                    int result = (int)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too large to perform multiplication.");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if(data > 0)   /* ensure we won't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*2) > Integer.MAX_VALUE, this will overflow */
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }

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
