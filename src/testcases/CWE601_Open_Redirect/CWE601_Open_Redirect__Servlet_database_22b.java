/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_database_22b.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;
import java.net.URI;
import java.net.URISyntaxException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE601_Open_Redirect__Servlet_database_22b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE601_Open_Redirect__Servlet_database_22a.bad_public_static)
        {
            data = ""; /* Initialize data */
            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
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
                finally
                {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE601_Open_Redirect__Servlet_database_22a.goodG2B1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
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
                finally
                {
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
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE601_Open_Redirect__Servlet_database_22a.goodG2B2_public_static)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        return data;
    }
}
