/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__Property_array_read_check_max_52b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_max
 *    GoodSink: Read from array after verifying index is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data less than array.length (but not verifying that data is at least 0)
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__Property_array_read_check_max_52b
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE129_Improper_Validation_of_Array_Index__Property_array_read_check_max_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE129_Improper_Validation_of_Array_Index__Property_array_read_check_max_52c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE129_Improper_Validation_of_Array_Index__Property_array_read_check_max_52c()).goodB2G_sink(data );
    }
}
