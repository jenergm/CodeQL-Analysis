/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getQueryString_Servlet_22b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : Instantiate class named in data
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;

public class CWE470_Unsafe_Reflection__getQueryString_Servlet_22b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE470_Unsafe_Reflection__getQueryString_Servlet_22a.bad_public_static)
        {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE470_Unsafe_Reflection__getQueryString_Servlet_22a.goodG2B1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        }
        else {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if(CWE470_Unsafe_Reflection__getQueryString_Servlet_22a.goodG2B2_public_static)
        {
            /* FIX: Use a hardcoded class name */
            data = "Testing.test";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        return data;
    }
}
