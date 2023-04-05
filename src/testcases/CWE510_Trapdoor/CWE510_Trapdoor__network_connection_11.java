/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE510_Trapdoor__network_connection_11.java
Label Definition File: CWE510_Trapdoor.badonly.label.xml
Template File: point-flaw-badonly-11.tmpl.java
*/
/*
* @description
* CWE: 510 Trapdoor
* Sinks: network_connection
*    BadSink : Presence of a network connection
*	 BadOnly (No GoodSink)
* Flow Variant: 11 Control flow: if(IO.static_returns_t())
*
* */

package testcases.CWE510_Trapdoor;

import testcasesupport.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.logging.Level;

public class CWE510_Trapdoor__network_connection_11 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t())
        {
            InputStream instream = null;
            try
            {
                /* FLAW: direct usage of URI */
                URL u = new URL("http://123.123.123.123:80");
                instream = u.openStream();
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "caught IOException", e);
            }
            finally
            {
                try
                {
                    if (instream != null)
                    {
                        instream.close();
                    }
                }
                catch (IOException e)
                {
                    IO.logger.log(Level.WARNING, "caught IOException", e);
                }
            }
        }
    }

    /* good1() changes IO.static_returns_t() to IO.static_returns_f() */
    private void good1() throws Throwable
    {
        if(IO.static_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            InputStream instream = null;
            try
            {
                /* FLAW: direct usage of URI */
                URL u = new URL("http://123.123.123.123:80");
                instream = u.openStream();
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "caught IOException", e);
            }
            finally
            {
                try
                {
                    if (instream != null)
                    {
                        instream.close();
                    }
                }
                catch (IOException e)
                {
                    IO.logger.log(Level.WARNING, "caught IOException", e);
                }
            }
        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_returns_t())
        {
            /* INCIDENTAL: Empty Block */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            InputStream instream = null;
            try
            {
                /* FLAW: direct usage of URI */
                URL u = new URL("http://123.123.123.123:80");
                instream = u.openStream();
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "caught IOException", e);
            }
            finally
            {
                try
                {
                    if (instream != null)
                    {
                        instream.close();
                    }
                }
                catch (IOException e)
                {
                    IO.logger.log(Level.WARNING, "caught IOException", e);
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
