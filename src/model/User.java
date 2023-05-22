package model;

import server.SocketWrapper;

import java.io.IOException;

    public class User {
        private String name;
        private SocketWrapper socket;

        public User(String name, SocketWrapper socket) {
            this.name = name;
            this.socket = socket;
        }

        public static User fromSocket(SocketWrapper socket) throws IOException {
            String name = socket.readLine();
            return new User(name, socket);
        }

        public String getName() {
            return name;
        }

        public SocketWrapper getSocket() {
            return socket;
        }
}
