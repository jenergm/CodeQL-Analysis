/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE378_File_Creation_With_Insecure_Perms__basic_05.java
Label Definition File: CWE378_File_Creation_With_Insecure_Perms__basic.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 378 Explicitly set permissions on files
* Sinks:
*    GoodSink: Restrict permissions on file
*    BadSink : Permissions never set on file
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE378_File_Creation_With_Insecure_Perms;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE378_File_Creation_With_Insecure_Perms__basic_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        if (private_t)
        {
            FileOutputStream fos = null;
            OutputStreamWriter oswrite = null;
            BufferedWriter buffwrite = null;
            try
            {
                File temp = File.createTempFile("temp", "1234");
                /* FLAW: Permissions never set on file */
                /* Write something to the file */
                fos = new FileOutputStream(temp);
                oswrite = new OutputStreamWriter(fos, "UTF-8");
                buffwrite = new BufferedWriter(oswrite);
                buffwrite.write(42);
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", ioe);
            }
            finally
            {
                try {
                    if (buffwrite != null)
                    {
                        buffwrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if (oswrite != null)
                    {
                        oswrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                try {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            FileOutputStream fos = null;
            OutputStreamWriter oswrite = null;
            BufferedWriter buffwrite = null;

            try
            {
                File temp = File.createTempFile("temp", "1234");

                /* FIX: Set file as writable by owner, readable by owner, not executable (if file system supports it) */
                if (!temp.setWritable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Writable permissions");
                }
                if (!temp.setReadable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Readable permissions");
                }
                if (!temp.setExecutable(false))
                {
                    IO.logger.log(Level.WARNING, "Could not set Executable permissions");
                }

                /* Write something to the file */
                fos = new FileOutputStream(temp);
                oswrite = new OutputStreamWriter(fos, "UTF-8");
                buffwrite = new BufferedWriter(oswrite);
                buffwrite.write(42);
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", ioe);
            }
            finally
            {
                try {
                    if (buffwrite != null)
                    {
                        buffwrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if (oswrite != null)
                    {
                        oswrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                try {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }

        }
    }

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            FileOutputStream fos = null;
            OutputStreamWriter oswrite = null;
            BufferedWriter buffwrite = null;
            try
            {
                File temp = File.createTempFile("temp", "1234");
                /* FLAW: Permissions never set on file */
                /* Write something to the file */
                fos = new FileOutputStream(temp);
                oswrite = new OutputStreamWriter(fos, "UTF-8");
                buffwrite = new BufferedWriter(oswrite);
                buffwrite.write(42);
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", ioe);
            }
            finally
            {
                try {
                    if (buffwrite != null)
                    {
                        buffwrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if (oswrite != null)
                    {
                        oswrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                try {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
        }
        else {

            FileOutputStream fos = null;
            OutputStreamWriter oswrite = null;
            BufferedWriter buffwrite = null;

            try
            {
                File temp = File.createTempFile("temp", "1234");

                /* FIX: Set file as writable by owner, readable by owner, not executable (if file system supports it) */
                if (!temp.setWritable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Writable permissions");
                }
                if (!temp.setReadable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Readable permissions");
                }
                if (!temp.setExecutable(false))
                {
                    IO.logger.log(Level.WARNING, "Could not set Executable permissions");
                }

                /* Write something to the file */
                fos = new FileOutputStream(temp);
                oswrite = new OutputStreamWriter(fos, "UTF-8");
                buffwrite = new BufferedWriter(oswrite);
                buffwrite.write(42);
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", ioe);
            }
            finally
            {
                try {
                    if (buffwrite != null)
                    {
                        buffwrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if (oswrite != null)
                    {
                        oswrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                try {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            FileOutputStream fos = null;
            OutputStreamWriter oswrite = null;
            BufferedWriter buffwrite = null;
            try
            {
                File temp = File.createTempFile("temp", "1234");
                /* FIX: Set file as writable by owner, readable by owner, not executable (if file system supports it) */
                if (!temp.setWritable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Writable permissions");
                }
                if (!temp.setReadable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Readable permissions");
                }
                if (!temp.setExecutable(false))
                {
                    IO.logger.log(Level.WARNING, "Could not set Executable permissions");
                }
                /* Write something to the file */
                fos = new FileOutputStream(temp);
                oswrite = new OutputStreamWriter(fos, "UTF-8");
                buffwrite = new BufferedWriter(oswrite);
                buffwrite.write(42);
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", ioe);
            }
            finally
            {
                try {
                    if (buffwrite != null)
                    {
                        buffwrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if (oswrite != null)
                    {
                        oswrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                try {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            FileOutputStream fos = null;
            OutputStreamWriter oswrite = null;
            BufferedWriter buffwrite = null;

            try
            {
                File temp = File.createTempFile("temp", "1234");

                /* FLAW: Permissions never set on file */

                /* Write something to the file */
                fos = new FileOutputStream(temp);
                oswrite = new OutputStreamWriter(fos, "UTF-8");
                buffwrite = new BufferedWriter(oswrite);
                buffwrite.write(42);
            }
            catch (IOException ioe)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", ioe);
            }
            finally
            {
                try {
                    if (buffwrite != null)
                    {
                        buffwrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if (oswrite != null)
                    {
                        oswrite.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                try {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
