/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_61b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-61b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: passwordAuth
 *    BadSink : data used as password in PasswordAuthentication()
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
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

public class CWE259_Hard_Coded_Password__passwordAuth_61b
{

    public String bad_source() throws Throwable
    {
        String data;

        /* FLAW: Set data to a hardcoded string */
        data = "7e5tc4s3";

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source() throws Throwable
    {
        String data;

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

        return data;
    }

}
