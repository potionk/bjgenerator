package config;

import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Config {
    public static final Config config = fromFile("config.yaml");
    public Object srcRoute;
    public Object prgJSRoute;
    public Object packageName;
    public Object comment;

    private static Config fromFile(String filename) {
        try {
            YamlReader reader = new YamlReader(new FileReader(filename));
            Config config = reader.read(Config.class);
            reader.close();
            return config;
        } catch (FileNotFoundException e) {
            String message = filename + " 파일을 읽을 수 없습니다.\n" + e.getMessage();
            throw new RuntimeException(message);
        } catch (IOException e) {
            String message = filename + " 파일을 정상적으로 읽지 못하였습니다." + filename + "\n" + e.getMessage();
            throw new RuntimeException(message);
        }
    }
}
