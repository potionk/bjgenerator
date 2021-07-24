package generator.programmers.js;

import config.Config;
import generator.Generator;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PGJSGenerator implements Generator {
    @Override
    public boolean generate(Object problemInfo) {
        Config config = Config.config;
        String[] args;
        try {
            args = (String[]) problemInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        StringBuilder sb = new StringBuilder();
        int len = args.length;
        for (int i = 1; i < len; i++) {
            sb.append(args[i]);
            if (i != len - 1) {
                sb.append("_");
            }
        }
        sb.append(".js");
        String fileName = sb.toString();
        String path = (String) config.prgJSRoute;
        if(path.charAt(path.length()-1)!='/'){
            path+="/";
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
            return true;
        } catch (Exception e) {
            System.out.println("config.yaml파일의 prgJSRoute를 확인해주세요.");
            return false;
        }
    }
}
