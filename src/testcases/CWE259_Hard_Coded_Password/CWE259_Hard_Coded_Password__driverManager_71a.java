/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_71a.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-71a.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: driverManager
 *    BadSink : data used as password in database connection
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
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

public class CWE259_Hard_Coded_Password__driverManager_71a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* FLAW: Set data to a hardcoded string */
        data = "7e5tc4s3";

        (new CWE259_Hard_Coded_Password__driverManager_71b()).bad_sink((Object)data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
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

        (new CWE259_Hard_Coded_Password__driverManager_71b()).goodG2B_sink((Object)data  );
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
