/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__File_75b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-75b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__File_75b
{

    public void bad_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            String data = (String)in.readObject();

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
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            String data = (String)in.readObject();

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
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", e);
        }
        catch (ClassNotFoundException e)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", e);
        }
        finally {
            // clean up stream reading objects
            try {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", ioe);
            }

            try {
                if (bais != null)
                {
                    bais.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", ioe);
            }
        }
    }

}
