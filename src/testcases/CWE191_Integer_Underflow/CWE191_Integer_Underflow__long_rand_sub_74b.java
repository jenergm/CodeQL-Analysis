/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_rand_sub_74b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;
import java.util.HashMap;

public class CWE191_Integer_Underflow__long_rand_sub_74b
{

    public void bad_sink(HashMap<Integer,Long> data_hashmap ) throws Throwable
    {
        long data = data_hashmap.get(2);

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(HashMap<Integer,Long> data_hashmap ) throws Throwable
    {
        long data = data_hashmap.get(2);

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(HashMap<Integer,Long> data_hashmap ) throws Throwable
    {
        long data = data_hashmap.get(2);

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
