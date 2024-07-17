package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final String DATA_FILE_PATH = "src/test/resources/data/userData.json";
    private static JsonNode dataNode;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            dataNode = objectMapper.readTree(new File(DATA_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load user data from JSON file");
        }
    }

    public static JsonNode getDataNode(String key) {
        return dataNode.path(key);
    }
}
