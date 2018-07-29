package core.factories;

import core.enums.TipoEncriptacion;
import core.managers.AsymetricManager;
import core.managers.BlowfishManager;
import core.managers.SymetricManager;

public class FabridaEncriptacion {

    public static MetodoEncriptacion getManager(TipoEncriptacion tipo) {
        switch(tipo) {
            case ASYMETRIC: return new AsymetricManager();
            case SYMETRIC: return new SymetricManager();
            case BLOWFISH: return new BlowfishManager();
            default: return null;
        }
    }
}
