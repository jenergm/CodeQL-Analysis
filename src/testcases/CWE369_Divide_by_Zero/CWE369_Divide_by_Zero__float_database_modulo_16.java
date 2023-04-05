/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_database_modulo_16.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: database Read data from a database
* GoodSource: A hardcoded non-zero number (two)
* Sinks: modulo
*    GoodSink: Check for zero before modulo
*    BadSink : Modulo by a value that may be zero
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE369_Divide_by_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE369_Divide_by_Zero__float_database_modulo_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        float data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
            break;
        }

        while(true)
        {
            data = -1.0f; /* Initialize data */
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
                    String s_data = rs.getString(1);
                    if (s_data != null)
                    {
                        try
                        {
                            data = Float.parseFloat(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
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

        while(true)
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        float data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = -1.0f; /* Initialize data */
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
                    String s_data = rs.getString(1);
                    if (s_data != null)
                    {
                        try
                        {
                            data = Float.parseFloat(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
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

        while(true)
        {
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        float data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't a divide by zero */
            data = 2.0f;
            break;
        }

        while(true)
        {
            data = -1.0f; /* Initialize data */
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
                    String s_data = rs.getString(1);
                    if (s_data != null)
                    {
                        try
                        {
                            data = Float.parseFloat(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
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

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Possibly modulo by zero */
            int result = (int)(100.0 % data);
            IO.writeLine(result);
            break;
        }

        while(true)
        {
            /* FIX: Check for value of or near zero before modulo */
            if( Math.abs(data) > 0.000001 )
            {
                int result = (int)(100.0 % data);
                IO.writeLine(result);
            }
            else
            {
                IO.writeLine("This would result in a modulo by zero");
            }
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
