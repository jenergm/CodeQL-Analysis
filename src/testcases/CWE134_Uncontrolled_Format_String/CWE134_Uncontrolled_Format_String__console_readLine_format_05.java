/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__console_readLine_format_05.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: console_readLine Read data from the console using readLine()
* GoodSource: A hardcoded string
* Sinks: format
*    GoodSink: dynamic formatted stdout with string defined
*    BadSink : dynamic formatted stdout without validation
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE134_Uncontrolled_Format_String__console_readLine_format_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_t to private_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* read user input from console with readLine */
            try {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_t to private_f */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }
        }
        else {

            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            data = ""; /* Initialize data */
            /* read user input from console with readLine */
            try
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* POTENTIAL FLAW: Read data from the console using readLine() */
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            if (data != null)
            {
                /* FIX: explicitly defined string formatting */
                System.out.format("%s%n", data);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                /* POTENTIAL FLAW: uncontrolled string formatting */
                System.out.format(data);
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
