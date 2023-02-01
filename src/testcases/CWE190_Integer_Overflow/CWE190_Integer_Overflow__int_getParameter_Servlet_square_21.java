/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getParameter_Servlet_square_21.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.lang.Math;

public class CWE190_Integer_Overflow__int_getParameter_Servlet_square_21 extends AbstractTestCaseServlet
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", nfe);
            }
        }

        bad_private = true;
        bad_sink(data , request, response);
    }

    private void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(bad_private)
        {
            /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
            {
                int result = (int)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1_private = false;
    private boolean goodB2G2_private = false;
    private boolean goodG2B_private = false;

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G1(request, response);
        goodB2G2(request, response);
        goodG2B(request, response);
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", nfe);
            }
        }

        goodB2G1_private = false;
        goodB2G1_sink(data , request, response);
    }

    private void goodB2G1_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
        else {

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
            {
                int result = (int)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
        {
            String s_data = request.getParameter("name");

            try {
                data = Integer.parseInt(s_data.trim());
            }
            catch(NumberFormatException nfe)
            {
                IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", nfe);
            }
        }

        goodB2G2_private = true;
        goodB2G2_sink(data , request, response);
    }

    private void goodB2G2_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(goodB2G2_private)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
            {
                int result = (int)(data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform squaring.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * data);

            IO.writeLine("result: " + result);

        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2B_private = true;
        goodG2B_sink(data , request, response);
    }

    private void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(goodG2B_private)
        {
            /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
            {
                int result = (int)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
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
