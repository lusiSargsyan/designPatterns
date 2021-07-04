package command;

import command.commands.Command;

/**
 * This class just invokes corresponding Command execute method
 */
public class FileInvoker {

    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
