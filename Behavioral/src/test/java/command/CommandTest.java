package command;

import command.commands.Command;
import command.commands.OpenFileCommand;
import command.os.OS;
import command.os.OSBasedFileWorkerFactory;
import command.recivers.FileSystemReceiver;
import org.junit.Test;

/**
 * Not an actual test just an client to show how to use
 */
public class CommandTest {

    @Test
    public void doTest() {
        FileSystemReceiver fileSystemReceiver = OSBasedFileWorkerFactory.getReceiver(OS.UNIX);
        Command openCommand = new OpenFileCommand(fileSystemReceiver);
        FileInvoker invoker = new FileInvoker(openCommand);
        invoker.execute();
    }
}
