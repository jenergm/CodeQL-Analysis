/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Class_String_21.java
Label Definition File: CWE690_NULL_Deref_From_Return__Class.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__Class_String_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBad();

        bad_private = true;
        bad_sink(data );
    }

    private void bad_sink(String data ) throws Throwable
    {
        if(bad_private)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1_private = false;
    private boolean goodB2G2_private = false;
    private boolean goodG2B_private = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBad();

        goodB2G1_private = false;
        goodB2G1_sink(data );
    }

    private void goodB2G1_sink(String data ) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringBad(), which may return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringBad();

        goodB2G2_private = true;
        goodB2G2_sink(data );
    }

    private void goodB2G2_sink(String data ) throws Throwable
    {
        if(goodB2G2_private)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: call getStringGood(), which will never return null */
        data = CWE690_NULL_Deref_From_Return__Class_Helper.getStringGood();

        goodG2B_private = true;
        goodG2B_sink(data );
    }

    private void goodG2B_sink(String data ) throws Throwable
    {
        if(goodG2B_private)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
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
