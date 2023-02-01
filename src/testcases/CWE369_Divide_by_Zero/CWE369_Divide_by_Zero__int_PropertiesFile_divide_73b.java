/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_PropertiesFile_divide_73b.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__int_PropertiesFile_divide_73b
{

    public void bad_sink(LinkedList<Integer> data_linkedlist ) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + String.valueOf(data) + " = " + (100 / data) + "\n");

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(LinkedList<Integer> data_linkedlist ) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + String.valueOf(data) + " = " + (100 / data) + "\n");

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(LinkedList<Integer> data_linkedlist ) throws Throwable
    {
        int data = data_linkedlist.remove(2);

        /* FIX: test for a zero denominator */
        if( data != 0 )
        {
            IO.writeLine("100/" + String.valueOf(data) + " = " + (100 / data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a divide by zero");
        }

    }
}
