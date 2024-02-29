package populate;

import database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static final String FILE_NAME_POPULATE_DB = "sql/populate_db.sql";
    public void populateDB(Database database) {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(FILE_NAME_POPULATE_DB))
            );
            database.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabasePopulateService().populateDB(database);
    }
}
