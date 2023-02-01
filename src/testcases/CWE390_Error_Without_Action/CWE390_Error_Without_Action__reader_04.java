/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_04.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE390_Error_Without_Action__reader_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
        {
            File f = new File("C:\\doesntexistandneverwill.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader reader = null;
            try
            {
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                reader = new BufferedReader(isread);
            }
            catch( FileNotFoundException fe )
            {
                /* FLAW: do nothing if the file doesn't exist */
            }
            finally
            {
                /* Close stream reading objects */
                try {
                    if( reader != null )
                    {
                        reader.close();
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            File f = new File("C:\\doesntexistandneverwill.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader reader = null;

            try
            {
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                reader = new BufferedReader(isread);
            }
            catch( FileNotFoundException fe )
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + fe.getMessage());
                throw fe;
            }
            finally
            {
                /* Close stream reading objects */
                try {
                    if( reader != null )
                    {
                        reader.close();
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

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            File f = new File("C:\\doesntexistandneverwill.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader reader = null;
            try
            {
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                reader = new BufferedReader(isread);
            }
            catch( FileNotFoundException fe )
            {
                /* FLAW: do nothing if the file doesn't exist */
            }
            finally
            {
                /* Close stream reading objects */
                try {
                    if( reader != null )
                    {
                        reader.close();
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
        else {

            File f = new File("C:\\doesntexistandneverwill.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader reader = null;

            try
            {
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                reader = new BufferedReader(isread);
            }
            catch( FileNotFoundException fe )
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + fe.getMessage());
                throw fe;
            }
            finally
            {
                /* Close stream reading objects */
                try {
                    if( reader != null )
                    {
                        reader.close();
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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
        {
            File f = new File("C:\\doesntexistandneverwill.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader reader = null;
            try
            {
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                reader = new BufferedReader(isread);
            }
            catch( FileNotFoundException fe )
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + fe.getMessage());
                throw fe;
            }
            finally
            {
                /* Close stream reading objects */
                try {
                    if( reader != null )
                    {
                        reader.close();
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            File f = new File("C:\\doesntexistandneverwill.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader reader = null;

            try
            {
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                reader = new BufferedReader(isread);
            }
            catch( FileNotFoundException fe )
            {
                /* FLAW: do nothing if the file doesn't exist */
            }
            finally
            {
                /* Close stream reading objects */
                try {
                    if( reader != null )
                    {
                        reader.close();
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
