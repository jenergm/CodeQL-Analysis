/*
 * @description Improper Resource Shutdown.  Performs some, but not all, necessary resource cleanup (DB connection is not closed properly).
 * 
 * */

package testcases.CWE404_Improper_Resource_Shutdown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.io.*;
import java.security.SecureRandom;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__db_Connection_01 extends
		AbstractTestCase 
{
    public void bad()
	{
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

        try
        {
            int num = (new SecureRandom()).nextInt(200);

            conn = IO.getDBConnection();
            statement = conn.prepareStatement("select * from users where id=?");
            statement.setInt(1, num);
            
            rs = statement.executeQuery();
            
            if (rs.first())
            {
                IO.writeString(rs.toString());
            }

			/* FLAW: DB objects are not closed properly. They should be in a finally block. */
			try
            {
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch(SQLException e)
            {
				IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }
			
			try
            {
                if( statement != null )
                {
                    statement.close();
                }
            }
            catch(SQLException e)
            {
				IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
            }
				
			try
            {
            	if (conn != null)
                {
                	conn.close();
                }
            }
            catch( SQLException e )
            {
            	IO.logger.log(Level.WARNING, "Error closing Connection", e);
            }

        }
		catch(SQLFeatureNotSupportedException sfnse)
        {
            IO.logger.log(Level.WARNING, "SQL feature not supported", sfnse);
        }
		catch(SQLException se)
        {
            IO.logger.log(Level.WARNING, "SQL Error", se);
        }
	}

	private void good1()
	{
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

        try
        {
            int num = (new SecureRandom()).nextInt(200);

            conn = IO.getDBConnection();
            statement = conn.prepareStatement("select * from users where id=?");
            statement.setInt(1, num);
            
            rs = statement.executeQuery();
            
            if (rs.first())
            {
                IO.writeString(rs.toString());
            }
        }
		catch(SQLFeatureNotSupportedException sfnse)
        {
            IO.logger.log(Level.WARNING, "SQL feature not supported", sfnse);
        }
		catch(SQLException se)
        {
            IO.logger.log(Level.WARNING, "SQL Error", se);
        }
		
		/* FIX: Close DB objects in a finally block */
        finally
        {
            try
            {
                if(rs != null )
                {
                    rs.close();
                }
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }

			try
			{
				if(statement != null )
				{
					statement.close();
				}
			}
			catch(SQLException e)
			{
				IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
			}

			try
			{
				if (conn != null)
				{
					conn.close();
				}
			}
			catch(SQLException e )
			{
				IO.logger.log(Level.WARNING, "Error closing Connection", e);
			}
        }
	}
	
	public void good() throws IOException, SQLException 
	{
        good1();
    }
	
	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		mainFromParent(args);
    }
}
