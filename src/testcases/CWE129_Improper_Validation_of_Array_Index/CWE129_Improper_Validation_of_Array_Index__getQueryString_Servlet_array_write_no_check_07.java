/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__getQueryString_Servlet_array_write_no_check_07.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 129 Improper Validation of Array Index
* BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: array_write_no_check
*    GoodSink: Write to array after verifying index
*    BadSink : Write to array without any verification of index
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE129_Improper_Validation_of_Array_Index__getQueryString_Servlet_array_write_no_check_07 extends AbstractTestCaseServlet
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */
            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
            {
                StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken(); /* a token will be like "id=33" */
                    if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                    {
                        try
                        {
                            data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                        }
                        break; /* exit while loop */
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_five==5 to private_five!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */
            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
            {
                StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken(); /* a token will be like "id=33" */
                    if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                    {
                        try
                        {
                            data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                        }
                        break; /* exit while loop */
                    }
                }
            }
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */

            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
            {
                StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken(); /* a token will be like "id=33" */
                    if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                    {
                        try
                        {
                            data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                        }
                        break; /* exit while loop */
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_five==5 to private_five!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */
            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
            {
                StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken(); /* a token will be like "id=33" */
                    if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                    {
                        try
                        {
                            data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                        }
                        break; /* exit while loop */
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */
            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
            {
                StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken(); /* a token will be like "id=33" */
                    if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                    {
                        try
                        {
                            data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception reading id from query string", nfe);
                        }
                        break; /* exit while loop */
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else
            {
                IO.writeLine("Array index out of bounds");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;

            /* Skip reading back data from array since that may be another out of bounds operation */

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
