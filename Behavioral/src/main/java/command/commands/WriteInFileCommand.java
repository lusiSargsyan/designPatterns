package command.commands;

import command.recivers.FileSystemReceiver;

public class WriteInFileCommand implements Command {

   private FileSystemReceiver fileSystemReceiver;

    public WriteInFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.writeFile();
    }
}
