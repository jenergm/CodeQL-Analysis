/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Property_74a.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-74a.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;
import java.util.HashMap;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__Property_74a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        HashMap<Integer,String> data_hashmap = new HashMap<Integer,String>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE23_Relative_Path_Traversal__Property_74b()).bad_sink(data_hashmap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        HashMap<Integer,String> data_hashmap = new HashMap<Integer,String>();
        data_hashmap.put(0, data);
        data_hashmap.put(1, data);
        data_hashmap.put(2, data);
        (new CWE23_Relative_Path_Traversal__Property_74b()).goodG2B_sink(data_hashmap  );
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
