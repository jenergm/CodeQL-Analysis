/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookies_Servlet_executeQuery_22b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: Use prepared statement and executeQuery (properly)
 *    BadSink : data concatenated into SQL statment used in executeQuery(), which could result in SQL Injection
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__getCookies_Servlet_executeQuery_22b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE89_SQL_Injection__getCookies_Servlet_executeQuery_22a.bad_public_static)
        {
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
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
            finally
            {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE89_SQL_Injection__getCookies_Servlet_executeQuery_22a.goodB2G1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
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
            finally
            {
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
        else {

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

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE89_SQL_Injection__getCookies_Servlet_executeQuery_22a.goodB2G2_public_static)
        {
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
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
            finally
            {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(CWE89_SQL_Injection__getCookies_Servlet_executeQuery_22a.goodG2B_public_static)
        {
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
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
            finally
            {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
}
