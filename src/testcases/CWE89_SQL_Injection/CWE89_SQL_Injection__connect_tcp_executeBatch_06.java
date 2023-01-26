/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__connect_tcp_executeBatch_06.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-06.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: connect_tcp Read data using an outbound tcp connection
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__connect_tcp_executeBatch_06 extends AbstractTestCase
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
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
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
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
    private void goodG2B2() throws Throwable
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

            data = ""; /* Initialize data */

            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);

                    /* read input from socket */

                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }

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
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
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
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    sock = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* clean up stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* clean up socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }
                }
            }
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
