/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Property_19.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 23 Relative Path Traversal
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* BadSink: readFile no validation
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__Property_19 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        {

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

            String root = "C:\\uploads\\";

            if (data != null)
            {
                /* POTENTIAL FLAW: no validation of concatenated value */
                File fIn = new File(root + data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

            String root = "C:\\uploads\\";

            if (data != null)
            {
                /* POTENTIAL FLAW: no validation of concatenated value */
                File fIn = new File(root + data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        String data;
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

            String root = "C:\\uploads\\";

            if (data != null)
            {
                /* POTENTIAL FLAW: no validation of concatenated value */
                File fIn = new File(root + data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            data = System.getProperty("user.home");

            String root = "C:\\uploads\\";

            if (data != null)
            {
                /* POTENTIAL FLAW: no validation of concatenated value */
                File fIn = new File(root + data);
                FileInputStream fisSink = null;
                InputStreamReader isreadSink = null;
                BufferedReader buffreadSink = null;
                if( fIn.exists() && fIn.isFile() )
                {
                    try
                    {
                        fisSink = new FileInputStream(fIn);
                        isreadSink = new InputStreamReader(fisSink, "UTF-8");
                        buffreadSink = new BufferedReader(isreadSink);
                        IO.writeLine(buffreadSink.readLine());
                    }
                    catch ( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                    }
                    finally
                    {
                        /* Close stream reading objects */
                        try
                        {
                            if( buffreadSink != null )
                            {
                                buffreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                        }

                        try
                        {
                            if( isreadSink != null )
                            {
                                isreadSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                        }

                        try
                        {
                            if( fisSink != null )
                            {
                                fisSink.close();
                            }
                        }
                        catch( IOException ioe )
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                        }
                    }
                }
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
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
