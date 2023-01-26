/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__listen_tcp_54c.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-54c.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE36_Absolute_Path_Traversal__listen_tcp_54c
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE36_Absolute_Path_Traversal__listen_tcp_54d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE36_Absolute_Path_Traversal__listen_tcp_54d()).goodG2B_sink(data );
    }

}
