package server;

import model.Message;
import model.TextMessage;
import model.User;
import model.UserMap;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{

    private SocketWrapper socketWrapper;
    private UserMap userMap;

    public ClientHandler(Socket socket, UserMap userMap) throws IOException {
        this.socketWrapper = new SocketWrapper(socket);
        this.userMap = userMap;
    }

    @Override
    public void run() {
        try {
            User user = User.fromSocket(socketWrapper);
            userMap.addUser(user);
            MessageBroadcaster.broadcastMessage(userMap, user.getName());

            String message;
            while ((message = socketWrapper.readLine()) != null) {
                TextMessage msg = new TextMessage(message); // Убрал User.getName()
                MessageBroadcaster.broadcastMessage(userMap, msg.toString());
            }

            userMap.removeUser(user);
            MessageBroadcaster.broadcastMessage(userMap, "User " + user.getName() + " has left");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
