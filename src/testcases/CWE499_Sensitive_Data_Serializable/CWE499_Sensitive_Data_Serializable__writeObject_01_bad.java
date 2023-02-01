/*
 * @description An object contains sensitive data but does not explicitly
 * prohibit serialization, allowing it to be serialized through another class
 *  
 * This class contains the "bad" version, which does not prohibit serialization.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import testcasesupport.*;

/* We would never expect to see a real class like this, but our implementation tries to ensure the fact
 * that one of the fields is sensitive */
public class CWE499_Sensitive_Data_Serializable__writeObject_01_bad extends AbstractTestCaseClassIssueBad
{
    /* Sensitive field */
	private String pw_hash;
	
	protected void setPassword(String pw)
	{
		pw_hash = pw;
	}
	
	protected String getPassword()
	{
		return pw_hash;
	}

    protected void withdraw(float amount) throws SQLException 
    {
		if (pw_hash != null)
		{
			Connection conn = DriverManager.getConnection("192.168.39.10", "sa", pw_hash);
		
			/* etc */
		
			/* close connection */
			if (conn != null)
			{
				try
				{	
					conn.close();
				} 
				catch( Exception e )
				{
					IO.logger.log(Level.WARNING, "Error closing Connection", e);
				}
			}
		} 
		else 
		{
			IO.logger.log(Level.WARNING, "Invalid password.");
		}
    }
	
    /* FLAW: Because writeObject() is not implemented, this class can be serialized in unexpected ways */
  
    public void bad() { }

	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		mainFromParent(args);
	}

}
