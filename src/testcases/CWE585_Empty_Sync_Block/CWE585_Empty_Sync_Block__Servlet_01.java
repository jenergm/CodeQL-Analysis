/*
 * @description Demonstrates a synchronized block that is empty (and therefore allowing unsynchronized updates to a shared variable).  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */

package testcases.CWE585_Empty_Sync_Block;

import java.util.concurrent.locks.ReentrantLock;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.IO;
import testcasesupport.AbstractTestCaseServlet;

public class CWE585_Empty_Sync_Block__Servlet_01 extends AbstractTestCaseServlet {
    private static final long serialVersionUID = 1L;
  
  /* bad(): Empty synchronized block */
  static private int badint = 1;
  
  static public void bad_double()
  {
    synchronized(CWE585_Empty_Sync_Block__Servlet_01.class) {
      /* FLAW: empty synchronized block - should cover whole method */
    }
    badint = badint * 2;
  }
    
  public void bad(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException 
  {
    bad_double();
    response.getWriter().write(badint);
  }

  
   /* good1(): Use synchronized block to cover whole method */
  static private int good1int = 1;

  static public void good1_double() 
  {
    synchronized(CWE585_Empty_Sync_Block__Servlet_01.class) { /* FIX: synchronized block covers whole method */
      good1int = good1int * 2;
    }
  }
  
  private void good1(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException
  {        
    good1_double();
    response.getWriter().write(good1int);
  }
  
  public void good(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException 
  {
    good1(request, response);
  } 
}
