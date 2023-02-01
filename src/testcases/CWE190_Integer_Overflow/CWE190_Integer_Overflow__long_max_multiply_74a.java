/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_max_multiply_74a.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_max_multiply_74a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MAX_VALUE;

        HashMap<Integer,Long> data_hashmap = new HashMap<Integer,Long>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE190_Integer_Overflow__long_max_multiply_74b()).bad_sink(data_hashmap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        long data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        HashMap<Integer,Long> data_hashmap = new HashMap<Integer,Long>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE190_Integer_Overflow__long_max_multiply_74b()).goodG2B_sink(data_hashmap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MAX_VALUE;

        HashMap<Integer,Long> data_hashmap = new HashMap<Integer,Long>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE190_Integer_Overflow__long_max_multiply_74b()).goodB2G_sink(data_hashmap  );
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
