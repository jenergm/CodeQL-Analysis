/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_multiply_52b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_console_readLine_multiply_52b
{

    public void bad_sink(byte data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__byte_console_readLine_multiply_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(byte data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__byte_console_readLine_multiply_52c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(byte data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__byte_console_readLine_multiply_52c()).goodB2G_sink(data );
    }
}
