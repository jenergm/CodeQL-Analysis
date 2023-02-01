/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_square_11.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: console_readLine Read data from the console using readLine
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: square
*    GoodSink: Ensure there will not be an overflow before squaring data
*    BadSink : Square data, which can lead to overflow
* Flow Variant: 11 Control flow: if(IO.static_returns_t()) and if(IO.static_returns_f())
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

import java.lang.Math;

public class CWE190_Integer_Overflow__byte_console_readLine_square_11 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        byte data;
        if(IO.static_returns_t())
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
                    data = Byte.parseByte(s_data.trim());
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
        if(IO.static_returns_t())
        {
            /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Byte.MAX_VALUE)))
            {
                byte result = (byte)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_returns_t() to IO.static_returns_f() */
    private void goodG2B1() throws Throwable
    {
        byte data;
        if(IO.static_returns_f())
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
                    data = Byte.parseByte(s_data.trim());
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
        if(IO.static_returns_t())
        {
            /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Byte.MAX_VALUE)))
            {
                byte result = (byte)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        byte data;
        if(IO.static_returns_t())
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
                    data = Byte.parseByte(s_data.trim());
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
        if(IO.static_returns_t())
        {
            /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Byte.MAX_VALUE)))
            {
                byte result = (byte)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_returns_t() to IO.static_returns_f() */
    private void goodB2G1() throws Throwable
    {
        byte data;
        if(IO.static_returns_t())
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
                    data = Byte.parseByte(s_data.trim());
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
        if(IO.static_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * data);
            IO.writeLine("result: " + result);
        }
        else {

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Byte.MAX_VALUE)))
            {
                byte result = (byte)(data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        byte data;
        if(IO.static_returns_t())
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
                    data = Byte.parseByte(s_data.trim());
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
        if(IO.static_returns_t())
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Byte.MAX_VALUE)))
            {
                byte result = (byte)(data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform squaring.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * data);

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
