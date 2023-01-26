/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getParameter_Servlet_executeBatch_06.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-06.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: A hardcoded string
* Sinks: executeBatch
*    GoodSink: Use prepared statement and executeBatch (properly)
*    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
* Flow Variant: 06 Control flow: if(private_final_five==5) and if(private_final_five!=5)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__getParameter_Servlet_executeBatch_06 extends AbstractTestCaseServlet
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        }
        else {
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

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_final_five==5 to private_final_five!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        }
        else {
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

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        }
        else {
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

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_final_five==5 to private_final_five!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
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
        }
        else {

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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        else {
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

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
