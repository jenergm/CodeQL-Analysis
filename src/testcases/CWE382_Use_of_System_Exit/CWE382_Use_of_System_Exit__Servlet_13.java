/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_Use_of_System_Exit__Servlet_13.java
Label Definition File: CWE382_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-13.tmpl.java
*/
/*
* @description
* CWE: 382 Use of System.exit()
* Sinks:
*    GoodSink: notify user, do not use System.exit
*    BadSink : calling System.exit, breaching best practices
* Flow Variant: 13 Control flow: if(IO.static_final_five==5) and if(IO.static_final_five!=5)
*
* */

package testcases.CWE382_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

public class CWE382_Use_of_System_Exit__Servlet_13 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_final_five==5)
        {
            System.exit(1); /* FLAW: use of System.exit */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    /* good1() changes IO.static_final_five==5 to IO.static_final_five!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_final_five!=5)
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
        if(IO.static_final_five==5)
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
