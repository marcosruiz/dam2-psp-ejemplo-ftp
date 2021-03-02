import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

import java.io.IOException;

public class AppPop {
  static String ipServer = "localhost";
  static String username = "mruiz";
  static String password = "mruiz";
  static int port = 110;
  public static void main(String[] args) throws IOException {
    POP3Client client = new POP3Client();

    // Nos conectamos al servidor
    client.connect(ipServer, port);

    // Iniciamos sesión
    if(!client.login(username, password)){
      System.err.println("Error al hacer login");
    } else {
      // Obtenemos todos los mensajes en un array
      POP3MessageInfo[] messages = client.listMessages();

      if(messages == null){
        System.err.println("Imposible recuperar mensajes.");
      } else {
        System.out.printf("Nº de mensajes: %d%n", messages.length);
      }

      client.logout();
      client.disconnect();
    }
  }

  private static void recuperarMensajes(POP3MessageInfo[] messages, POP3SClient client) throws IOException {
    for(int i=0; i<messages.length; i++){
      System.out.printf("Mensaje: %d%n", i+1);
      POP3MessageInfo msgInfo = messages[i];
      System.out.printf("Identificador: %s, Number: %d, Tamaño: %d%n", msgInfo.identifier, msgInfo.number, msgInfo.size);

      System.out.println("\tPrueba de listUniqueIdentifier: ");
      POP3MessageInfo pop3MessageInfo = client.listUniqueIdentifier(i+1);
      System.out.printf("Identificador: %s, Number: %d, Tamaño: %d%n", pop3MessageInfo.identifier, pop3MessageInfo.number, pop3MessageInfo.size);
    }
  }
}
