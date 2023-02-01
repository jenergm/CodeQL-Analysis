/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__max_value_write_73a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__max_value_write_73a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        LinkedList<Integer> count_linkedlist = new LinkedList<Integer>();
        count_linkedlist.add(0, count);
        count_linkedlist.add(1, count);
        count_linkedlist.add(2, count);
        (new CWE400_Resource_Exhaustion__max_value_write_73b()).bad_sink(count_linkedlist  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        LinkedList<Integer> count_linkedlist = new LinkedList<Integer>();
        count_linkedlist.add(0, count);
        count_linkedlist.add(1, count);
        count_linkedlist.add(2, count);
        (new CWE400_Resource_Exhaustion__max_value_write_73b()).goodG2B_sink(count_linkedlist  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        LinkedList<Integer> count_linkedlist = new LinkedList<Integer>();
        count_linkedlist.add(0, count);
        count_linkedlist.add(1, count);
        count_linkedlist.add(2, count);
        (new CWE400_Resource_Exhaustion__max_value_write_73b()).goodB2G_sink(count_linkedlist  );
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
