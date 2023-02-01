/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_17.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE390_Error_Without_Action__reader_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
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

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
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

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
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

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
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
