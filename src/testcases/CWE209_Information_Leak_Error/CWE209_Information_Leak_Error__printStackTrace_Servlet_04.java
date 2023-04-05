/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_Servlet_04.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace_Servlet
*    GoodSink: Print a generic error message to response
*    BadSink : Print stack trace to response
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__printStackTrace_Servlet_04 extends AbstractTestCaseServlet
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_final_t)
        {
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                uoe.printStackTrace(response.getWriter()); /* FLAW: Print stack trace in response on error */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                response.getWriter().println("There was an unsupported operation error"); /* FIX: print a generic error message to response */
            }

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                uoe.printStackTrace(response.getWriter()); /* FLAW: Print stack trace in response on error */
            }
        }
        else {

            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                response.getWriter().println("There was an unsupported operation error"); /* FIX: print a generic error message to response */
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_t)
        {
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                response.getWriter().println("There was an unsupported operation error"); /* FIX: print a generic error message to response */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                uoe.printStackTrace(response.getWriter()); /* FLAW: Print stack trace in response on error */
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
