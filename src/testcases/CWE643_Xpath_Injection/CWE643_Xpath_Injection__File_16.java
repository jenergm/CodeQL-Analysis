/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__File_16.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 643 Xpath Injection
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: unvalidatedXPath
*    GoodSink: validate input through StringEscapeUtils
*    BadSink : user input is used without validate
* Flow Variant: 16 Control flow: while(true) and while(local_f)
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
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE643_Xpath_Injection__File_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            data = ""; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
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
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
            break;
        }

        while(true)
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
            break;
        }

        while(local_f)
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
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
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
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
            break;
        }

        while(true)
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
            break;
        }

        while(local_f)
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
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            data = ""; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
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
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
            break;
        }

        while(local_f)
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
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
