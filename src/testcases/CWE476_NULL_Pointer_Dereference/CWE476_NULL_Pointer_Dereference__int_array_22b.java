/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__int_array_22b.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__int_array_22b
{

    public void bad_sink(int [] data ) throws Throwable
    {
        if(CWE476_NULL_Pointer_Dereference__int_array_22a.bad_public_static)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length);
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1_sink(int [] data ) throws Throwable
    {
        if(CWE476_NULL_Pointer_Dereference__int_array_22a.goodB2G1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length);
        }
        else {

            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length);
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2_sink(int [] data ) throws Throwable
    {
        if(CWE476_NULL_Pointer_Dereference__int_array_22a.goodB2G2_public_static)
        {
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length);
            }
            else
            {
                IO.writeLine("data is null");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length);

        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int [] data ) throws Throwable
    {
        if(CWE476_NULL_Pointer_Dereference__int_array_22a.goodG2B_public_static)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length);
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
    }
}
