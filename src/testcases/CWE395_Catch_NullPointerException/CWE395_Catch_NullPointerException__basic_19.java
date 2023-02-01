/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE395_Catch_NullPointerException__basic_19.java
Label Definition File: CWE395_Catch_NullPointerException__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 395 Use of NullPointerException Catch to Detect NULL Pointer Dereference
* Sinks:
*    GoodSink: Check for null before taking action
*    BadSink : Catch NullPointerException to detect null
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE395_Catch_NullPointerException;

import testcasesupport.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE395_Catch_NullPointerException__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            String data = System.getProperty("CWE395");

            try
            {
                /* INCIDENTAL: Possible Null Pointer Dereference (CWE476 / CWE690) */
                if(data.equals("CWE395"))
                {
                    IO.writeLine("data is CWE395");
                }
            }
            catch (NullPointerException npe) /* FLAW: Use of catch block to detect null dereferences */
            {
                IO.writeLine("data is null");
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String data;

            data = System.getProperty("CWE395");

            if(data != null) /* FIX: Check for null before calling equals() */
            {
                if(data.equals("CWE395"))
                {
                    IO.writeLine("data is CWE395");
                }
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            String data;

            data = System.getProperty("CWE395");

            if(data != null) /* FIX: Check for null before calling equals() */
            {
                if(data.equals("CWE395"))
                {
                    IO.writeLine("data is CWE395");
                }
            }
            else
            {
                IO.writeLine("data is null");
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String data = System.getProperty("CWE395");

            try
            {
                /* INCIDENTAL: Possible Null Pointer Dereference (CWE476 / CWE690) */
                if(data.equals("CWE395"))
                {
                    IO.writeLine("data is CWE395");
                }
            }
            catch (NullPointerException npe) /* FLAW: Use of catch block to detect null dereferences */
            {
                IO.writeLine("data is null");
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

