/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__listen_tcp_execute_81_goodB2G.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: execute
 *    GoodSink: Use prepared statement and execute (properly)
 *    BadSink : data concatenated into SQL statment used in execute(), which could result in SQL Injection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__listen_tcp_execute_81_goodB2G extends CWE89_SQL_Injection__listen_tcp_execute_81_base
{

    public void action(String data ) throws Throwable
    {

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;

        try {
            /* FIX: Use prepared statement and execute (properly) */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
            sqlstatement.setString(1, data);

            Boolean bResult = sqlstatement.execute();

            if( bResult )
            {
                IO.writeLine("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeLine("Unable to update records for user: " + data);
            }
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", se);
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
                IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
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
