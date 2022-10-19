package ru.agentche.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 18.10.2022
 */
public class Logger {

    private static Logger logger = null;
    protected int num = 1;

    private Logger() {
    }

    public void log(String msg) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String date = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println("[" + date + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        return logger == null ? logger = new Logger() : logger;
    }
}
