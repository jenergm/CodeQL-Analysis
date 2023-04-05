/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__console_readLine_write_53d.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: console_readLine Read count from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__console_readLine_write_53d
{

    public void bad_sink(int count ) throws Throwable
    {

        File file = new File("badSink.txt");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter buffwrite = new BufferedWriter(oswrite);
        int i;

        /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
        for (i = 0; i < count; i++)
        {
            try
            {
                buffwrite.write("Hello");
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
            }
        }

        /* Close stream reading objects */
        try
        {
            if( buffwrite != null )
            {
                buffwrite.close();
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
        }

        try
        {
            if( oswrite != null )
            {
                oswrite.close();
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
        }

        try
        {
            if( fos != null )
            {
                fos.close();
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int count ) throws Throwable
    {

        File file = new File("badSink.txt");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter buffwrite = new BufferedWriter(oswrite);
        int i;

        /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
        for (i = 0; i < count; i++)
        {
            try
            {
                buffwrite.write("Hello");
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
            }
        }

        /* Close stream reading objects */
        try
        {
            if( buffwrite != null )
            {
                buffwrite.close();
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
        }

        try
        {
            if( oswrite != null )
            {
                oswrite.close();
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
        }

        try
        {
            if( fos != null )
            {
                fos.close();
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int count ) throws Throwable
    {

        /* FIX: Validate count before using it as the for loop variant to write to a file */
        if (count > 0 && count <= 20)
        {
            File file = new File("goodSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }
            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }
            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }
        }

    }
}
