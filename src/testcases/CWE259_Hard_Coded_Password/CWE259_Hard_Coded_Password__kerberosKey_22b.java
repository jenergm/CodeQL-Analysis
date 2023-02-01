/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__kerberosKey_22b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-22b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: kerberosKey
 *    GoodSink: $Sink.GoodSinkBody.description$
 *    BadSink : data used as password in KerberosKey()
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class CWE259_Hard_Coded_Password__kerberosKey_22b
{

    public String bad_source() throws Throwable
    {
        String data;

        if(CWE259_Hard_Coded_Password__kerberosKey_22a.bad_public_static)
        {
            /* FLAW: Set data to a hardcoded string */
            data = "7e5tc4s3";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* init data */

            /* FIX: Read data from the console using readLine() */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* POTENTIAL FLAW: Read data from the console using readLine */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }

            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        return data;
    }

    /* goodG2B1() - use goodsource and badsink by setting the static variable to false instead of true */
    public String goodG2B1_source() throws Throwable
    {
        String data;

        if(CWE259_Hard_Coded_Password__kerberosKey_22a.goodG2B1_public_static)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Set data to a hardcoded string */
            data = "7e5tc4s3";
        }
        else {

            data = ""; /* init data */

            /* FIX: Read data from the console using readLine() */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* POTENTIAL FLAW: Read data from the console using readLine */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }

            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        return data;
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the if in the sink function */
    public String goodG2B2_source() throws Throwable
    {
        String data;

        if(CWE259_Hard_Coded_Password__kerberosKey_22a.goodG2B2_public_static)
        {
            data = ""; /* init data */
            /* FIX: Read data from the console using readLine() */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine */
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

            /* FLAW: Set data to a hardcoded string */
            data = "7e5tc4s3";

        }
        return data;
    }
}
