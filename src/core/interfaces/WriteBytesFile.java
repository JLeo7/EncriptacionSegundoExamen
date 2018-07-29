package core.interfaces;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public interface WriteBytesFile {
    static void writeBytesFile(String name, byte[] content, String type, String PATH) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(PATH + name + type);
        fos.write(content);
        fos.close();
    }
}
