/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__PropertiesFile_12.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-12.tmpl.java
*/
/*
* @description
* CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: Set data to a hardcoded class name
* BadSink:  Instantiate class named in data
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
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

public class CWE470_Unsafe_Reflection__PropertiesFile_12 extends AbstractTestCase
{

    /* uses badsource and badsink - see how tools report flaws that don't always occur */
    public void bad() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
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

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B() - use goodsource and badsink by changing the "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /* FIX: Use a hardcoded class name */
            data = "Testing.test";
        }
        else {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    public void good() throws Throwable
    {
        goodG2B();
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
