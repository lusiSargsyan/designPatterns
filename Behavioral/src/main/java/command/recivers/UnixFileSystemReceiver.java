package command.recivers;

public class UnixFileSystemReceiver implements FileSystemReceiver {

  @Override
  public void openFile() {
    System.out.println("File was opened unix");
  }

  @Override
  public void writeFile() {
    System.out.println("Write in file unix");
  }

  @Override
  public void closeFile() {
    System.out.println("Close file unix");
  }
}
