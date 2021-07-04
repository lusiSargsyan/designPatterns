package command.os;

import command.recivers.FileSystemReceiver;
import command.recivers.UnixFileSystemReceiver;
import command.recivers.WindowsFileSystemReceiver;

public class OSBasedFileWorkerFactory {

    public static FileSystemReceiver getReceiver(OS os) {
        switch (os) {
            case UNIX:
                return new UnixFileSystemReceiver();
            case WINDOWS:
                return new WindowsFileSystemReceiver();
            default:
                throw new IllegalArgumentException("Unsupported OS version.");
        }
    }
}
