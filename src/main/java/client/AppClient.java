package client;

import org.apache.commons.net.ftp.FTPClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AppClient {
  private JPanel panelMain;
  private JButton subirFicheroButton;
  private JButton descargarFicheroButton;
  private JButton salirButton;
  private JTextField user;
  private JTextField password;
  private JButton loginButton;

  static final String DEFAULT_HOST = "localhost";

  public AppClient() {

    subirFicheroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("subirFicheroButton");
      }
    });

    descargarFicheroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("descargarFicheroButton");
      }
    });

    salirButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("salirButton");
      }
    });
    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        FTPClient ftpClient = new FTPClient();

        try {
          ftpClient.connect(DEFAULT_HOST);


          if (ftpClient.getReplyCode() == 220) {
            System.out.println(ftpClient.getReplyString());
            System.out.println("El servidor FTP está preparado");
          }

          boolean isLogged = ftpClient.login(user.getText(), password.getText());

          if (isLogged) {
            System.out.println("Login correcto...");



          } else {
            System.out.println("Login incorrecto...");
          }

        } catch (IOException ioException) {
          ioException.printStackTrace();
        }
      }
    });
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("App");
    jFrame.setContentPane(new AppClient().panelMain);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
  }


}
