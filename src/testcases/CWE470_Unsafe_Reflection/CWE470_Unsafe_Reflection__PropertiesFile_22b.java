/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__PropertiesFile_22b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : Instantiate class named in data
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__PropertiesFile_22b
{

    public String bad_source() throws Throwable
    {
        String data;

        if(CWE470_Unsafe_Reflection__PropertiesFile_22a.bad_public_static)
        {
            data = ""; /* Initialize data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                /* POTENTIAL FLAW: Read data from a .properties file */
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source() throws Throwable
    {
        String data;

        if(CWE470_Unsafe_Reflection__PropertiesFile_22a.goodG2B1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                /* POTENTIAL FLAW: Read data from a .properties file */
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
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
        }
        else {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2_source() throws Throwable
    {
        String data;

        if(CWE470_Unsafe_Reflection__PropertiesFile_22a.goodG2B2_public_static)
        {
            /* FIX: Use a hardcoded class name */
            data = "Testing.test";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = props.getProperty("data");
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

        }
        return data;
    }
}
