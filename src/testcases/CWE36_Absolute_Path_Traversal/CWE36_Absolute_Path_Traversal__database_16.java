/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__database_16.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-16.tmpl.java
*/
/*
* @description
* CWE: 36 Absolute Path Traversal
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* BadSink: readFile read line from file from disk
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE36_Absolute_Path_Traversal__database_16 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
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
            break;
        }

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        if (data != null)
        {
            File fIn = new File(data);
            FileInputStream fisSink = null;
            InputStreamReader isreadSink = null;
            BufferedReader buffreadSink = null;
            if( fIn.exists() && fIn.isFile() )
            {
                try
                {
                    fisSink = new FileInputStream(fIn);
                    isreadSink = new InputStreamReader(fisSink, "UTF-8");
                    buffreadSink = new BufferedReader(isreadSink);
                    IO.writeLine(buffreadSink.readLine());
                }
                catch ( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try
                    {
                        if( buffreadSink != null )
                        {
                            buffreadSink.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try
                    {
                        if( isreadSink != null )
                        {
                            isreadSink.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try
                    {
                        if( fisSink != null )
                        {
                            fisSink.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
        }

    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the while statements */
    private void goodG2B() throws Throwable
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
            break;
        }

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        if (data != null)
        {
            File fIn = new File(data);
            FileInputStream fisSink = null;
            InputStreamReader isreadSink = null;
            BufferedReader buffreadSink = null;
            if( fIn.exists() && fIn.isFile() )
            {
                try
                {
                    fisSink = new FileInputStream(fIn);
                    isreadSink = new InputStreamReader(fisSink, "UTF-8");
                    buffreadSink = new BufferedReader(isreadSink);
                    IO.writeLine(buffreadSink.readLine());
                }
                catch ( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try
                    {
                        if( buffreadSink != null )
                        {
                            buffreadSink.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try
                    {
                        if( isreadSink != null )
                        {
                            isreadSink.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try
                    {
                        if( fisSink != null )
                        {
                            fisSink.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
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
