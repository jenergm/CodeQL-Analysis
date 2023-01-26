/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Property_executeBatch_04.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* Sinks: executeBatch
*    GoodSink: Use prepared statement and executeBatch (properly)
*    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__Property_executeBatch_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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

    /* goodG2B1() - use goodsource and badsink by changing first private_final_t to private_final_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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

    /* goodB2G1() - use badsource and goodsink by changing second private_final_t to private_final_f */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
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
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
