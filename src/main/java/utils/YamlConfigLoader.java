package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlConfigLoader {
    private static final Config config;

    static {
        try (InputStream input = new FileInputStream("src/test/resources/config.yaml")) {
            Yaml yaml = new Yaml(new Constructor(Config.class));
            config = yaml.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load YAML config", e);
        }
    }

    public static Config getConfig() {
        return config;
    }
}
