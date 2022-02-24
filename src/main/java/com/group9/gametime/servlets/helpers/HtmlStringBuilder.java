package com.group9.gametime.servlets.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

public class HtmlStringBuilder {
    public static String buildString(String filePath, String ... messages) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = "";
        StringBuffer buffer = new StringBuffer();

        while ((line=reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        String page = buffer.toString();
        page = MessageFormat.format(page, messages);

        return page;
    }
}
