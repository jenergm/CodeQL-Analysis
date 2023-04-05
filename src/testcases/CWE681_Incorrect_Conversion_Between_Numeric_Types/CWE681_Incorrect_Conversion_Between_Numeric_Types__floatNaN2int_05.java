/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE681_Incorrect_Conversion_Between_Numeric_Types__floatNaN2int_05.java
Label Definition File: CWE681_Incorrect_Conversion_Between_Numeric_Types.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 681 Incorrect Conversion Between Numeric Types
* Sinks: floatNaN2int
*    GoodSink: check for negative sqrt
*    BadSink : sqrt to unchecked value
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE681_Incorrect_Conversion_Between_Numeric_Types;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE681_Incorrect_Conversion_Between_Numeric_Types__floatNaN2int_05 extends AbstractTestCase
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
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            boolean errored = false;
            try
            {
                /*  * Enter: -2.0, result should be 0 (for bad case)
                 *
                 * Square root of a negative number is NaN. NaN when casted to int is 0.
                 */
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                System.out.print("Enter float number (-2.0): ");
                double num = 0;
                try
                {
                    num = Float.parseFloat(bufread2.readLine());
                }
                catch(Exception e)
                {
                    IO.writeLine("Error parsing number");
                    errored = true;
                }
                /* FLAW: should not cast without checking if conversion is safe */
                IO.writeLine("" + (int)(Math.sqrt(num)));
            }
            catch( Exception e )
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

                if( errored )
                {
                    IO.logger.log(Level.WARNING, "Error parsing number");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            boolean errored = false;

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                System.out.print("Enter float number: ");
                double num = 0;
                try
                {
                    num = Float.parseFloat(bufread2.readLine());
                }
                catch(Exception e)
                {
                    IO.writeLine("Error parsing number");
                    errored = true;
                }

                /* FIX: check for sign */
                if( num < 0 )
                {
                    IO.writeLine("0");
                }
                else
                {
                    IO.writeLine("" + (int)(Math.sqrt(num)));
                }
            }
            catch( Exception e )
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

                if( errored )
                {
                    IO.logger.log(Level.WARNING, "Error parsing number");
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
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            boolean errored = false;
            try
            {
                /*  * Enter: -2.0, result should be 0 (for bad case)
                 *
                 * Square root of a negative number is NaN. NaN when casted to int is 0.
                 */
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                System.out.print("Enter float number (-2.0): ");
                double num = 0;
                try
                {
                    num = Float.parseFloat(bufread2.readLine());
                }
                catch(Exception e)
                {
                    IO.writeLine("Error parsing number");
                    errored = true;
                }
                /* FLAW: should not cast without checking if conversion is safe */
                IO.writeLine("" + (int)(Math.sqrt(num)));
            }
            catch( Exception e )
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

                if( errored )
                {
                    IO.logger.log(Level.WARNING, "Error parsing number");
                }
            }
        }
        else {

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            boolean errored = false;

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                System.out.print("Enter float number: ");
                double num = 0;
                try
                {
                    num = Float.parseFloat(bufread2.readLine());
                }
                catch(Exception e)
                {
                    IO.writeLine("Error parsing number");
                    errored = true;
                }

                /* FIX: check for sign */
                if( num < 0 )
                {
                    IO.writeLine("0");
                }
                else
                {
                    IO.writeLine("" + (int)(Math.sqrt(num)));
                }
            }
            catch( Exception e )
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

                if( errored )
                {
                    IO.logger.log(Level.WARNING, "Error parsing number");
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            boolean errored = false;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                System.out.print("Enter float number: ");
                double num = 0;
                try
                {
                    num = Float.parseFloat(bufread2.readLine());
                }
                catch(Exception e)
                {
                    IO.writeLine("Error parsing number");
                    errored = true;
                }
                /* FIX: check for sign */
                if( num < 0 )
                {
                    IO.writeLine("0");
                }
                else
                {
                    IO.writeLine("" + (int)(Math.sqrt(num)));
                }
            }
            catch( Exception e )
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

                if( errored )
                {
                    IO.logger.log(Level.WARNING, "Error parsing number");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            boolean errored = false;

            try
            {
                /*  * Enter: -2.0, result should be 0 (for bad case)
                 *
                 * Square root of a negative number is NaN. NaN when casted to int is 0.
                 */
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                System.out.print("Enter float number (-2.0): ");
                double num = 0;
                try
                {
                    num = Float.parseFloat(bufread2.readLine());
                }
                catch(Exception e)
                {
                    IO.writeLine("Error parsing number");
                    errored = true;
                }

                /* FLAW: should not cast without checking if conversion is safe */
                IO.writeLine("" + (int)(Math.sqrt(num)));
            }
            catch( Exception e )
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

                if( errored )
                {
                    IO.logger.log(Level.WARNING, "Error parsing number");
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
