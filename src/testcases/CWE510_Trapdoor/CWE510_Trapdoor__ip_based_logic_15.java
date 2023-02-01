/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE510_Trapdoor__ip_based_logic_15.java
Label Definition File: CWE510_Trapdoor.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 510 Trapdoor
* Sinks: ip_based_logic
*    GoodSink: No special code for a specific IP address
*    BadSink : Special code is executed upon connection of a specific IP address
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE510_Trapdoor;

import testcasesupport.*;

import java.io.*;
import java.net.*;
import java.util.logging.Level;

public class CWE510_Trapdoor__ip_based_logic_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept(); /* INCIDENTAL: Use of Socket */
                /* FLAW: IP-based logic */
                if( conn.getInetAddress().getHostAddress().equals("192.168.30.123") )
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
                out.write(("Welcome, " + conn.getInetAddress().getHostAddress()).getBytes("UTF-8"));
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
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept(); /* INCIDENTAL: Use of Socket */
                /* FLAW: IP-based logic */
                if( conn.getInetAddress().getHostAddress().equals("192.168.30.123") )
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
        }
        break;
        default:
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
                out.write(("Welcome, " + conn.getInetAddress().getHostAddress()).getBytes("UTF-8"));
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
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch(7)
        {
        case 7:
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
                out.write(("Welcome, " + conn.getInetAddress().getHostAddress()).getBytes("UTF-8"));
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            ServerSocket ss = null;
            Socket conn = null;
            OutputStream out = null;
            int port = 20000;
            try
            {
                ss = new ServerSocket(port);
                conn = ss.accept(); /* INCIDENTAL: Use of Socket */
                /* FLAW: IP-based logic */
                if( conn.getInetAddress().getHostAddress().equals("192.168.30.123") )
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
        }
        break;
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
