/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE547_Hardcoded_Security_Constants__basic_12.java
Label Definition File: CWE547_Hardcoded_Security_Constants__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 547 Use of Hardcoded Security Relevant Constants
* Sinks:
*    GoodSink: using a constant
*    BadSink : not using a constant
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE547_Hardcoded_Security_Constants;

import testcasesupport.*;

import java.io.*;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE547_Hardcoded_Security_Constants__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* NOTE: Intentionally not using IO class for this example */
                char[] buffer = new char[10];
                int read_chars = bufread2.read(buffer, 0, 10); /* FLAW: hardcoded value for number of characters to read from input stream into buffer */
                if (read_chars < 0)
                {
                    IO.writeLine("An error occurred");
                }
                IO.writeLine(String.valueOf(buffer, 0, read_chars));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
            }
        }
        else {

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            final int NUMCHARS = 10;

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* NOTE: Intentionally not using IO class for this example */
                char[] buffer = new char[NUMCHARS];
                int read_chars = bufread2.read(buffer, 0, NUMCHARS); /* FIX: constant used */

                if (read_chars < 0)
                {
                    IO.writeLine("An error occurred");
                }

                IO.writeLine(String.valueOf(buffer, 0, read_chars));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
            }

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            final int NUMCHARS = 10;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* NOTE: Intentionally not using IO class for this example */
                char[] buffer = new char[NUMCHARS];
                int read_chars = bufread2.read(buffer, 0, NUMCHARS); /* FIX: constant used */
                if (read_chars < 0)
                {
                    IO.writeLine("An error occurred");
                }
                IO.writeLine(String.valueOf(buffer, 0, read_chars));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
                }
            }
        }
        else {

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            final int NUMCHARS = 10;

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* NOTE: Intentionally not using IO class for this example */
                char[] buffer = new char[NUMCHARS];
                int read_chars = bufread2.read(buffer, 0, NUMCHARS); /* FIX: constant used */

                if (read_chars < 0)
                {
                    IO.writeLine("An error occurred");
                }

                IO.writeLine(String.valueOf(buffer, 0, read_chars));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error!", e);
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                    }
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
