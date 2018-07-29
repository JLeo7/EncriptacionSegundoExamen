package ui;

import core.enums.TipoEncriptacion;
import core.factories.FabridaEncriptacion;
import core.factories.MetodoEncriptacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UI {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static MetodoEncriptacion manager;

    public static void main(String[] args) throws Exception {
        TipoEncriptacion tipo;

        int option;

        do {

            do {

                System.out.println("--- Metodos de encriptacion ---");
                System.out.println();
                System.out.println("1.  AES");
                System.out.println("2.  RSA");
                System.out.println("3.  Blowfish");
                System.out.println();
                System.out.print("Por favor, eliga uno de los metodos para continuar: ");
                tipo = obtenerTipoEncriptacion(Integer.parseInt(in.readLine()));

            } while (tipo == null);

            System.out.println("--- Menu ---");
            System.out.println();
            System.out.println("0.  Volver ");
            System.out.println("1.  Crear llave");
            System.out.println("2.  Encriptar mensaje");
            System.out.println("3.  Descencriptar mensaje");
            System.out.println();
            System.out.print("Por favor, eliga una opcion para continuar: ");
            option = Integer.parseInt(in.readLine());

            if (option >= 1 && option <= 3) {
                ejecutarAccion(option, tipo);
            }

        } while (option != 0);

    }

    private static TipoEncriptacion obtenerTipoEncriptacion(int pOption) {
        TipoEncriptacion tipo = null;
        switch (pOption) {
            case 1:
                tipo = TipoEncriptacion.SYMETRIC;
                break;
            case 2:
                tipo = TipoEncriptacion.ASYMETRIC;
                break;
            case 3:
                tipo = TipoEncriptacion.BLOWFISH;
                break;
            default:
                System.out.println("Valor invalido!");
        }
        return tipo;
    }

    private static void ejecutarAccion(int option, TipoEncriptacion type) throws Exception {
        manager = FabridaEncriptacion.getManager(type);
        if (option == 1) {
            System.out.print("Digite el nombre de la llave: ");
            String name = in.readLine();
            System.out.println();
            manager.createKey(name);
        }
        if (option == 2) {
            System.out.println();
            System.out.print("Digite el nombre de la llave: ");
            String name = in.readLine();
            System.out.print("Digite el nombre del mensaje: ");
            String messageName = in.readLine();
            System.out.print("Digite el contenido del mensaje: ");
            String message = in.readLine();
            System.out.println();
            manager.encryptMessage(messageName, message, name);
        }
        if (option == 3) {
            System.out.print("Digite el nombre de la llave: ");
            String keyName = in.readLine();
            System.out.print("Digite el nombre del mensaje: ");
            String messageName = in.readLine();
            System.out.println();
            manager.decryptMessage(messageName, keyName);
        }
    }

}
