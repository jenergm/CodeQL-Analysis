/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_getParameter_Servlet_multiply_73b.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_getParameter_Servlet_multiply_73b
{

    public void bad_sink(LinkedList<Integer> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        if(data < 0)   /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Integer.MIN_VALUE, this will underflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(LinkedList<Integer> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        if(data < 0)   /* ensure we won't have an overflow */
        {
            /* POTENTIAL FLAW: if (data * 2) < Integer.MIN_VALUE, this will underflow */
            int result = (int)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(LinkedList<Integer> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        if(data < 0)   /* ensure we won't have an overflow */
        {
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data > (Integer.MIN_VALUE/2))
            {
                int result = (int)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform multiplication.");
            }
        }

    }
}
