/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__console_readLine_04.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-04.tmpl.java
*/
/*
* @description
* CWE: 90 LDAP Injection
* BadSource: console_readLine Read data from the console using readLine()
* GoodSource: A hardcoded string
* BadSink:  data concatenated into LDAP search, which could result in LDAP Injection
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
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
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE90_LDAP_Injection__console_readLine_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        if(private_final_t)
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

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

    /* goodG2B1() - use goodsource and badsink by changing private_final_t to private_final_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if(private_final_t)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* read user input from console with readLine */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }

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

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
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
