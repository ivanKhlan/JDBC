package prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    public static final String DB_URL = "dbUrl";
    public static final String MAX_PROJECTS_CLIENT = "maxProjectsClientPath";
    public static final String LONGEST_PROJECT = "longestProject";
    public static final String MAX_SALARY_WORKERS = "maxSalaryWorkers";
    public static final String YOUNGEST_ELDEST_WORKERS = "youngestEldestWorkers";
    public static final String PROJECT_PRICES = "projectPrices";


    private Map<String, Object> prefs = new HashMap<>();

    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }
    public Prefs(String filename) {
        try {
            String json = String.join("\n", Files
                    .readAllLines(Paths.get(filename))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class
            );
            prefs = new Gson().fromJson(json, typeToken.getType());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(String key) {
        return getPref(key).toString();
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }

}
