package core.interfaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public interface ReadKeyFile {

    static byte[] readKeyFile(String PATH, String keyName, String KEY_EXTENSION) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(PATH + keyName + KEY_EXTENSION));
        String everything = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        return everything.getBytes(StandardCharsets.UTF_8);
    }
}
