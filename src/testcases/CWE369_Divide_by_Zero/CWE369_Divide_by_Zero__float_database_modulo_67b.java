/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_database_modulo_67b.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_database_modulo_67b
{

    public void bad_sink(CWE369_Divide_by_Zero__float_database_modulo_67a.Container data_container ) throws Throwable
    {
        float data = data_container.a;

        /* POTENTIAL FLAW: Possibly modulo by zero */
        int result = (int)(100.0 % data);
        IO.writeLine(result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE369_Divide_by_Zero__float_database_modulo_67a.Container data_container ) throws Throwable
    {
        float data = data_container.a;

        /* POTENTIAL FLAW: Possibly modulo by zero */
        int result = (int)(100.0 % data);
        IO.writeLine(result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE369_Divide_by_Zero__float_database_modulo_67a.Container data_container ) throws Throwable
    {
        float data = data_container.a;

        /* FIX: Check for value of or near zero before modulo */
        if( Math.abs(data) > 0.000001 )
        {
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        else
        {
            IO.writeLine("This would result in a modulo by zero");
        }

    }
}
