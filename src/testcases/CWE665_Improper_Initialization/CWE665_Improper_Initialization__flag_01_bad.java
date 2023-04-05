/*
 * @description Reliance on incorrectly set boolean field (flag) results in incomplete initialization
 * 
 * */

package testcases.CWE665_Improper_Initialization;

import testcasesupport.AbstractTestCaseClassIssueBad;
import testcasesupport.IO;

public class CWE665_Improper_Initialization__flag_01_bad
    extends AbstractTestCaseClassIssueBad 
{

  private static class BadClass
  {
    private boolean initialized = true; /* FLAW: This should be false to avoid incomplete initialization */
    private int five = 0;
    
    public BadClass()
    {
      if (!initialized)
      {
        IO.writeLine("Initializing...");
        five = 5;
        initialized = true;
      }
    }
  }

  public void bad() 
  {
    BadClass b = new BadClass();
    IO.writeLine(b.five);
  }
  
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
