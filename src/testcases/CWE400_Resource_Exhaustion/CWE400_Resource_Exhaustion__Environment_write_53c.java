/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Environment_write_53c.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Environment Read count from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__Environment_write_53c
{

    public void bad_sink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__Environment_write_53d()).bad_sink(count );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__Environment_write_53d()).goodG2B_sink(count );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int count ) throws Throwable
    {
        (new CWE400_Resource_Exhaustion__Environment_write_53d()).goodB2G_sink(count );
    }
}
