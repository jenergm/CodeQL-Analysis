/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_rand_add_67b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_rand_add_67b
{

    public void bad_sink(CWE190_Integer_Overflow__byte_rand_add_67a.Container data_container ) throws Throwable
    {
        byte data = data_container.a;

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE190_Integer_Overflow__byte_rand_add_67a.Container data_container ) throws Throwable
    {
        byte data = data_container.a;

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE190_Integer_Overflow__byte_rand_add_67a.Container data_container ) throws Throwable
    {
        byte data = data_container.a;

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Byte.MAX_VALUE)
        {
            byte result = (byte)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("data value is too large to perform addition.");
        }

    }
}
