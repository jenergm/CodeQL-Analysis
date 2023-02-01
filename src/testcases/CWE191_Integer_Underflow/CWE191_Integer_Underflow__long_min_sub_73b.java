/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_sub_73b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;
import java.util.LinkedList;

public class CWE191_Integer_Underflow__long_min_sub_73b
{

    public void bad_sink(LinkedList<Long> data_linkedlist ) throws Throwable
    {
        long data = data_linkedlist.remove(2);

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(LinkedList<Long> data_linkedlist ) throws Throwable
    {
        long data = data_linkedlist.remove(2);

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(LinkedList<Long> data_linkedlist ) throws Throwable
    {
        long data = data_linkedlist.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Long.MIN_VALUE)
        {
            long result = (long)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}
