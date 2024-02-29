package initdatabase;

import database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static final String FILE_NAME_INIT_DB = "sql/init_db.sql";
    public void initDb(Database database) {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(FILE_NAME_INIT_DB))
            );
            database.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseInitService().initDb(database);

    }
}
