package command.recivers;

public class WindowsFileSystemReceiver implements FileSystemReceiver {

  @Override
  public void openFile() {
    System.out.println("File was opened windows");
  }

  @Override
  public void writeFile() {
    System.out.println("Write in file windows");
  }

  @Override
  public void closeFile() {
    System.out.println("Close file windows");
  }
}
