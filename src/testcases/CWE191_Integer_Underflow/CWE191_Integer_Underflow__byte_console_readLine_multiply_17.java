/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_console_readLine_multiply_17.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: console_readLine Read data from the console using readLine
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an underflow before multiplying data by 2
*    BadSink : If data is negative, multiply by 2, which can cause an underflow
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE191_Integer_Underflow__byte_console_readLine_multiply_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        byte data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Byte.MIN_VALUE, this will underflow */
                byte result = (byte)(data * 2);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Byte.MIN_VALUE/2))
                {
                    byte result = (byte)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B() throws Throwable
    {
        byte data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
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

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Byte.MIN_VALUE, this will underflow */
                byte result = (byte)(data * 2);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Byte.MIN_VALUE/2))
                {
                    byte result = (byte)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G() throws Throwable
    {
        byte data;

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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* POTENTIAL FLAW: if (data * 2) < Byte.MIN_VALUE, this will underflow */
                byte result = (byte)(data * 2);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            if(data < 0)   /* ensure we won't have an overflow */
            {
                /* FIX: Add a check to prevent an underflow from occurring */
                if (data > (Byte.MIN_VALUE/2))
                {
                    byte result = (byte)(data * 2);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("data value is too small to perform multiplication.");
                }
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
