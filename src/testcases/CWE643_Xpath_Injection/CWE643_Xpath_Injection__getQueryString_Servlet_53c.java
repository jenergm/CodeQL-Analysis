/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__getQueryString_Servlet_53c.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Xpath_Injection__getQueryString_Servlet_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE643_Xpath_Injection__getQueryString_Servlet_53d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE643_Xpath_Injection__getQueryString_Servlet_53d()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE643_Xpath_Injection__getQueryString_Servlet_53d()).goodB2G_sink(data , request, response);
    }
}
