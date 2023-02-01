/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_19.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 566 Authorization Bypass through SQL primary
* BadSource:  user id taken from url parameter
* GoodSource: hardcoded user id
* BadSink: writeConsole user authorization not checked
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_19 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            /* FLAW: Get the user ID from a URL parameter */
            data = request.getParameter("id");

            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = null;
            ResultSet rs = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);

                rs = statement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close resultset");
                }

                try
                {
                    if (statement != null)
                    {
                        statement.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close sql statement");
                }

                try
                {
                    if (conn2 != null)
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close connection");
                }
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Use a hardcoded user ID */
            data = "10";

            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = null;
            ResultSet rs = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);

                rs = statement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close resultset");
                }

                try
                {
                    if (statement != null)
                    {
                        statement.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close sql statement");
                }

                try
                {
                    if (conn2 != null)
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close connection");
                }
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            /* FIX: Use a hardcoded user ID */
            data = "10";

            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = null;
            ResultSet rs = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);

                rs = statement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close resultset");
                }

                try
                {
                    if (statement != null)
                    {
                        statement.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close sql statement");
                }

                try
                {
                    if (conn2 != null)
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close connection");
                }
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FLAW: Get the user ID from a URL parameter */
            data = request.getParameter("id");

            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = null;
            ResultSet rs = null;
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }

            try
            {
                statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);

                rs = statement.executeQuery();

                /* POTENTIAL FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close resultset");
                }

                try
                {
                    if (statement != null)
                    {
                        statement.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close sql statement");
                }

                try
                {
                    if (conn2 != null)
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    System.err.println("Could not close connection");
                }
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
