import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

import java.io.IOException;

/**
 * Clase de ejemplo donde nos enviamos un email
 */
public class AppSmtp {
  public static void main(String[] args) throws IOException {
    SMTPClient client = new SMTPClient();

    // Nos conectamos al puerto 25
    client.connect("localhost");

    System.out.println(client.getReplyString());
    int response = client.getReplyCode();
    if(SMTPReply.isPositiveCompletion(response)){
      client.disconnect();
      System.out.println("Conexión rechazada");
      System.exit(1);
    }

    // TODO Enviamos un correo

    // Nos desconectamos
    client.disconnect();
  }
}
