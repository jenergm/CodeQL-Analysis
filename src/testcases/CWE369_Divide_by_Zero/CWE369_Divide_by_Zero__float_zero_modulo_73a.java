/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_zero_modulo_73a.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_zero_modulo_73a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        float data;

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        LinkedList<Float> data_linkedlist = new LinkedList<Float>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE369_Divide_by_Zero__float_zero_modulo_73b()).bad_sink(data_linkedlist  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        float data;

        /* FIX: Use a hardcoded number that won't a divide by zero */
        data = 2.0f;

        LinkedList<Float> data_linkedlist = new LinkedList<Float>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE369_Divide_by_Zero__float_zero_modulo_73b()).goodG2B_sink(data_linkedlist  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        float data;

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        LinkedList<Float> data_linkedlist = new LinkedList<Float>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE369_Divide_by_Zero__float_zero_modulo_73b()).goodB2G_sink(data_linkedlist  );
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
