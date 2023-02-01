/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE510_Trapdoor__network_listen_08.java
Label Definition File: CWE510_Trapdoor.badonly.label.xml
Template File: point-flaw-badonly-08.tmpl.java
*/
/*
* @description
* CWE: 510 Trapdoor
* Sinks: network_listen
*    BadSink : Presence of a network listener
*	 BadOnly (No GoodSink)
* Flow Variant: 08 Control flow: if(private_returns_t())
*
* */

package testcases.CWE510_Trapdoor;

import testcasesupport.*;

import java.io.*;
import java.net.*;
import java.util.logging.Level;

public class CWE510_Trapdoor__network_listen_08 extends AbstractTestCase
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
            ServerSocket ss = null;
            Socket conn = null;
            int port = 30000;
            try
            {
                ss = new ServerSocket(port); /* INCIDENTAL: Use of Socket */
                /* wait for first connection */
                /* FLAW: Listening for network connection */
                conn = ss.accept();
                /* connection successful, so do stuff */
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not listen on port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (conn != null)
                    {
                        conn.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

                try
                {
                    if (ss != null)
                    {
                        ss.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
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
            ServerSocket ss = null;
            Socket conn = null;
            int port = 30000;
            try
            {
                ss = new ServerSocket(port); /* INCIDENTAL: Use of Socket */
                /* wait for first connection */
                /* FLAW: Listening for network connection */
                conn = ss.accept();
                /* connection successful, so do stuff */
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not listen on port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (conn != null)
                    {
                        conn.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

                try
                {
                    if (ss != null)
                    {
                        ss.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }
            }
        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            /* INCIDENTAL: Empty Block */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            ServerSocket ss = null;
            Socket conn = null;
            int port = 30000;

            try
            {
                ss = new ServerSocket(port); /* INCIDENTAL: Use of Socket */
                /* wait for first connection */
                /* FLAW: Listening for network connection */
                conn = ss.accept();
                /* connection successful, so do stuff */
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not listen on port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (conn != null)
                    {
                        conn.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

                try
                {
                    if (ss != null)
                    {
                        ss.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
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
