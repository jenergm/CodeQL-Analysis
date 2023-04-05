/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_66a.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        FileInputStream finstrm2 = null;
        String propFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
        try
        {
            finstrm2 = new FileInputStream(propFileName);
            Properties p = new Properties();
            p.load(finstrm2);

            /* POTENTIAL FLAW: data may be set to null */
            data = p.getProperty("CWE690");
        }
        catch( IOException ioe )
        {
            IO.writeLine("Could not open properties file: " + propFileName);
            data = ""; /* ensure that data is initialized */
        }
        finally
        {
            try
            {
                if( finstrm2 != null )
                {
                    finstrm2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
            }
        }

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_66b()).goodG2B_sink(data_array  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        FileInputStream finstrm2 = null;
        String propFileName = "./CWE690_NULL_Deref_From_Return__Helper.properties";
        try
        {
            finstrm2 = new FileInputStream(propFileName);
            Properties p = new Properties();
            p.load(finstrm2);

            /* POTENTIAL FLAW: data may be set to null */
            data = p.getProperty("CWE690");
        }
        catch( IOException ioe )
        {
            IO.writeLine("Could not open properties file: " + propFileName);
            data = ""; /* ensure that data is initialized */
        }
        finally
        {
            try
            {
                if( finstrm2 != null )
                {
                    finstrm2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
            }
        }

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_66b()).goodB2G_sink(data_array  );
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
