/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__Property_74b.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-74b.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE78_OS_Command_Injection__Property_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

}
