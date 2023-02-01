/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__console_readLine_array_read_check_min_67b.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_min
 *    GoodSink: Read from array after verifying that data is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data is at least 0 (but not verifying that data less than array.length)
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__console_readLine_array_read_check_min_67b
{

    public void bad_sink(CWE129_Improper_Validation_of_Array_Index__console_readLine_array_read_check_min_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Verify that data >= 0, but don't verify that data < array.length, so may be attempting to read out of the array bounds */
        if(data >= 0)
        {
            IO.writeLine(array[data]);
        }
        else {
            IO.writeLine("Array index out of bounds");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE129_Improper_Validation_of_Array_Index__console_readLine_array_read_check_min_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* POTENTIAL FLAW: Verify that data >= 0, but don't verify that data < array.length, so may be attempting to read out of the array bounds */
        if(data >= 0)
        {
            IO.writeLine(array[data]);
        }
        else {
            IO.writeLine("Array index out of bounds");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE129_Improper_Validation_of_Array_Index__console_readLine_array_read_check_min_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
        int array[] = { 0, 1, 2, 3, 4 };

        /* FIX: Fully verify data before reading from array at location data */
        if(data >= 0 && data < array.length)
        {
            IO.writeLine(array[data]);
        }
        else {
            IO.writeLine("Array index out of bounds");
        }

    }
}
