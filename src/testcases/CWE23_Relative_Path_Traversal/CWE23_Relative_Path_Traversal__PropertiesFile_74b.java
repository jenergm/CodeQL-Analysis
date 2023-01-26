/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__PropertiesFile_74b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;
import java.util.HashMap;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__PropertiesFile_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

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
