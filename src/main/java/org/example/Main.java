package org.example;

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //EPM GRANDES CLIENTES
        // 1. VER TARIFA
        // 2. MOSTRAR CONSUMO PROMEDIO
        //3. MOSTRAR PICOS DE CONSUMO
        //4. MOSTRAR FACTURA
        //5. SALIR

        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();

        Boolean esAdministrador;
        String respuestaPerfil;
        Double tarifaEnergia=0.0;
        Integer opcion;
        final String contraseña = "admin123*";       //El final me indica que siempre sera asi, que es constante
        String contraseñaAdmin;
        Integer numeroIntentos = 0;
        Integer sumaDias=0;
        Integer contadorDePicos = 0;



        System.out.println("************BIENVENIDO********************");
        System.out.print("Eres administrador?: ");
        respuestaPerfil = teclado.nextLine();


        //PROCESO PARA EL LOGIN

        if (respuestaPerfil.equalsIgnoreCase("si")){
            System.out.print("digita tu contraseña: ");
            do {
                contraseñaAdmin = teclado.nextLine();

                if (contraseñaAdmin.equals(contraseña)) {
                    System.out.print("Ingresa el valor del KWH: ");
                    tarifaEnergia = teclado.nextDouble();
                    System.out.println("La tarifa de energia quedo en $" + tarifaEnergia);

                    numeroIntentos = 3;

                } else {
                    System.out.println("vuelva a intentarlo : ");
                    numeroIntentos = numeroIntentos + 1;
                }

            } while (numeroIntentos < 3);


            Integer numeroVueltas = 0;    //CONTADOR


            do {
                numeroVueltas = numeroVueltas + 1;
                Integer numerogenerador = generador.nextInt(401);
                sumaDias=sumaDias+numerogenerador;

                if (numerogenerador > 300) {
                    System.out.println("pico detectado");
                    contadorDePicos = contadorDePicos + 1;
                } else {
                    System.out.println("operando normalmente");
                }

            } while (numeroVueltas < 30);

            System.out.println("Bienvenido al menu empresa: ");
            System.out.println("*******************************");
            System.out.println("1. Ver tarifa");
            System.out.println("2. Mostrar consumo promedio ");
            System.out.println("3. mostrar picos de consumo ");
            System.out.println("4. Mostrar factura ");
            System.out.println("5. Salir ");

            System.out.print("Digita una opcion: ");

            opcion=teclado.nextInt();

            do {

                switch (opcion)
                {
                    case 1:
                        System.out.println("Su tarifa es: "+tarifaEnergia);
                        break;
                    case 2:
                        System.out.println("consumo promedio: "+sumaDias/30);
                        break;
                    case 3:
                        System.out.println("Los picos de energia del mes son: "+contadorDePicos);
                        break;
                    case 4:
                        System.out.println("El valor de su factura es: "+sumaDias*tarifaEnergia);
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }

            }while (opcion!=5);




        }else {

        }






    }

}