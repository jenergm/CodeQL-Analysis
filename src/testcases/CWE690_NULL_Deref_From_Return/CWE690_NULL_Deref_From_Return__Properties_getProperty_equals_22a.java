/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_22a.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-22a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
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

public class CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_22a extends AbstractTestCase
{

    /* The public static variable below is used to drive control flow in the sink function.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean bad_public_static = false;

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

        bad_public_static = true;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_22b()).bad_sink(data );
    }

    /* The public static variables below are used to drive control flow in the sink functions.
       The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodB2G1_public_static = false;
    public static boolean goodB2G2_public_static = false;
    public static boolean goodG2B_public_static = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    private void goodB2G1() throws Throwable
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

        goodB2G1_public_static = false;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_22b()).goodB2G1_sink(data );
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
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

        goodB2G2_public_static = true;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_22b()).goodB2G2_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        goodG2B_public_static = true;
        (new CWE690_NULL_Deref_From_Return__Properties_getProperty_equals_22b()).goodG2B_sink(data );
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
