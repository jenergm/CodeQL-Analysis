/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookies_Servlet_executeBatch_16.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* Sinks: executeBatch
*    GoodSink: Use prepared statement and executeBatch (properly)
*    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

public class CWE89_SQL_Injection__getCookies_Servlet_executeBatch_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            data = ""; /* initialize data in case there are no cookies */
            /* Read data from cookies */
            {
                Cookie cookieSources[] = request.getCookies();
                if (cookieSources != null)
                {
                    /* POTENTIAL FLAW: Read data from the first cookie value */
                    data = cookieSources[0].getValue();
                }
            }
            break;
        }

        while(true)
        {
            if (data != null)
            {
                String names[] = data.split("-");
                int iSuccess = 0;
                Connection conn_tmp2 = null;
                Statement sqlstatement = null;
                try
                {
                    conn_tmp2 = IO.getDBConnection();
                    sqlstatement = conn_tmp2.createStatement();
                    for(int i = 0; i < names.length; ++i)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statment used in executeBatch(), which could result in SQL Injection */
                        sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
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
                        IO.logger.log(Level.WARNING, "Error closing Statament", e);
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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* initialize data in case there are no cookies */
            /* Read data from cookies */
            {
                Cookie cookieSources[] = request.getCookies();
                if (cookieSources != null)
                {
                    /* POTENTIAL FLAW: Read data from the first cookie value */
                    data = cookieSources[0].getValue();
                }
            }
            break;
        }

        while(true)
        {
            if (data != null)
            {
                String names[] = data.split("-");
                int iSuccess = 0;
                Connection conn_tmp2 = null;
                Statement sqlstatement = null;
                try
                {
                    conn_tmp2 = IO.getDBConnection();
                    sqlstatement = conn_tmp2.createStatement();
                    for(int i = 0; i < names.length; ++i)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statment used in executeBatch(), which could result in SQL Injection */
                        sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
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
                        IO.logger.log(Level.WARNING, "Error closing Statament", e);
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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            data = ""; /* initialize data in case there are no cookies */
            /* Read data from cookies */
            {
                Cookie cookieSources[] = request.getCookies();
                if (cookieSources != null)
                {
                    /* POTENTIAL FLAW: Read data from the first cookie value */
                    data = cookieSources[0].getValue();
                }
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (data != null)
            {
                String names[] = data.split("-");
                int iSuccess = 0;
                Connection conn_tmp2 = null;
                Statement sqlstatement = null;
                try
                {
                    conn_tmp2 = IO.getDBConnection();
                    sqlstatement = conn_tmp2.createStatement();
                    for(int i = 0; i < names.length; ++i)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statment used in executeBatch(), which could result in SQL Injection */
                        sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
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
                        IO.logger.log(Level.WARNING, "Error closing Statament", e);
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
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
