/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_14.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE390_Error_Without_Action__reader_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_five==5)
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

    /* good1() changes IO.static_five==5 to IO.static_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_five!=5)
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
        if(IO.static_five==5)
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
