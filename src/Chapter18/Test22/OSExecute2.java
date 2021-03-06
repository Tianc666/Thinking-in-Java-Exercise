//: net/mindview/util/OSExecute.java
// Run an operating system command
// and send the output to the console.
package Chapter18.Test22;

import net.mindview.util.OSExecuteException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OSExecute2 {
    public static List<String> command(String command) {
        //以List输出
        LinkedList<String> ll = new LinkedList<String>();
        boolean err = false;
        try {
            Process process =
                    new ProcessBuilder(command.split(" ")).start();
            System.out.println(Arrays.toString(command.split(" ")));
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;

            while ((s = results.readLine()) != null) {
                ll.add(s);
                System.out.println(ll);
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value
            // to calling process if there are problems:
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            // Compensate for Windows 2000, which throws an
            // exception for the default command line:
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing " +
                    command);
        return ll;
    }
} ///:~
