/*
 * @description Improper Resource Shutdown.  Performs some, but not all, necessary resource cleanup (FileReader is not closed properly).
 * 
 * */

package testcases.CWE404_Improper_Resource_Shutdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__FileReader_01
		extends AbstractTestCase 
{	
    private String FILE_NAME = "C:\\file.txt";
    public void bad() 
	{
		BufferedReader buffread = null;
		FileReader fread = null;
		try
		{
			File f = new File(FILE_NAME);
			fread = new FileReader(f);
			buffread = new BufferedReader(fread);
	        String readString = buffread.readLine();
	        
	        IO.writeLine(readString);

			/* FLAW: Attempts to close the streams should be in a finally block. */
			try
            {
                if (buffread != null)
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
            }
			
			try 
			{
				if( fread != null )
				{
					fread.close();
				}
			}
			catch( IOException ioe )
			{
				IO.logger.log(Level.WARNING, "Error closing FileReader", ioe);
			}		
		}
		catch(IOException e)
		{
           	IO.logger.log(Level.WARNING, "Error with stream reading", e);
		}
	}
	
	private void good1() 
	{		
		BufferedReader buffread = null;
		FileReader fread = null;
		try
		{
			File f = new File("c:\\file.txt");
			fread = new FileReader(f);
			buffread = new BufferedReader(fread);
	        String readString = buffread.readLine();
	        
	        IO.writeLine(readString);
		}
		catch(IOException e)
		{
            IO.logger.log(Level.WARNING, "Error with stream reading", e);
		}
		/* FIX: Streams closed appropriately */
		finally
		{
            try
            {
                if (buffread != null)
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
            }
			
			try 
			{
				if( fread != null ) 
				{
					fread.close();
				}
			}
			catch( IOException ioe ) 
			{
				IO.logger.log(Level.WARNING, "Error closing FileReader", ioe);
			}
		}
	}
	
	public void good()  
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
