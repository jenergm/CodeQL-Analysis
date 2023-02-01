/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_15.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 319 Cleartext Transmission of Sensitive Information
* BadSource: listen_tcp Read password using a listening tcp connection
* GoodSource: Set password to a hardcoded value (one that was not sent over the network)
* Sinks: driverManager
*    GoodSink: Decrypt the password from the source before using it in database connection
*    BadSink : Use password directly from source in database connection
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String password;
        switch(6)
        {
        case 6:
        {
            password = ""; /* init password */
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
                    /* POTENTIAL FLAW: Read password using a listening tcp connection */
                    password = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                conn2 = DriverManager.getConnection("data-url", "root", password);
                st = conn2.prepareStatement("select * from test_table");
                rs2 = st.executeQuery();
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", e);
            }
            finally
            {
                try
                {
                    if( rs2 != null )
                    {
                        rs2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                }

                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                }

                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", e);
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (password != null)
            {
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                Connection conn2 = null;
                PreparedStatement st = null;
                ResultSet rs2 = null;
                try
                {
                    /* POTENTIAL FLAW: use password directly in getConnection() */
                    conn2 = DriverManager.getConnection("data-url", "root", password);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
                    }
                }
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String password;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            password = ""; /* init password */
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
                    /* POTENTIAL FLAW: Read password using a listening tcp connection */
                    password = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
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
        break;
        default:
        {
            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                conn2 = DriverManager.getConnection("data-url", "root", password);
                st = conn2.prepareStatement("select * from test_table");
                rs2 = st.executeQuery();
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", e);
            }
            finally
            {
                try
                {
                    if( rs2 != null )
                    {
                        rs2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                }

                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                }

                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", e);
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (password != null)
            {
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                Connection conn2 = null;
                PreparedStatement st = null;
                ResultSet rs2 = null;
                try
                {
                    /* POTENTIAL FLAW: use password directly in getConnection() */
                    conn2 = DriverManager.getConnection("data-url", "root", password);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
                    }
                }
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String password;
        switch(6)
        {
        case 6:
        {
            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            password = ""; /* init password */
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
                    /* POTENTIAL FLAW: Read password using a listening tcp connection */
                    password = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
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
        break;
        }

        switch(7)
        {
        case 7:
        {
            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                conn2 = DriverManager.getConnection("data-url", "root", password);
                st = conn2.prepareStatement("select * from test_table");
                rs2 = st.executeQuery();
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", e);
            }
            finally
            {
                try
                {
                    if( rs2 != null )
                    {
                        rs2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                }

                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                }

                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", e);
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (password != null)
            {
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                Connection conn2 = null;
                PreparedStatement st = null;
                ResultSet rs2 = null;
                try
                {
                    /* POTENTIAL FLAW: use password directly in getConnection() */
                    conn2 = DriverManager.getConnection("data-url", "root", password);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
                    }
                }
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String password;
        switch(6)
        {
        case 6:
        {
            password = ""; /* init password */
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
                    /* POTENTIAL FLAW: Read password using a listening tcp connection */
                    password = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                conn2 = DriverManager.getConnection("data-url", "root", password);
                st = conn2.prepareStatement("select * from test_table");
                rs2 = st.executeQuery();
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", e);
            }
            finally
            {
                try
                {
                    if( rs2 != null )
                    {
                        rs2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                }

                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                }

                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", e);
                }
            }
        }
        break;
        default:
        {
            if (password != null)
            {
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                Connection conn2 = null;
                PreparedStatement st = null;
                ResultSet rs2 = null;
                try
                {
                    /* POTENTIAL FLAW: use password directly in getConnection() */
                    conn2 = DriverManager.getConnection("data-url", "root", password);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
                    }
                }
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String password;
        switch(6)
        {
        case 6:
        {
            password = ""; /* init password */
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
                    /* POTENTIAL FLAW: Read password using a listening tcp connection */
                    password = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* FIX: Use a hardcoded password as the password (it was not sent over the network) */
            /* INCIDENTAL FLAW: CWE-259 Hard Coded Password */
            password = "Password1234!";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            if (password != null)
            {
                /* FIX: Decrypt password before using in KerberosKey() */
                {
                    Cipher aes = Cipher.getInstance("AES");
                    KeyGenerator kg = KeyGenerator.getInstance("AES");
                    kg.init(128);
                    /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                    SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                    aes.init(Cipher.DECRYPT_MODE, keySpec);
                    password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
                }
                Connection conn2 = null;
                PreparedStatement st = null;
                ResultSet rs2 = null;
                try
                {
                    /* POTENTIAL FLAW: use password directly in getConnection() */
                    conn2 = DriverManager.getConnection("data-url", "root", password);
                    st = conn2.prepareStatement("select * from test_table");
                    rs2 = st.executeQuery();
                }
                catch(SQLException e)
                {
                    IO.logger.log(Level.WARNING, "Error with database connection", e);
                }
                finally
                {
                    try
                    {
                        if( rs2 != null )
                        {
                            rs2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                    }

                    try
                    {
                        if( st != null )
                        {
                            st.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                    }

                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", e);
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                conn2 = DriverManager.getConnection("data-url", "root", password);
                st = conn2.prepareStatement("select * from test_table");
                rs2 = st.executeQuery();
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", e);
            }
            finally
            {
                try
                {
                    if( rs2 != null )
                    {
                        rs2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                }

                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                }

                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", e);
                }
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
