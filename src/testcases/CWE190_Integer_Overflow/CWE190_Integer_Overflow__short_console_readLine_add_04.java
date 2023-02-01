/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_console_readLine_add_04.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: console_readLine Read data from the console using readLine
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before adding 1 to data
*    BadSink : Add 1 to data, which can cause an overflow
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE190_Integer_Overflow__short_console_readLine_add_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        short data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* init data */
            data = -1;
            /* POTENTIAL FLAW: Read data from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in, "UTF-8");
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine();
                if (s_data != null)
                {
                    data = Short.parseShort(s_data.trim());
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            catch( NumberFormatException nfe )
            {
                IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
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
                finally {
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
        if(private_final_t)
        {
            /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Short.MAX_VALUE)
            {
                short result = (short)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_final_t to private_final_f */
    private void goodG2B1() throws Throwable
    {
        short data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* init data */
            data = -1;
            /* POTENTIAL FLAW: Read data from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in, "UTF-8");
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine();
                if (s_data != null)
                {
                    data = Short.parseShort(s_data.trim());
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            catch( NumberFormatException nfe )
            {
                IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
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
                finally {
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
        if(private_final_t)
        {
            /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Short.MAX_VALUE)
            {
                short result = (short)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        short data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* init data */
            data = -1;

            /* POTENTIAL FLAW: Read data from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(System.in, "UTF-8");
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine();
                if (s_data != null)
                {
                    data = Short.parseShort(s_data.trim());
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            catch( NumberFormatException nfe )
            {
                IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
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
                finally {
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
        if(private_final_t)
        {
            /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Short.MAX_VALUE)
            {
                short result = (short)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_final_t to private_final_f */
    private void goodB2G1() throws Throwable
    {
        short data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* init data */
            data = -1;
            /* POTENTIAL FLAW: Read data from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in, "UTF-8");
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine();
                if (s_data != null)
                {
                    data = Short.parseShort(s_data.trim());
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            catch( NumberFormatException nfe )
            {
                IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
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
                finally {
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
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Short.MAX_VALUE)
            {
                short result = (short)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        short data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* init data */
            data = -1;
            /* POTENTIAL FLAW: Read data from console with readLine*/
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in, "UTF-8");
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine();
                if (s_data != null)
                {
                    data = Short.parseShort(s_data.trim());
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            catch( NumberFormatException nfe )
            {
                IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
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
                finally {
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
        if(private_final_t)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Short.MAX_VALUE)
            {
                short result = (short)(data + 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform addition.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
            short result = (short)(data + 1);

            IO.writeLine("result: " + result);

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
