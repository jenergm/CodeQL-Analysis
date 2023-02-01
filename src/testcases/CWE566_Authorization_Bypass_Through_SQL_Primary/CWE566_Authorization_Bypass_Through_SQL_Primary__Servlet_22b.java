/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22b.java
Label Definition File: CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 566 Authorization Bypass through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : user authorization not checked
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE566_Authorization_Bypass_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22a.bad_public_static)
        {
            /* FLAW: Get the user ID from a URL parameter */
            data = request.getParameter("id");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded user ID */
            data = "10";

        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22a.goodG2B1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Get the user ID from a URL parameter */
            data = request.getParameter("id");
        }
        else {

            /* FIX: Use a hardcoded user ID */
            data = "10";

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE566_Authorization_Bypass_Through_SQL_Primary__Servlet_22a.goodG2B2_public_static)
        {
            /* FIX: Use a hardcoded user ID */
            data = "10";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Get the user ID from a URL parameter */
            data = request.getParameter("id");

        }
        return data;
    }
}
