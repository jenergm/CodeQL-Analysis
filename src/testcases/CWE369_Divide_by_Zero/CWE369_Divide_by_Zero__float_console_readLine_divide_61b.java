/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_console_readLine_divide_61b.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__float_console_readLine_divide_61b
{

    public float bad_source() throws Throwable
    {
        float data;

        data = -1.0f; /* Initialize data */

        InputStreamReader isr = null;
        BufferedReader buffread = null;

        /* read user input from console with readLine */
        try {
            isr = new InputStreamReader(System.in, "UTF-8");
            buffread = new BufferedReader(isr);

            /* POTENTIAL FLAW: Read data from the console using readLine */
            String s_data = buffread.readLine();
            if (s_data != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Float.parseFloat(s_data.trim());
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
            /* Close stream reading objects */
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
                if( isr != null )
                {
                    isr.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
            }
        }

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public float goodG2B_source() throws Throwable
    {
        float data;

        /* FIX: Use a hardcoded number that won't a divide by zero */
        data = 2.0f;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public float goodB2G_source() throws Throwable
    {
        float data;

        data = -1.0f; /* Initialize data */

        InputStreamReader isr = null;
        BufferedReader buffread = null;

        /* read user input from console with readLine */
        try {
            isr = new InputStreamReader(System.in, "UTF-8");
            buffread = new BufferedReader(isr);

            /* POTENTIAL FLAW: Read data from the console using readLine */
            String s_data = buffread.readLine();
            if (s_data != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Float.parseFloat(s_data.trim());
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
            /* Close stream reading objects */
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
                if( isr != null )
                {
                    isr.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
            }
        }

        return data;
    }
}
