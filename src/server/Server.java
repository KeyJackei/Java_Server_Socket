package server;

import model.UserMap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int SERVER_PORT = 8080;
    private UserMap userMap;

    public Server() {

        userMap = new UserMap();
    }

    public void start() {
        try (var listener = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = listener.accept();
                ClientHandler client = new ClientHandler(socket, userMap);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
