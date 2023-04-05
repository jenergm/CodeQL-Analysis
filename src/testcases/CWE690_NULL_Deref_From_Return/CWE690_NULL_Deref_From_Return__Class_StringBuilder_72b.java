/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_StringBuilder_72b.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;
import java.util.Vector;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__Class_StringBuilder_72b
{

    public void bad_sink(Vector<StringBuilder> data_vector ) throws Throwable
    {
        StringBuilder data = data_vector.remove(2);

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(Vector<StringBuilder> data_vector ) throws Throwable
    {
        StringBuilder data = data_vector.remove(2);

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(Vector<StringBuilder> data_vector ) throws Throwable
    {
        StringBuilder data = data_vector.remove(2);

        /* FIX: explicit check for null */
        if (data != null)
        {
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }

    }
}
