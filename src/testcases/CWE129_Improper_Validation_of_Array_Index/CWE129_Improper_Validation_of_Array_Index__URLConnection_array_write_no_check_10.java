/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__URLConnection_array_write_no_check_10.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-10.tmpl.java
*/
/*
* @description
* CWE: 129 Improper Validation of Array Index
* BadSource: URLConnection Read data from a web server with URLConnection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: array_write_no_check
*    GoodSink: Write to array after verifying index
*    BadSink : Write to array without any verification of index
* Flow Variant: 10 Control flow: if(IO.static_t) and if(IO.static_f)
*
* */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE129_Improper_Validation_of_Array_Index__URLConnection_array_write_no_check_10 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
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
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_t to IO.static_f */
    private void goodG2B1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = Integer.MIN_VALUE; /* Initialize data */
            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
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
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }
                }
            }
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = Integer.MIN_VALUE; /* Initialize data */

            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
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
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_t to IO.static_f */
    private void goodB2G1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
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
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;
            /* Skip reading back data from array since that may be another out of bounds operation */
        }
        else {

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else {
                IO.writeLine("Array index out of bounds");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* read input from URLConnection */
            {
                URLConnection conn = (new URL("http://www.example.org/")).openConnection();
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                    // which could be very long if there are no newlines in the HTML
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
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };
            /* FIX: Verify index before writing to array at location data */
            if(data >= 0 && data < array.length)
            {
                array[data] = 42;
            }
            else
            {
                IO.writeLine("Array index out of bounds");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Need to ensure that the array is of size > 3  and < 101 due to the GoodSource and the large_fixed BadSource */
            int array[] = { 0, 1, 2, 3, 4 };

            /* POTENTIAL FLAW: Attempt to write to array at location data, which may be outside the array bounds */
            array[data] = 42;

            /* Skip reading back data from array since that may be another out of bounds operation */

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
