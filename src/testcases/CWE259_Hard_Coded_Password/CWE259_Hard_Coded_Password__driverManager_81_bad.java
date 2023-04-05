/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_81_bad.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: driverManager
 *    BadSink : data used as password in database connection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_81_bad extends CWE259_Hard_Coded_Password__driverManager_81_base
{

    public void action(String data ) throws Throwable
    {

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

}
