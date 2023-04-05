/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__file_transfer_listen_tcp_14.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-14.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: file_transfer_listen_tcp
*    BadSink : Send file contents over the network using a listening tcp connection
*	 BadOnly (No GoodSink)
* Flow Variant: 14 Control flow: if(IO.static_five==5)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.io.File;
import java.io.FileInputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE506_Embedded_Malicious_Code__file_transfer_listen_tcp_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_five==5)
        {
            String contents = "";
            File f = new File("C:\\data.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader buffread = null;
            try
            {
                /* read string from file */
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                buffread = new BufferedReader(isread);
                contents = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
                /* clean up stream reading objects */
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
                    if( isread != null )
                    {
                        isread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                try {
                    if( fis != null )
                    {
                        fis.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }

            }
            ServerSocket listener = null;
            Socket sock = null;
            OutputStreamWriter outstrwrite = null;
            BufferedWriter buffwrite = null;
            try
            {
                /* send file contents using socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();
                outstrwrite = new OutputStreamWriter(sock.getOutputStream(), "UTF-8");
                buffwrite = new BufferedWriter(outstrwrite);
                /* FLAW: Send file contents over the network */
                if (contents != null)
                {
                    buffwrite.write(contents);
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
            }
            finally
            {
                /* clean up stream writing objects */
                try {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if( outstrwrite != null )
                    {
                        outstrwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                /* clean up socket objects */
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

    /* good1() changes IO.static_five==5 to IO.static_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String contents = "";
            File f = new File("C:\\data.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader buffread = null;
            try
            {
                /* read string from file */
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                buffread = new BufferedReader(isread);
                contents = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally
            {
                /* clean up stream reading objects */
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
                    if( isread != null )
                    {
                        isread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                try {
                    if( fis != null )
                    {
                        fis.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }

            }
            ServerSocket listener = null;
            Socket sock = null;
            OutputStreamWriter outstrwrite = null;
            BufferedWriter buffwrite = null;
            try
            {
                /* send file contents using socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();
                outstrwrite = new OutputStreamWriter(sock.getOutputStream(), "UTF-8");
                buffwrite = new BufferedWriter(outstrwrite);
                /* FLAW: Send file contents over the network */
                if (contents != null)
                {
                    buffwrite.write(contents);
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
            }
            finally
            {
                /* clean up stream writing objects */
                try {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if( outstrwrite != null )
                    {
                        outstrwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                /* clean up socket objects */
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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_five==5)
        {
            /* INCIDENTAL: Empty Block */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String contents = "";
            File f = new File("C:\\data.txt");
            FileInputStream fis = null;
            InputStreamReader isread = null;
            BufferedReader buffread = null;

            try {
                /* read string from file */
                fis = new FileInputStream(f);
                isread = new InputStreamReader(fis, "UTF-8");
                buffread = new BufferedReader(isread);

                contents = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
            }
            finally {
                /* clean up stream reading objects */
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
                    if( isread != null )
                    {
                        isread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }

                try {
                    if( fis != null )
                    {
                        fis.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                }

            }

            ServerSocket listener = null;
            Socket sock = null;
            OutputStreamWriter outstrwrite = null;
            BufferedWriter buffwrite = null;

            try {
                /* send file contents using socket */
                listener = new ServerSocket(39543);
                sock = listener.accept();

                outstrwrite = new OutputStreamWriter(sock.getOutputStream(), "UTF-8");
                buffwrite = new BufferedWriter(outstrwrite);

                /* FLAW: Send file contents over the network */
                if (contents != null)
                {
                    buffwrite.write(contents);
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
            }
            finally {
                /* clean up stream writing objects */
                try {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }

                try {
                    if( outstrwrite != null )
                    {
                        outstrwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }

                /* clean up socket objects */
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
