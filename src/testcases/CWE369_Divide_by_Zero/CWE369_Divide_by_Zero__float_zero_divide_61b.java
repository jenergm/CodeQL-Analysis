/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_zero_divide_61b.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_zero_divide_61b
{

    public float bad_source() throws Throwable
    {
        float data;

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public float goodG2B_source() throws Throwable
    {
        float data;

        /* FIX: Use a hardcoded number that won't a divide by zero */
        data = 2.0f;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public float goodB2G_source() throws Throwable
    {
        float data;

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        return data;
    }
}
