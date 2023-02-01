/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE510_Trapdoor__hostname_based_logic_16.java
Label Definition File: CWE510_Trapdoor.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 510 Trapdoor
* Sinks: hostname_based_logic
*    GoodSink: No special code for a specific hostname
*    BadSink : Special code is executed upon connection of a specific hostname
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE510_Trapdoor;

import testcasesupport.*;

import java.io.*;
import java.net.*;
import java.util.logging.Level;

public class CWE510_Trapdoor__hostname_based_logic_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept(); /* INCIDENTAL: Use of Socket */
                /* FLAW: hostname-based logic */
                if( conn.getInetAddress().getHostName().equals("admin.google.com") )
                {
                    out = conn.getOutputStream();
                    out.write("Welcome, admin!".getBytes("UTF-8"));
                }
                else
                {
                    out = conn.getOutputStream();
                    out.write("Welcome, user.".getBytes("UTF-8"));
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not connect to port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept();
                out = conn.getOutputStream();
                /* FIX: No host-based logic */
                out.write(("Welcome, " + conn.getInetAddress().getHostName()).getBytes("UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not connect to port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

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
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept(); /* INCIDENTAL: Use of Socket */
                /* FLAW: hostname-based logic */
                if( conn.getInetAddress().getHostName().equals("admin.google.com") )
                {
                    out = conn.getOutputStream();
                    out.write("Welcome, admin!".getBytes("UTF-8"));
                }
                else
                {
                    out = conn.getOutputStream();
                    out.write("Welcome, user.".getBytes("UTF-8"));
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not connect to port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

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
            break;
        }

        while(true)
        {
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept();
                out = conn.getOutputStream();
                /* FIX: No host-based logic */
                out.write(("Welcome, " + conn.getInetAddress().getHostName()).getBytes("UTF-8"));
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Could not connect to port " + Integer.toString(port), e);
            }
            finally
            {
                try
                {
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing objects", e);
                }

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
            break;
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
