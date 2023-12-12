package tests_data.authen;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static <T> T buildObjectData(String filePath, Class<T> dataType) {
        T objectData;
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
        ) {
            Gson gson = new Gson();
            objectData = gson.fromJson(reader, dataType);

        } catch (NoSuchFileException noSuchFileException) {
            throw new RuntimeException("[ERR] cannot locate file ".concat(absoluteFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        System.out.println(absoluteFilePath);
        return objectData;
    }
}
