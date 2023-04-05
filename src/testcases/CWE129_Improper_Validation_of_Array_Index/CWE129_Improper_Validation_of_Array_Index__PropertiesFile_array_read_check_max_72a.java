/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_max_72a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_check_max
 *    GoodSink: Read from array after verifying index is at least 0 and less than array.length
 *    BadSink : Read from array after verifying that data less than array.length (but not verifying that data is at least 0)
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;
import java.util.Vector;

import java.sql.*;
import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_max_72a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            /* POTENTIAL FLAW: Read data from a .properties file */
            String s_data = props.getProperty("data");
            if (s_data != null)   // avoid NPD incidental warnings
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
            /* Close stream reading object */
            try {
                if( finstr != null )
                {
                    finstr.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
            }
        }

        Vector<Integer> data_vector = new Vector<Integer>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_max_72b()).bad_sink(data_vector  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        Vector<Integer> data_vector = new Vector<Integer>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_max_72b()).goodG2B_sink(data_vector  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            /* POTENTIAL FLAW: Read data from a .properties file */
            String s_data = props.getProperty("data");
            if (s_data != null)   // avoid NPD incidental warnings
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
            /* Close stream reading object */
            try {
                if( finstr != null )
                {
                    finstr.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
            }
        }

        Vector<Integer> data_vector = new Vector<Integer>(5);
        data_vector.add(0, data);
        data_vector.add(1, data);
        data_vector.add(2, data);
        (new CWE129_Improper_Validation_of_Array_Index__PropertiesFile_array_read_check_max_72b()).goodB2G_sink(data_vector  );
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
