/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_22b.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_22b
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_22a.bad_public_static)
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

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_22a.goodB2G1_public_static)
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

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_22a.goodB2G2_public_static)
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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE190_Integer_Overflow__int_getQueryString_Servlet_multiply_22a.goodG2B_public_static)
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
}
