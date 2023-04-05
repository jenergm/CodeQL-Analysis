/*
 * @description Reliance on incorrectly set boolean field (flag) results in incomplete initialization
 * 
 * */

package testcases.CWE665_Improper_Initialization;

import testcasesupport.AbstractTestCaseClassIssueGood;
import testcasesupport.IO;

public class CWE665_Improper_Initialization__flag_01_good1
    extends AbstractTestCaseClassIssueGood 
{

  public static class Good1Class
  {
    private boolean initialized = false; /* FIX: correctly marked false */
    private int five = 0;

    public Good1Class()
    {
      if (!initialized)
      {
        IO.writeLine("Initializing...");
        five = 5;
        initialized = true;
      }
    }
    
  }

  private void good1() 
  {
    Good1Class c = new Good1Class();
    IO.writeLine(c.five);
  }
  
  public void good() 
  {
    good1();
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
