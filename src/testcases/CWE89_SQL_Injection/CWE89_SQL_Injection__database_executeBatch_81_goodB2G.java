/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__database_executeBatch_81_goodB2G.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-81_goodB2G.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
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

public class CWE89_SQL_Injection__database_executeBatch_81_goodB2G extends CWE89_SQL_Injection__database_executeBatch_81_base
{

    public void action(String data ) throws Throwable
    {

        if (data != null)
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: Use prepared statement and executeBatch (properly) */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                for(int i = 0; i < names.length; ++i)
                {
                    sqlstatement.setString(1, names[i]);
                    sqlstatement.addBatch();
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeLine("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                IO.logger.log(Level.WARNING, "Error getting database connection", se);
            }
            finally
            {
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

}
