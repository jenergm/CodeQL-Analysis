/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE535_Info_Exposure_Shell_Error__Servlet_08.java
Label Definition File: CWE535_Info_Exposure_Shell_Error__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 535 Information Exposure through Shell Error
* Sinks:
*    GoodSink: write non-sensitive information to stderr
*    BadSink : Expose the session ID to stderr
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE535_Info_Exposure_Shell_Error;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE535_Info_Exposure_Shell_Error__Servlet_08 extends AbstractTestCaseServlet
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
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            OutputStreamWriter oswrite = null;
            PrintWriter out = null;
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                oswrite = new OutputStreamWriter(System.err, "UTF-8");
                out = new PrintWriter(oswrite);
                /* FLAW: Expose the session ID to stderr */
                out.println("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
            try
            {
                if (oswrite != null)
                {
                    oswrite.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");
            OutputStreamWriter oswrite = null;
            PrintWriter out = null;

            if (username.matches("[a-zA-Z0-9]*"))
            {
                oswrite = new OutputStreamWriter(System.err, "UTF-8");
                out = new PrintWriter(oswrite);
                /* FIX: message to stderr does not contain session id */
                out.println("Username: " + username + " logged in");
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }

            try
            {
                if (oswrite != null)
                {
                    oswrite.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            OutputStreamWriter oswrite = null;
            PrintWriter out = null;
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                oswrite = new OutputStreamWriter(System.err, "UTF-8");
                out = new PrintWriter(oswrite);
                /* FLAW: Expose the session ID to stderr */
                out.println("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
            try
            {
                if (oswrite != null)
                {
                    oswrite.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
        }
        else {

            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");
            OutputStreamWriter oswrite = null;
            PrintWriter out = null;

            if (username.matches("[a-zA-Z0-9]*"))
            {
                oswrite = new OutputStreamWriter(System.err, "UTF-8");
                out = new PrintWriter(oswrite);
                /* FIX: message to stderr does not contain session id */
                out.println("Username: " + username + " logged in");
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }

            try
            {
                if (oswrite != null)
                {
                    oswrite.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            OutputStreamWriter oswrite = null;
            PrintWriter out = null;
            if (username.matches("[a-zA-Z0-9]*"))
            {
                oswrite = new OutputStreamWriter(System.err, "UTF-8");
                out = new PrintWriter(oswrite);
                /* FIX: message to stderr does not contain session id */
                out.println("Username: " + username + " logged in");
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
            try
            {
                if (oswrite != null)
                {
                    oswrite.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");
            OutputStreamWriter oswrite = null;
            PrintWriter out = null;

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                oswrite = new OutputStreamWriter(System.err, "UTF-8");
                out = new PrintWriter(oswrite);
                /* FLAW: Expose the session ID to stderr */
                out.println("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }

            try
            {
                if (oswrite != null)
                {
                    oswrite.close();
                }
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
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
