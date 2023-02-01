/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_console_readLine_modulo_74a.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.util.HashMap;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__float_console_readLine_modulo_74a extends AbstractTestCase
{

    public void bad() throws Throwable
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

        HashMap<Integer,Float> data_hashmap = new HashMap<Integer,Float>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE369_Divide_by_Zero__float_console_readLine_modulo_74b()).bad_sink(data_hashmap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        float data;

        /* FIX: Use a hardcoded number that won't a divide by zero */
        data = 2.0f;

        HashMap<Integer,Float> data_hashmap = new HashMap<Integer,Float>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE369_Divide_by_Zero__float_console_readLine_modulo_74b()).goodG2B_sink(data_hashmap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
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

        HashMap<Integer,Float> data_hashmap = new HashMap<Integer,Float>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE369_Divide_by_Zero__float_console_readLine_modulo_74b()).goodB2G_sink(data_hashmap  );
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
