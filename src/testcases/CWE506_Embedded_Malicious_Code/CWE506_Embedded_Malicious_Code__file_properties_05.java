/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__file_properties_05.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: file_properties
*    GoodSink: Do not modify any file properties
*    BadSink : Alter file property Last Modified
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__file_properties_05 extends AbstractTestCase
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
            try
            {
                String path = "C:\\test_bad.txt";
                File file = new File(path);
                long lastMod = file.lastModified();
                fos = new FileOutputStream(file);
                fos.write("This is a new line".getBytes("UTF-8"));
                /* INCIDENTAL: CWE 252 - Unchecked Return Value - some tools report
                 * an unchecked return value from setLastModified, but this is intentional as
                 * this method call is supposed to be "hidden" in the code */
                /* FLAW: altering file properties */
                file.setLastModified(lastMod - 10000L);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "File I/O error", e);
            }
            finally
            {
                try {
                    if (fos != null)
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

            FileOutputStream fos = null;

            try
            {
                String path = "C:\\test_good.txt";
                File file = new File(path);
                fos = new FileOutputStream(file);
                fos.write("This is a new line".getBytes("UTF-8"));
                /* FIX: Not altering file properties */
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "File I/O error", e);
            }
            finally
            {
                try {
                    if (fos != null)
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

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            FileOutputStream fos = null;
            try
            {
                String path = "C:\\test_bad.txt";
                File file = new File(path);
                long lastMod = file.lastModified();
                fos = new FileOutputStream(file);
                fos.write("This is a new line".getBytes("UTF-8"));
                /* INCIDENTAL: CWE 252 - Unchecked Return Value - some tools report
                 * an unchecked return value from setLastModified, but this is intentional as
                 * this method call is supposed to be "hidden" in the code */
                /* FLAW: altering file properties */
                file.setLastModified(lastMod - 10000L);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "File I/O error", e);
            }
            finally
            {
                try {
                    if (fos != null)
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

            FileOutputStream fos = null;

            try
            {
                String path = "C:\\test_good.txt";
                File file = new File(path);
                fos = new FileOutputStream(file);
                fos.write("This is a new line".getBytes("UTF-8"));
                /* FIX: Not altering file properties */
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "File I/O error", e);
            }
            finally
            {
                try {
                    if (fos != null)
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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            FileOutputStream fos = null;
            try
            {
                String path = "C:\\test_good.txt";
                File file = new File(path);
                fos = new FileOutputStream(file);
                fos.write("This is a new line".getBytes("UTF-8"));
                /* FIX: Not altering file properties */
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "File I/O error", e);
            }
            finally
            {
                try {
                    if (fos != null)
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

            FileOutputStream fos = null;

            try
            {
                String path = "C:\\test_bad.txt";
                File file = new File(path);
                long lastMod = file.lastModified();
                fos = new FileOutputStream(file);
                fos.write("This is a new line".getBytes("UTF-8"));

                /* INCIDENTAL: CWE 252 - Unchecked Return Value - some tools report
                 * an unchecked return value from setLastModified, but this is intentional as
                 * this method call is supposed to be "hidden" in the code */
                /* FLAW: altering file properties */
                file.setLastModified(lastMod - 10000L);
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "File I/O error", e);
            }
            finally
            {
                try {
                    if (fos != null)
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
