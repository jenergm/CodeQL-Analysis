/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_52c.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-52c.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    BadSink : user authorization not checked
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_52c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

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

}
