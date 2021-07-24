package generator.baekjoon.java;

import config.Config;
import generator.Generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class BJJavaGenerator implements Generator {
    @Override
    public boolean generate(Object problemInfo) {
        Config config = Config.config;
        String info = "";
        try {
            info = config.packageName + (String) problemInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = info;
        if (config.srcRoute != null) {
            path = config.srcRoute + "/" + path;
        }
        File folder = new File(path);
        if (!folder.exists()) {
            try {
                folder.mkdir();
                BufferedWriter fw = new BufferedWriter(new FileWriter(path + "/Main.java", true));
                fw.write("package " + info + ";\n" +
                        "\n" +
                        applyLineBreaking(config.comment) +
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
                System.out.println(problemInfo + "번 문제 파일이 생성되었습니다.");
                return true;
            } catch (Exception e) {
                System.out.println("config.yaml파일의 srcRoute를 확인해주세요.");
                return false;
            }
        } else {
            System.out.println("이미 생성되었습니다.");
            return false;
        }
    }

    public static String applyLineBreaking(Object s) {
        return ((String) s).replace("\\n", "\n");
    }
}
