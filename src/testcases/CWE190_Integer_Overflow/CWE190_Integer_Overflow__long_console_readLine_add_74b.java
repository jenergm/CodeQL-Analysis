/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_console_readLine_add_74b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_console_readLine_add_74b
{

    public void bad_sink(HashMap<Integer,Long> data_hashmap ) throws Throwable
    {
        long data = data_hashmap.get(2);

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        long result = (long)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(HashMap<Integer,Long> data_hashmap ) throws Throwable
    {
        long data = data_hashmap.get(2);

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        long result = (long)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(HashMap<Integer,Long> data_hashmap ) throws Throwable
    {
        long data = data_hashmap.get(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Long.MAX_VALUE)
        {
            long result = (long)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too large to perform addition.");
        }

    }
}
