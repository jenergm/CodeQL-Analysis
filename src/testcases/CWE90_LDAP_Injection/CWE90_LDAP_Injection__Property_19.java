/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Property_19.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 90 LDAP Injection
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* BadSink:  data concatenated into LDAP search, which could result in LDAP Injection
* Flow Variant: 19 Control flow: Dead code after an if(true) return
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

public class CWE90_LDAP_Injection__Property_19 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        {

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

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

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

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
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        String data;
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

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

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

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
    }

    public void good() throws Throwable
    {
        goodG2B();
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
