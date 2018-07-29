package core.interfaces;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public interface ReadMessageFile {
    static byte[] readMessageFile(String messageName, String PATH, String MESSAGE_ENCRYPT_EXTENSION) throws Exception {
        File file = new File(PATH + messageName + MESSAGE_ENCRYPT_EXTENSION);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        Base64.Decoder oneDecoder = Base64.getDecoder();
        reader.close();
        return oneDecoder.decode(bytes);
    }
}
