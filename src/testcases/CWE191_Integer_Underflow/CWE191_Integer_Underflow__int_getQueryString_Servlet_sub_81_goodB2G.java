/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_getQueryString_Servlet_sub_81_goodB2G.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_getQueryString_Servlet_sub_81_goodB2G extends CWE191_Integer_Underflow__int_getQueryString_Servlet_sub_81_base
{

    public void action(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Integer.MIN_VALUE)
        {
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }

}
