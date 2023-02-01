/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__Environment_75a.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-75a.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: Environment Read data from an environment variable
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__Environment_75a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE606_Unchecked_Loop_Condition__Environment_75b()).bad_sink(data_serialized  );
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
        String data;

        /* FIX: Use a hardcoded int as a string */
        data = "5";

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE606_Unchecked_Loop_Condition__Environment_75b()).goodG2B_sink(data_serialized  );
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
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE606_Unchecked_Loop_Condition__Environment_75b()).goodB2G_sink(data_serialized  );
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
