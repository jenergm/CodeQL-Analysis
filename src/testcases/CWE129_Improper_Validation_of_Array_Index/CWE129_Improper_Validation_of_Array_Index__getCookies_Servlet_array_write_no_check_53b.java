/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_write_no_check_53b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_write_no_check
 *    GoodSink: Write to array after verifying index
 *    BadSink : Write to array without any verification of index
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_write_no_check_53b
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_write_no_check_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_write_no_check_53c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE129_Improper_Validation_of_Array_Index__getCookies_Servlet_array_write_no_check_53c()).goodB2G_sink(data , request, response);
    }
}
