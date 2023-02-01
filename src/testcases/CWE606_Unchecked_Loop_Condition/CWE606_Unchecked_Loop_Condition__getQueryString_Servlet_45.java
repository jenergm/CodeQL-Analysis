/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_45.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;

public class CWE606_Unchecked_Loop_Condition__getQueryString_Servlet_45 extends AbstractTestCaseServlet
{

    private String bad_data;
    private String goodG2B_data;
    private String goodB2G_data;

    private void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_data;

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        for(int i=0; i < loopNum; i++)
        {
            /* POTENTIAL FLAW: user supplied input used for loop counter test */
            IO.writeLine("hello world");
        }

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        bad_data = data;
        bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_data;

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        for(int i=0; i < loopNum; i++)
        {
            /* POTENTIAL FLAW: user supplied input used for loop counter test */
            IO.writeLine("hello world");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded int as a string */
        data = "5";

        goodG2B_data = data;
        goodG2B_sink(request, response);
    }

    private void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodB2G_data;

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        /* FIX: loop number thresholds validated */
        if (loopNum >= 0 && loopNum <= 5)
        {
            for(int i=0; i < loopNum; i++)
            {
                IO.writeLine("hello world");
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        goodB2G_data = data;
        goodB2G_sink(request, response);
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
