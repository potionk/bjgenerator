import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import config.Config;

public class Main {
    // args[0] => 백준 문제 번호
    public static void main(String[] args) {
        Config config = Config.config;
        String info = "bj" + args[0];
        String path = info;
        if (config != null && config.srcRoute != null) {
            path = config.srcRoute + "/" + path;
        }
        File folder = new File(path);
        if (!folder.exists()) {
            try {
                folder.mkdir();
                BufferedWriter fw = new BufferedWriter(new FileWriter(path + "/Main.java", true));
                fw.write("package " + info + ";\n" +
                        "\n" +
                        "import java.io.*;\n" +
                        "\n" +
                        "public class Main {\n" +
                        "    public static void main(String[] args) throws IOException {\n" +
                        "        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n" +
                        "        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));\n" +
                        "        br.close();\n" +
                        "        bw.close();\n" +
                        "    }\n" +
                        "}\n");
                fw.flush();
                fw.close();
                System.out.println(args[0] + "번 문제 파일이 생성되었습니다.");
            } catch (Exception e) {
                System.out.println("config.yaml의 경로를 확인해주세요.");
            }
        } else {
            System.out.println("이미 생성되었습니다.");
        }
    }
}
