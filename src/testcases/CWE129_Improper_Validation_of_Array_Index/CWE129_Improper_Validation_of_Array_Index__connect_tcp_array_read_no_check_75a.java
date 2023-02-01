/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_75a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-75a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_read_no_check
 *    GoodSink: Read from array after verifying index
 *    BadSink : Read from array without any verification of index
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index;

import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_75a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* Read data using an outbound tcp connection */
        {
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                String s_data = buffread.readLine();
                if (s_data != null)  // avoid NPD incidental warnings
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
                /* clean up stream reading objects */
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
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", e);
                }
            }
        }

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_75b()).bad_sink(data_serialized  );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
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

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_75b()).goodG2B_sink(data_serialized  );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
            }
        }
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* Read data using an outbound tcp connection */
        {
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                String s_data = buffread.readLine();
                if (s_data != null)  // avoid NPD incidental warnings
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
                /* clean up stream reading objects */
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
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", e);
                }
            }
        }

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE129_Improper_Validation_of_Array_Index__connect_tcp_array_read_no_check_75b()).goodB2G_sink(data_serialized  );
        }
        catch (IOException e)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", e);
        }
        finally {
            // clean up stream writing objects
            try {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", ioe);
            }

            try {
                if (baos != null)
                {
                    baos.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", ioe);
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
