/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_Property_divide_54c.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_Property_divide_54c
{

    public void bad_sink(float data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__float_Property_divide_54d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(float data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__float_Property_divide_54d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(float data ) throws Throwable
    {
        (new CWE369_Divide_by_Zero__float_Property_divide_54d()).goodB2G_sink(data );
    }
}
