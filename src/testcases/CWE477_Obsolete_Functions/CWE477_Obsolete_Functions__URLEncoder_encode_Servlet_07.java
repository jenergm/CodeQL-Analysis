/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__URLEncoder_encode_Servlet_07.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: URLEncoder_encode_Servlet
*    GoodSink: Use of preferred java.net.URLEncoder.encode(String, String)
*    BadSink : Use of deprecated java.net.URLEncoder.encode(String)
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.URLEncoder;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__URLEncoder_encode_Servlet_07 extends AbstractTestCaseServlet
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_five==5)
        {
            /* FLAW: Use of deprecated URLEncoder.encode(String s) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()"));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use preferred URLEncoder.encode(String s, String encoding) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()", "UTF-8"));

        }
    }

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Use of deprecated URLEncoder.encode(String s) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()"));
        }
        else {

            /* FIX: Use preferred URLEncoder.encode(String s, String encoding) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()", "UTF-8"));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_five==5)
        {
            /* FIX: Use preferred URLEncoder.encode(String s, String encoding) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()", "UTF-8"));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Use of deprecated URLEncoder.encode(String s) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()"));

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
