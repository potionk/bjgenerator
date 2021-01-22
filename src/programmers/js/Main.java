package programmers.js;

import config.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Config config = Config.config;
        StringBuilder sb = new StringBuilder();
        int len = args.length;
        for (int i = 0; i < len; i++) {
            sb.append(args[i]);
            if (i != len - 1) {
                sb.append("_");
            }
        }
        sb.append(".js");
        String fileName = sb.toString();
        String path = "/";
        if (config != null && config.prgJSRoute != null) {
            path = config.prgJSRoute + path;
        }
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(path + "test.html"));
            fw.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Test</title>\n" +
                    "    <script src=\"" + fileName + "\"></script>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <button onclick=\"test()\">Test</button>\n" +
                    "</body>\n" +
                    "</html>");
            fw.flush();
            fw.close();
            fw = new BufferedWriter(new FileWriter(path + fileName, true));
            fw.write("\n\nfunction test() {\n" +
                    "    solution();\n" +
                    "}");
            fw.flush();
            fw.close();
            System.out.println(fileName + " 파일이 생성되었습니다.");
        } catch (Exception e) {
            System.out.println("config.yaml의 경로를 확인해주세요.");
        }
    }
}
