/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE681_Incorrect_Conversion_Between_Numeric_Types__float2int_01.java
Label Definition File: CWE681_Incorrect_Conversion_Between_Numeric_Types.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 681 Incorrect Conversion Between Numeric Types
* Sinks: float2int
*    GoodSink: check value before conversion
*    BadSink : conversion may be unsafe
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE681_Incorrect_Conversion_Between_Numeric_Types;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE681_Incorrect_Conversion_Between_Numeric_Types__float2int_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
        boolean errored = false;

        try
        {
            /* Enter: 1e20f, result should be 2147483647 (for bad case) */
            inread2 = new InputStreamReader(System.in, "UTF-8");
            bufread2 = new BufferedReader(inread2);
            System.out.print("Enter float number (1e20f): ");
            double num = 0;
            try
            {
                num = Float.parseFloat(bufread2.readLine());
            }
            catch(Exception e)
            {
                IO.writeLine("Error parsing number");
                errored = true;
            }

            /* FLAW: should not cast without checking if conversion is safe */
            IO.writeLine("" + (int)num);
        }
        catch( Exception e )
        {
            IO.logger.log(Level.WARNING, "Error!", e);
        }
        finally
        {
            try
            {
                if( bufread2 != null )
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
            }

            try
            {
                if( inread2 != null )
                {
                    inread2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
            }

            if( errored )
            {
                IO.logger.log(Level.WARNING, "Error parsing number");
            }
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
        boolean errored = false;

        try
        {
            inread2 = new InputStreamReader(System.in, "UTF-8");
            bufread2 = new BufferedReader(inread2);
            System.out.print("Enter float number (1e20f): ");
            double num = 0;
            try
            {
                num = Float.parseFloat(bufread2.readLine());
            }
            catch(Exception e)
            {
                IO.writeLine("Error parsing number");
                errored = true;
            }

            /* FIX: check to make sure conversion is safe */
            if (num > Integer.MAX_VALUE ||
                    num < Integer.MIN_VALUE)
            {
                IO.writeLine("Value is too small or large to be represented as an int");
            }
            else {

                IO.writeLine("" + (int)num);
            }
        }
        catch( Exception e )
        {
            IO.logger.log(Level.WARNING, "Error!", e);
        }
        finally
        {
            try
            {
                if( bufread2 != null )
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
            }

            try
            {
                if( inread2 != null )
                {
                    inread2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
            }

            if( errored )
            {
                IO.logger.log(Level.WARNING, "Error parsing number");
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

