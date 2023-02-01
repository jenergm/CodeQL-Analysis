/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__getQueryString_Servlet_51b.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Xpath_Injection__getQueryString_Servlet_51b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        final String xmldoc = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";

        if (data != null)
        {
            /* assume username||password as source */
            String [] tokens = data.split("||");
            if( tokens.length < 2 )
            {
                return;
            }
            String uname = tokens[0];
            String pword = tokens[1];
            /* build xpath */
            XPath xp = XPathFactory.newInstance().newXPath();
            InputSource inxml = new InputSource(xmldoc);
            /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
             * 	The user input should be canonicalized before validation.
             */
            /* POTENTIAL FLAW: user input is used without validate */
            String query = "//users/user[name/text()='" + uname +
            "' and pass/text()='" + pword + "']" +
            "/secret/text()";
            String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        final String xmldoc = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";

        if (data != null)
        {
            /* assume username||password as source */
            String [] tokens = data.split("||");
            if( tokens.length < 2 )
            {
                return;
            }
            String uname = tokens[0];
            String pword = tokens[1];
            /* build xpath */
            XPath xp = XPathFactory.newInstance().newXPath();
            InputSource inxml = new InputSource(xmldoc);
            /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
             * 	The user input should be canonicalized before validation.
             */
            /* POTENTIAL FLAW: user input is used without validate */
            String query = "//users/user[name/text()='" + uname +
            "' and pass/text()='" + pword + "']" +
            "/secret/text()";
            String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        final String xmldoc = "\\src\\testcases\\CWE643_Xpath Injection\\CWE643_Xpath_Injection__Helper.xml";

        if (data != null)
        {
            /* assume username||password as source */
            String [] tokens = data.split("||");
            if( tokens.length < 2 )
            {
                return;
            }
            /* FIX: validate input using StringEscapeUtils */
            String uname = StringEscapeUtils.escapeXml(tokens[0]);
            String pword = StringEscapeUtils.escapeXml(tokens[1]);
            /* build xpath */
            XPath xp = XPathFactory.newInstance().newXPath();
            InputSource inxml = new InputSource(xmldoc);
            String query = "//users/user[name/text()='" + uname +
            "' and pass/text()='" + pword + "']" +
            "/secret/text()";
            String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);
        }

    }
}
