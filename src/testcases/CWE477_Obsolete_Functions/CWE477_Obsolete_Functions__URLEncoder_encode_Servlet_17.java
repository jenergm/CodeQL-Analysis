/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__URLEncoder_encode_Servlet_17.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: URLEncoder_encode_Servlet
*    GoodSink: Use of preferred java.net.URLEncoder.encode(String, String)
*    BadSink : Use of deprecated java.net.URLEncoder.encode(String)
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.URLEncoder;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__URLEncoder_encode_Servlet_17 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* FLAW: Use of deprecated URLEncoder.encode(String s) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()"));
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use preferred URLEncoder.encode(String s, String encoding) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()", "UTF-8"));
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Use of deprecated URLEncoder.encode(String s) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()"));
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* FIX: Use preferred URLEncoder.encode(String s, String encoding) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()", "UTF-8"));
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
