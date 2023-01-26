/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__File_21.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-21.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.http.*;

import java.util.Hashtable;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE90_LDAP_Injection__File_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the source function */
    private boolean bad_private = false;

    public void bad() throws Throwable
    {
        String data;

        bad_private = true;
        data = bad_source();

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
        String search = "(cn=" + data + ")";

        NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    IO.writeLine(" Value: " + values.next().toString());
                }
            }
        }

    }

    private String bad_source() throws Throwable
    {
        String data;

        if(bad_private)
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        return data;
    }

    /* The variables below are used to drive control flow in the source functions. */
    private boolean goodG2B1_private = false;
    private boolean goodG2B2_private = false;

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }

    /* goodG2B1() - use goodsource and badsink by setting the variable to false instead of true */
    private void goodG2B1() throws Throwable
    {
        String data;

        goodG2B1_private = false;
        data = goodG2B1_source();

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
        String search = "(cn=" + data + ")";

        NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    IO.writeLine(" Value: " + values.next().toString());
                }
            }
        }

    }

    private String goodG2B1_source() throws Throwable
    {
        String data;

        if(goodG2B1_private)
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
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    private void goodG2B2() throws Throwable
    {
        String data;

        goodG2B2_private = true;
        data = goodG2B2_source();

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = new InitialDirContext(env);

        /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
        String search = "(cn=" + data + ")";

        NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    IO.writeLine(" Value: " + values.next().toString());
                }
            }
        }

    }

    private String goodG2B2_source() throws Throwable
    {
        String data;

        if(goodG2B2_private)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;

                try {
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
                finally {
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

        }
        return data;
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
