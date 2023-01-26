/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__listen_tcp_75b.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-75b.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

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

public class CWE36_Absolute_Path_Traversal__listen_tcp_75b
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

            /* POTENTIAL FLAW: unvalidated or sandboxed value */
            if (data != null)
            {
                File fIn = new File(data);
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

            /* POTENTIAL FLAW: unvalidated or sandboxed value */
            if (data != null)
            {
                File fIn = new File(data);
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
