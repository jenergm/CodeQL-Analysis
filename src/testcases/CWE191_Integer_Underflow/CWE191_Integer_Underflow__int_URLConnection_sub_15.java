/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_URLConnection_sub_15.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: URLConnection Read data from a web server with URLConnection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE191_Integer_Underflow;

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

public class CWE191_Integer_Underflow__int_URLConnection_sub_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        int data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        default:
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        break;
        default:
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data > Integer.MIN_VALUE)
            {
                int result = (int)(data - 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to perform subtraction.");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(data - 1);
            IO.writeLine("result: " + result);
        }
        break;
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
