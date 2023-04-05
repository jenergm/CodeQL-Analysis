/*
 * @description Demonstrates a synchronized block that is empty (and therefore allowing unsynchronized updates to a shared variable). 
 * 
 * */

package testcases.CWE585_Empty_Sync_Block;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE585_Empty_Sync_Block__Thread_01 extends AbstractTestCase 
{
  /* bad(): Empty synchronized block */
  static private int badint = 1;
  
  static public void bad_double()
  {
  	synchronized(CWE585_Empty_Sync_Block__Thread_01.class) {
    	/* FLAW: empty synchronized block - should cover whole method */
    }
    badint = badint * 2;
  }

	public void bad() throws InterruptedException 
	{
    /* Create threads */
    Thread ta = new Thread(new Runnable() {
        public void run() { CWE585_Empty_Sync_Block__Thread_01.bad_double(); }
    });
    Thread tb = new Thread(new Runnable() {
        public void run() { CWE585_Empty_Sync_Block__Thread_01.bad_double(); }
    });
    
    /* Start threads */
    ta.start();
    tb.start();
    
    /* Wait for threads to finish */
    ta.join();
    tb.join();

    /* Write output */
    IO.writeLine(badint);  
	}


  /* good1(): Use synchronized block to cover whole method */
  static private int good1int = 1;

  static public void good1_double() 
  {
    synchronized(CWE585_Empty_Sync_Block__Thread_01.class) { /* FIX: synchronized block covers whole method */
      good1int = good1int * 2;
    }
  }
  
  private void good1() throws InterruptedException
  {   
    /* Create threads */
    Thread ta = new Thread(new Runnable() {
        public void run() { CWE585_Empty_Sync_Block__Thread_01.good1_double(); }
    });
    Thread tb = new Thread(new Runnable() {
        public void run() { CWE585_Empty_Sync_Block__Thread_01.good1_double(); }
    });
    
    /* Start threads */
    ta.start();
    tb.start();
    
    /* Wait for threads to finish */
    ta.join();
    tb.join();

    /* Write output */
    IO.writeLine(good1int);
  }
  
	public void good() throws InterruptedException
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
