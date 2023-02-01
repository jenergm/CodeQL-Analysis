/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_console_readLine_modulo_72b.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.util.Vector;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__int_console_readLine_modulo_72b
{

    public void bad_sink(Vector<Integer> data_vector ) throws Throwable
    {
        int data = data_vector.remove(2);

        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(Vector<Integer> data_vector ) throws Throwable
    {
        int data = data_vector.remove(2);

        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(Vector<Integer> data_vector ) throws Throwable
    {
        int data = data_vector.remove(2);

        /* FIX: test for a zero modulus */
        if( data != 0 )
        {
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a modulo by zero");
        }

    }
}
