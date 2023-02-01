/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_driverManager_74b.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: URLConnection Read password from a web server with URLConnection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;
import java.util.HashMap;

import java.io.*;
import java.sql.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE319_Cleartext_Tx_Sensitive_Info__URLConnection_driverManager_74b
{

    public void bad_sink(HashMap<Integer,String> password_hashmap ) throws Throwable
    {
        String password = password_hashmap.get(2);

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

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(HashMap<Integer,String> password_hashmap ) throws Throwable
    {
        String password = password_hashmap.get(2);

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

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(HashMap<Integer,String> password_hashmap ) throws Throwable
    {
        String password = password_hashmap.get(2);

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
}
