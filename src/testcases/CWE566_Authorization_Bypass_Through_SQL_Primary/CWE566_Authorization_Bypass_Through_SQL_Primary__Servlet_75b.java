/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_75b.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-75b.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    BadSink : user authorization not checked
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_75b
{

    public void bad_sink(byte[] data_serialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            String data = (String)in.readObject();

            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = null;
            ResultSet rs = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);

                rs = statement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close resultset");
                }

                try
                {
                    if (statement != null)
                    {
                        statement.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close sql statement");
                }

                try
                {
                    if (conn2 != null)
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close connection");
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
    public void goodG2B_sink(byte[] data_serialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        // unserialize data
        ByteArrayInputStream bais = null;
        ObjectInputStream in = null;

        try {
            bais = new ByteArrayInputStream(data_serialized);
            in = new ObjectInputStream(bais);
            String data = (String)in.readObject();

            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = null;
            ResultSet rs = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);

                rs = statement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close resultset");
                }

                try
                {
                    if (statement != null)
                    {
                        statement.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close sql statement");
                }

                try
                {
                    if (conn2 != null)
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close connection");
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
