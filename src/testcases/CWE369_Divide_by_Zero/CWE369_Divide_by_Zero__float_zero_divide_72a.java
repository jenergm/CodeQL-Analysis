/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_zero_divide_72a.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.util.Vector;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_zero_divide_72a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        float data;

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        Vector<Float> data_vector = new Vector<Float>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE369_Divide_by_Zero__float_zero_divide_72b()).bad_sink(data_vector  );
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

        Vector<Float> data_vector = new Vector<Float>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE369_Divide_by_Zero__float_zero_divide_72b()).goodG2B_sink(data_vector  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        float data;

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        Vector<Float> data_vector = new Vector<Float>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE369_Divide_by_Zero__float_zero_divide_72b()).goodB2G_sink(data_vector  );
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
