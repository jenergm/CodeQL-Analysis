/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_zero_modulo_22b.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_zero_modulo_22b
{

    public void bad_sink(float data ) throws Throwable
    {
        if(CWE369_Divide_by_Zero__float_zero_modulo_22a.bad_public_static)
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1_sink(float data ) throws Throwable
    {
        if(CWE369_Divide_by_Zero__float_zero_modulo_22a.goodB2G1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        else {

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

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2_sink(float data ) throws Throwable
    {
        if(CWE369_Divide_by_Zero__float_zero_modulo_22a.goodB2G2_public_static)
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);

        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(float data ) throws Throwable
    {
        if(CWE369_Divide_by_Zero__float_zero_modulo_22a.goodG2B_public_static)
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
}
