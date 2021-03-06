package core.tests;

import core.managers.AsymetricManager;
import core.managers.BlowfishManager;
import core.managers.SymetricManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncriptacionTests {

    static SymetricManager aes;
    static AsymetricManager rsa;
    static BlowfishManager blowfish;

    @BeforeClass
    static public void init() {
        aes = new SymetricManager();
        rsa = new AsymetricManager();
        blowfish = new BlowfishManager();
    }

    @Test (expected = Exception.class)
    public void TestEntriptarAES() throws Exception {
        assertEquals("jJ37lG7Jr1oQBpQWBUT8PZPhBPO6DLGz8IkbbN7LGx4=", aes.encryptMessage("mensajito", "aqui va el mensajito", "llaveaes"));
    }

    // Encriptar un mensaje con el mentodo RSA genera un mensaje encriptado diferente cada vez, aun con la misma llave y con el mismo nombre y contenido de mensaje. Por eso no se incluye la prueba de encriptacion con RSA.

    @Test (expected = Exception.class)
    public void TestDesentriptarAES() throws Exception {
        assertEquals("aqui va el mensajito", aes.decryptMessage("mensajito", "llaveaes"));
    }

    @Test (expected = Exception.class)
    public void TestDesentriptarRSA() throws Exception {
        assertEquals("aqui va el mensajito", rsa.decryptMessage("mensajito", "llaversa"));
    }

    @Test
    public void TestEntriptarBlowFish() throws Exception {
        assertEquals("uUI1HlxGQQUkjx1H356HUiAiXc4EKVOt", blowfish.encryptMessage("mensajito", "aqui va el mensajito", "llavebf"));
    }

    @Test (expected = Exception.class)
    public void TestDesentriptarBlowFish() throws Exception {
        assertEquals("aqui va el mensajito", blowfish.decryptMessage("mensajito", "llavebf"));
    }
}
