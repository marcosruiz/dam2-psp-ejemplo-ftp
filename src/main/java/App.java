import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class App {

  static final int PORT = 14147;
  static final String HOST = "localhost";
  static final String USER = "mruiz";
  static final String PASSWORD = "mruiz";

  public static void main(String[] args) throws IOException {
    FTPClient ftpClient = new FTPClient();

    ftpClient.connect(HOST);

    if(ftpClient.getReplyCode() == 220){
      System.out.println(ftpClient.getReplyString());
      System.out.println("El servidor FTP está preparado");
    }

    boolean isLogged = ftpClient.login(USER, PASSWORD);

    if(isLogged){
      System.out.println("Login correcto...");
    } else{
      System.out.println("Login incorrecto...");
    }

    System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

    FTPFile[] files = ftpClient.listFiles();
    System.out.println("Ficheros en el directorio actual: " + files.length);

    ftpClient.disconnect();
  }
}
