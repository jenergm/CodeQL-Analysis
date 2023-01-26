/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__connect_tcp_executeQuery_73b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: Use prepared statement and executeQuery (properly)
 *    BadSink : data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__connect_tcp_executeQuery_73b
{

    public void bad_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection */
            sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");

            IO.writeLine(sqlrs.getRow()); /* Use ResultSet in some way */
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", e);
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
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

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection */
            sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");

            IO.writeLine(sqlrs.getRow()); /* Use ResultSet in some way */
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", e);
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
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

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            /* FIX: Use prepared statement and executeQuery (properly) */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
            sqlstatement.setString(1, data);

            sqlrs = sqlstatement.executeQuery();

            IO.writeLine(sqlrs.getRow()); /* Use ResultSet in some way */
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatment", e);
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
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
}
