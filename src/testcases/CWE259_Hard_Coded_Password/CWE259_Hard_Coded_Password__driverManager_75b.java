/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_75b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-75b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: driverManager
 *    BadSink : data used as password in database connection
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_75b
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

            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;

            if (data != null)
            {
                try
                {
                    /* POTENTIAL FLAW: data used as password in database connection */
                    conn2 = DriverManager.getConnection("data-url", "root", data);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
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

            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;

            if (data != null)
            {
                try
                {
                    /* POTENTIAL FLAW: data used as password in database connection */
                    conn2 = DriverManager.getConnection("data-url", "root", data);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
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
