/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE597_Wrong_Operator_String_Comparison__basic_08.java
Label Definition File: CWE597_Wrong_Operator_String_Comparison__basic.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 597 Use of '==' instead of 'equals()' to test String equivalence
* Sinks:
*    GoodSink: Correctly use .equals() to compare strings
*    BadSink : Use == operator instead of .equals() to compare strings
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE597_Wrong_Operator_String_Comparison;

import testcasesupport.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE597_Wrong_Operator_String_Comparison__basic_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison results */
                    if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                    {
                        System.out.println("bad(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("bad(): Strings are not equal"); /* This will always display */
                    }
                }
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);

                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();

                if (str1 != null && str2 != null)
                {
                    /* output comparison */
                    if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                    {
                        System.out.println("good(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("good(): Strings are not equal");
                    }
                }
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

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison results */
                    if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                    {
                        System.out.println("bad(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("bad(): Strings are not equal"); /* This will always display */
                    }
                }
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

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);

                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();

                if (str1 != null && str2 != null)
                {
                    /* output comparison */
                    if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                    {
                        System.out.println("good(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("good(): Strings are not equal");
                    }
                }
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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                if (str1 != null && str2 != null)
                {
                    /* output comparison */
                    if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                    {
                        System.out.println("good(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("good(): Strings are not equal");
                    }
                }
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            try
            {
                inread2 = new InputStreamReader(System.in, "UTF-8");
                bufread2 = new BufferedReader(inread2);

                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();

                if (str1 != null && str2 != null)
                {
                    /* output comparison results */
                    if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                    {
                        System.out.println("bad(): Strings are equal");
                    }
                    else
                    {
                        System.out.println("bad(): Strings are not equal"); /* This will always display */
                    }
                }
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
