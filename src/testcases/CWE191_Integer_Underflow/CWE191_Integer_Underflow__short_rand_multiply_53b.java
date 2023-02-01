/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_rand_multiply_53b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an underflow before multiplying data by 2
 *    BadSink : If data is negative, multiply by 2, which can cause an underflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

public class CWE191_Integer_Underflow__short_rand_multiply_53b
{

    public void bad_sink(short data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__short_rand_multiply_53c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(short data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__short_rand_multiply_53c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(short data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__short_rand_multiply_53c()).goodB2G_sink(data );
    }
}
