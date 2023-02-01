/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_19.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 129 Improper Validation of Array Index
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: array_read_check_max
*    GoodSink: Read from array after verifying index is at least 0 and less than array.length
*    BadSink : Read from array after verifying that data less than array.length (but not verifying that data is at least 0)
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE129_Improper_Validation_of_Array_Index__Environment_array_read_check_max_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String s_data = System.getenv("ADD");
            if (s_data != null)  // avoid NPD incidental warnings
            {
                try
                {
                    data = Integer.parseInt(s_data.trim());
                }
                catch(NumberFormatException nfe)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                }
            }
        }

        {

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* POTENTIAL FLAW: Verify that data < array.length, but don't verify that data > 0, so may be attempting to read out of the array bounds */
            if(data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Fully verify data before reading from array at location data */
            if(data >= 0 && data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        int data;
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* POTENTIAL FLAW: Verify that data < array.length, but don't verify that data > 0, so may be attempting to read out of the array bounds */
            if(data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            data = Integer.MIN_VALUE; /* Initialize data */

            /* get environment variable ADD */
            /* POTENTIAL FLAW: Read data from an environment variable */
            {
                String s_data = System.getenv("ADD");
                if (s_data != null)  // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Integer.parseInt(s_data.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                    }
                }
            }

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* POTENTIAL FLAW: Verify that data < array.length, but don't verify that data > 0, so may be attempting to read out of the array bounds */
            if(data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String s_data = System.getenv("ADD");
            if (s_data != null)  // avoid NPD incidental warnings
            {
                try
                {
                    data = Integer.parseInt(s_data.trim());
                }
                catch(NumberFormatException nfe)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                }
            }
        }

        {

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Fully verify data before reading from array at location data */
            if(data >= 0 && data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* POTENTIAL FLAW: Verify that data < array.length, but don't verify that data > 0, so may be attempting to read out of the array bounds */
            if(data < array.length)
            {
                IO.writeLine(array[data]);
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
