/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__listen_tcp_15.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 760 Use of one-way hash with a predictable salt
* BadSource: listen_tcp Read data using a listening tcp connection
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: use a sufficiently random salt
*    BadSink : SHA512 with a predictable salt
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE760_Predictable_Salt_One_Way_Hash__listen_tcp_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            SecureRandom r = new SecureRandom();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        break;
        default:
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            SecureRandom r = new SecureRandom();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            SecureRandom r = new SecureRandom();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        break;
        default:
        {
            SecureRandom r = new SecureRandom();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
                    try {
                        if( sock != null )
                        {
                            sock.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", e);
                    }

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            SecureRandom r = new SecureRandom();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        break;
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
