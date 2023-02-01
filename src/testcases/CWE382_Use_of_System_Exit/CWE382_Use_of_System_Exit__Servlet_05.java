/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_05.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks:
*    GoodSink: notify user, do not use System.exit
*    BadSink : calling System.exit, breaching best practices
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

public class CWE382_Use_of_System_Exit__Servlet_05 extends AbstractTestCaseServlet
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_t)
        {
            System.exit(1); /* FLAW: use of System.exit */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    /* good1() changes private_t to private_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            System.exit(1); /* FLAW: use of System.exit */
        }
        else {

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_t)
        {
            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            System.exit(1); /* FLAW: use of System.exit */

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
