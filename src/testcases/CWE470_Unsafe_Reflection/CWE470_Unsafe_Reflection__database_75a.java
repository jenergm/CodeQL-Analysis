/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__database_75a.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-75a.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: database Read data from a database
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__database_75a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* Read data from a database */
        {
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            try {
                /* setup the connection */
                conn = IO.getDBConnection();

                /* prepare and execute a (hardcoded) query */
                statement = conn.prepareStatement("select name from users where id=0");
                rs = statement.executeQuery();

                /* POTENTIAL FLAW: Read data from a database query resultset */
                data = rs.getString(1);
            }
            catch( SQLException se )
            {
                IO.logger.log(Level.WARNING, "Error with SQL statement", se);
            }
            finally {
                /* Close database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                }

                try {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", se);
                }

                try {
                    if( conn != null )
                    {
                        conn.close();
                    }
                }
                catch( SQLException se)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
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
            (new CWE470_Unsafe_Reflection__database_75b()).bad_sink(data_serialized  );
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
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded class name */
        data = "Testing.test";

        // serialize data to a byte array
        ByteArrayOutputStream baos = null;
        ObjectOutput out = null;

        try {
            baos = new ByteArrayOutputStream() ;
            out = new ObjectOutputStream(baos) ;
            out.writeObject(data);
            byte[] data_serialized = baos.toByteArray();
            (new CWE470_Unsafe_Reflection__database_75b()).goodG2B_sink(data_serialized  );
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
