/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__file_properties_12.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: file_properties
*    GoodSink: Do not modify any file properties
*    BadSink : Alter file property Last Modified
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__file_properties_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
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

    public void good() throws Throwable
    {
        good1();
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
