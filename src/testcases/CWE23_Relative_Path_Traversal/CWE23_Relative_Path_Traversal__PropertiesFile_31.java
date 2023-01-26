/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__PropertiesFile_31.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__PropertiesFile_31 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data_copy;
        {
            String data;

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

            data_copy = data;
        }
        {
            String data = data_copy;

            String root = "C:\\uploads\\";

            if (data != null)
            {
                /* POTENTIAL FLAW: no validation of concatenated value */
                File fIn = new File(root + data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data_copy;
        {
            String data;

            /* FIX: Use a hardcoded string */
            data = "foo";

            data_copy = data;
        }
        {
            String data = data_copy;

            String root = "C:\\uploads\\";

            if (data != null)
            {
                /* POTENTIAL FLAW: no validation of concatenated value */
                File fIn = new File(root + data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
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
