/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__String_22a.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-22a.tmpl.java
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

public class CWE476_NULL_Pointer_Dereference__String_22a extends AbstractTestCase
{

    /* The public static variable below is used to drive control flow in the sink function.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean bad_public_static = false;

    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        bad_public_static = true;
        (new CWE476_NULL_Pointer_Dereference__String_22b()).bad_sink(data );
    }

    /* The public static variables below are used to drive control flow in the sink functions.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodB2G1_public_static = false;
    public static boolean goodB2G2_public_static = false;
    public static boolean goodG2B_public_static = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        goodB2G1_public_static = false;
        (new CWE476_NULL_Pointer_Dereference__String_22b()).goodB2G1_sink(data );
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        goodB2G2_public_static = true;
        (new CWE476_NULL_Pointer_Dereference__String_22b()).goodB2G2_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: hardcode data to non-null */
        data = "This is not null";

        goodG2B_public_static = true;
        (new CWE476_NULL_Pointer_Dereference__String_22b()).goodG2B_sink(data );
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
