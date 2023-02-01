/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_08.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 523 Unprotected Transport of Credentials
* Sinks: non_ssl
*    GoodSink: Send across SSL connection
*    BadSink : Send across non-SSL connection
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_08 extends AbstractTestCaseServlet
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_returns_t())
        {
            PrintWriter out = null;
            try
            {
                out = response.getWriter();
                /* FLAW: transmitting login credentials across a non-SSL connection */
                out.println("<form action='http://hostname.com/j_security_check' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Name:</td>");
                out.println("<td><input type='text' name='j_username'></td></tr>");
                out.println("<tr><td>Password:</td>");
                out.println("<td><input type='password' name='j_password' size='8'></td>");
                out.println("</tr>");
                out.println("</table><br />");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
            }
            catch( IOException e )
            {
                IO.writeLine("There was a problem writing");
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            PrintWriter out = null;
            try
            {
                out = response.getWriter();

                /* FIX: ensure the connection is secure (https) */
                out.println("<form action='https://hostname.com/j_security_check' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Name:</td>");
                out.println("<td><input type='text' name='j_username'></td></tr>");
                out.println("<tr><td>Password:</td>");
                out.println("<td><input type='password' name='j_password' size='8'></td>");
                out.println("</tr>");
                out.println("</table><br />");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
            }
            catch( IOException e )
            {
                IO.writeLine("There was a problem writing");
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            PrintWriter out = null;
            try
            {
                out = response.getWriter();
                /* FLAW: transmitting login credentials across a non-SSL connection */
                out.println("<form action='http://hostname.com/j_security_check' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Name:</td>");
                out.println("<td><input type='text' name='j_username'></td></tr>");
                out.println("<tr><td>Password:</td>");
                out.println("<td><input type='password' name='j_password' size='8'></td>");
                out.println("</tr>");
                out.println("</table><br />");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
            }
            catch( IOException e )
            {
                IO.writeLine("There was a problem writing");
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }
            }
        }
        else {

            PrintWriter out = null;
            try
            {
                out = response.getWriter();

                /* FIX: ensure the connection is secure (https) */
                out.println("<form action='https://hostname.com/j_security_check' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Name:</td>");
                out.println("<td><input type='text' name='j_username'></td></tr>");
                out.println("<tr><td>Password:</td>");
                out.println("<td><input type='password' name='j_password' size='8'></td>");
                out.println("</tr>");
                out.println("</table><br />");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
            }
            catch( IOException e )
            {
                IO.writeLine("There was a problem writing");
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            PrintWriter out = null;
            try
            {
                out = response.getWriter();
                /* FIX: ensure the connection is secure (https) */
                out.println("<form action='https://hostname.com/j_security_check' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Name:</td>");
                out.println("<td><input type='text' name='j_username'></td></tr>");
                out.println("<tr><td>Password:</td>");
                out.println("<td><input type='password' name='j_password' size='8'></td>");
                out.println("</tr>");
                out.println("</table><br />");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
            }
            catch( IOException e )
            {
                IO.writeLine("There was a problem writing");
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            PrintWriter out = null;
            try
            {
                out = response.getWriter();

                /* FLAW: transmitting login credentials across a non-SSL connection */
                out.println("<form action='http://hostname.com/j_security_check' method='post'>");
                out.println("<table>");
                out.println("<tr><td>Name:</td>");
                out.println("<td><input type='text' name='j_username'></td></tr>");
                out.println("<tr><td>Password:</td>");
                out.println("<td><input type='password' name='j_password' size='8'></td>");
                out.println("</tr>");
                out.println("</table><br />");
                out.println("<input type='submit' value='login'>");
                out.println("</form>");
            }
            catch( IOException e )
            {
                IO.writeLine("There was a problem writing");
            }
            finally
            {
                if( out != null )
                {
                    out.close();
                }
            }

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
