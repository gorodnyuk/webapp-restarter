package ru.gorodnyuk.utils;

import java.net.ServerSocket;

public class SocketUtils {

    public static boolean isAvailable(int port) {
        try (ServerSocket socket = new ServerSocket(port)) {
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
