/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_12.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks:
*    GoodSink: notify user, do not use System.exit
*    BadSink : calling System.exit, breaching best practices
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

public class CWE382_Use_of_System_Exit__Servlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            System.exit(1); /* FLAW: use of System.exit */
        }
        else {

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */
        }
        else {

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
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
