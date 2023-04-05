/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__URLConnection_21.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE643_Xpath_Injection__URLConnection_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

    public void bad() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                }

                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        bad_private = true;
        bad_sink(data );
    }

    private void bad_sink(String data ) throws Throwable
    {
        if(bad_private)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1_private = false;
    private boolean goodB2G2_private = false;
    private boolean goodG2B_private = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                }

                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        goodB2G1_private = false;
        goodB2G1_sink(data );
    }

    private void goodB2G1_sink(String data ) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        else {

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

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* read input from URLConnection */
        {
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read data from a web server with URLConnection */
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                }

                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        goodB2G2_private = true;
        goodB2G2_sink(data );
    }

    private void goodB2G2_sink(String data ) throws Throwable
    {
        if(goodB2G2_private)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_private = true;
        goodG2B_sink(data );
    }

    private void goodG2B_sink(String data ) throws Throwable
    {
        if(goodG2B_private)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
