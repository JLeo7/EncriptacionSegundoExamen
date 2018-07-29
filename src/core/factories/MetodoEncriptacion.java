package core.factories;

public abstract class MetodoEncriptacion {
    protected final String KEY_EXTENSION = ".key";
    protected final String MESSAGE_ENCRYPT_EXTENSION = ".encript";

    public abstract void createKey(String name) throws Exception;

    public abstract String encryptMessage(String messageName, String message, String keyName) throws Exception;

    public abstract String decryptMessage(String messageName, String keyName) throws Exception;

}
