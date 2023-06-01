package server;

import model.User;
import model.UserMap;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PingClient {

    private final UserMap userMap;
    private final long timeout; // в миллисекундах
    private final ScheduledExecutorService scheduler;

    public PingClient(UserMap userMap, long timeout) {
        this.userMap = userMap;
        this.timeout = timeout;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void start() {
        this.scheduler.scheduleAtFixedRate(this::checkActivity, 0, timeout, TimeUnit.MILLISECONDS);
    }

    private void checkActivity() {
        long now = Instant.now().toEpochMilli();
        userMap.getUsers().values().forEach(user -> {
            if (now - user.getLastActive() > timeout) {
                try {
                    user.getSocket().close();
                    userMap.removeUser(user);
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии сокета пользователя: " + e.getMessage());
                }
            }
        });
    }

}
