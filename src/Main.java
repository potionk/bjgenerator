import generator.Generator;
import generator.baekjoon.java.BJJavaGenerator;
import generator.programmers.js.PGJSGenerator;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }
        switch (args[0]) {
            case "-help":
            case "--help":
                printHelp();
                break;
            case "-pjs":
                if (isCorrectArg(args[1])) {
                    Generator generator = new PGJSGenerator();
                    generator.generate(args);
                } else {
                    System.out.println("문제 이름을 입력해주세요");
                }
                break;
            case "bjj":
            default:
                Generator generator = new BJJavaGenerator();
                String problemNum;
                if (args[0].equals("-bjj")) {
                    problemNum = args[1];
                } else {
                    problemNum = args[0];
                }
                if (isCorrectArg(problemNum)) {
                    generator.generate(problemNum);
                } else {
                    System.out.println("문제 번호를 입력해주세요");
                }
        }
    }

    public static boolean isCorrectArg(String arg) {
        return arg != null && !arg.equals("");
    }

    public static void printHelp() {
        System.out.println("Usage: java -jar bjgenerator.jar [--help]\n" +
                "[<bj problem num>] [-pjs <problem name>] [-bjj <bj problem num>]");
    }
}
