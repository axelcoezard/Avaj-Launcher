package com.acoezard.avaj_launcher.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static BufferedWriter bufferedWriter;

    public Logger(String filename) throws IOException {
        if (bufferedWriter == null) {
            bufferedWriter = new BufferedWriter(new FileWriter(filename));
        }
    }

    public static void log(String log) throws IOException {
        if (bufferedWriter == null) {
            throw new IOException("No logger instance");
        }
        bufferedWriter.append(log);
    }
}
