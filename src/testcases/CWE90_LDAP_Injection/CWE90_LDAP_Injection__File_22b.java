/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__File_22b.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
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

public class CWE90_LDAP_Injection__File_22b
{

    public String bad_source() throws Throwable
    {
        String data;

        if(CWE90_LDAP_Injection__File_22a.bad_public_static)
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

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source() throws Throwable
    {
        String data;

        if(CWE90_LDAP_Injection__File_22a.goodG2B1_public_static)
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
    public String goodG2B2_source() throws Throwable
    {
        String data;

        if(CWE90_LDAP_Injection__File_22a.goodG2B2_public_static)
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
}
