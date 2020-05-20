package app;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://m.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();

        content = content.replaceAll("\\n", "");

        Pattern p = Pattern.compile("<a type=\"nowplaying-song\"(.*?)</a>");
        Matcher m = p.matcher(content);
        while (m.find()) {
            Pattern p2 = Pattern.compile("title=\"(.*?)\">");
            Matcher m2 = p2.matcher(m.group(1));
            while (m2.find()) {
                System.out.println(m2.group(1));
            }
        }
    }
}
