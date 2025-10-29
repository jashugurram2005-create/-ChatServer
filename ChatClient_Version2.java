import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "localhost"; // Change to server IP if needed
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Thread to read messages from server
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Received: " + msg);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        }).start();

        // Main thread to send messages
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();
            out.println(msg);
        }
    }
}