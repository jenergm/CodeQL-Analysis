/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_sub_67b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

public class CWE191_Integer_Underflow__short_min_sub_67b
{

    public void bad_sink(CWE191_Integer_Underflow__short_min_sub_67a.Container data_container ) throws Throwable
    {
        short data = data_container.a;

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE191_Integer_Underflow__short_min_sub_67a.Container data_container ) throws Throwable
    {
        short data = data_container.a;

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(data - 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE191_Integer_Underflow__short_min_sub_67a.Container data_container ) throws Throwable
    {
        short data = data_container.a;

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data > Short.MIN_VALUE)
        {
            short result = (short)(data - 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too small to perform subtraction.");
        }

    }
}
