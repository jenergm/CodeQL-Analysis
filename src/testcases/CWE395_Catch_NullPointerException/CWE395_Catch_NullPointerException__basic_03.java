/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE395_Catch_NullPointerException__basic_03.java
Label Definition File: CWE395_Catch_NullPointerException__basic.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 395 Use of NullPointerException Catch to Detect NULL Pointer Dereference
* Sinks:
*    GoodSink: Check for null before taking action
*    BadSink : Catch NullPointerException to detect null
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE395_Catch_NullPointerException;

import testcasesupport.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE395_Catch_NullPointerException__basic_03 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (5==5)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        else {

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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(5==5)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    public void good() throws Throwable
    {
        good1();
        good2();
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
