/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__max_value_write_10.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-10.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: write
*    GoodSink: Write to a file count number of times, but first validate count
*    BadSink : Write to a file count number of times
* Flow Variant: 10 Control flow: if(IO.static_t) and if(IO.static_f)
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

public class CWE400_Resource_Exhaustion__max_value_write_10 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
            count = Integer.MAX_VALUE;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_t to IO.static_f */
    private void goodG2B1() throws Throwable
    {
        int count;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
            count = Integer.MAX_VALUE;
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int count;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
            count = Integer.MAX_VALUE;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_t to IO.static_f */
    private void goodB2G1() throws Throwable
    {
        int count;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
            count = Integer.MAX_VALUE;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        else {

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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int count;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
            count = Integer.MAX_VALUE;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
