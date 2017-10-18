package ReliableCommunication.Application;
import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) {
        Server server=new Server();
        server.start(6666);
    }

    public void start(int port) {
        String greeting = "";
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            greeting = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }

    public void stop() {
        try {
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

}
