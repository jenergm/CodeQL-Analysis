/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_Property_modulo_75b.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-75b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_Property_modulo_75b
{

    public void bad_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            float data = (Float)in.readObject();

            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);

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

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            float data = (Float)in.readObject();

            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);

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

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(byte[] data_serialized ) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            float data = (Float)in.readObject();

            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
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
