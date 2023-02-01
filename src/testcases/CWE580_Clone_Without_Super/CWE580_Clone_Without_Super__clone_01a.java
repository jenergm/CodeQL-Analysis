/*
 * @description A class defines clone() but does not call super.clone().
 * 
 * */

package testcases.CWE580_Clone_Without_Super;

import testcasesupport.*;

public class CWE580_Clone_Without_Super__clone_01a extends AbstractTestCaseClassIssue implements Cloneable
{
    { // initialize bo (bad object) and g1o (good1 object)
		bo = new CWE580_Clone_Without_Super__clone_01_bad();
		g1o = new CWE580_Clone_Without_Super__clone_01_good1();
	} // end initialization block
	
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
