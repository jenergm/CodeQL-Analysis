/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__printStackTrace_Servlet_16.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* Sinks: printStackTrace_Servlet
*    GoodSink: Print a generic error message to response
*    BadSink : Print stack trace to response
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__printStackTrace_Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                uoe.printStackTrace(response.getWriter()); /* FLAW: Print stack trace in response on error */
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                response.getWriter().println("There was an unsupported operation error"); /* FIX: print a generic error message to response */
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false;

        while(local_f)
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
            break;
        }

        while(true)
        {
            try
            {
                throw new UnsupportedOperationException();
            }
            catch( UnsupportedOperationException uoe )
            {
                response.getWriter().println("There was an unsupported operation error"); /* FIX: print a generic error message to response */
            }
            break;
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
