import java.util.Random;
import java.util.Scanner;

public class sismosTemuco {

    public static void main(String[] args){

        double[][] sismos = new double[7][10];
        inicio(sismos);
    }
    private static void inicio(double[][] sismos){

        System.out.println("bienvenido, ingrese un numero"
                + "\n1) ingresar datos"
                + "\n2) mostrar sismo de mayor magnitúd"
                + "\n3) Contar sismos mayores o iguales a 5.0"
                + "\n4) enviar SMS por cada sismo mayor o igual a 7.0"
                + "\n5) mostrar sismos"
                + "\n6) salir");

        entrada(sismos);
    }
    private static void entrada(double[][] sismos ){

        boolean contener = false;
        Scanner sc = new Scanner(System.in);
        int entrada = 0;

        do {
            System.out.println("ingrese un numero");
            if (sc.hasNextInt()) {
                entrada = sc.nextInt();
                if(entrada > 0 && entrada < 7) {
                    contener = true;
                }
            } else {
                sc.nextLine();
                System.out.println("ingrese un valor entero valido");
            }
        } while (!contener);

        menu(sismos, entrada);

    }
    private static void menu(double[][] sismos, int entrada){

        switch (entrada){

            case 1: generarSismos(sismos);
                    inicio(sismos);
            case 2: mostrarSismoMayorMagnitud(sismos);
            case 3: contarMayorigual5(sismos);
            case 4: alertaMayorIgual7(sismos);
            case 5: mostrarSismos(sismos);
            case 6: kill();

        }
    }
    private static double[][] generarSismos(double[][] sismos){

        Random random = new Random();

        for(int fila = 0; fila < sismos.length; fila++){
            for(int columna = 0; columna < sismos[fila].length; columna++){

                sismos[fila][columna] = Math.round(random.nextDouble(10)*100.0)/100.0;
            }
        }
        return sismos;
    }
    private static void mostrarSismos(double[][] sismos){

        for(int fila = 0; fila < sismos.length; fila++){
            for(int columna = 0; columna < sismos[fila].length; columna++){

                System.out.print(sismos[fila][columna] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");

        inicio(sismos);
    }
    private static void mostrarSismoMayorMagnitud(double[][] sismos){

        double mayorSismo = -1.000;

        for(int fila = 0; fila < sismos.length; fila++){
            for(int columna = 0; columna < sismos[fila].length; columna++){

                if(mayorSismo < sismos[fila][columna]){

                    mayorSismo = sismos[fila][columna];
                }
            }
        }
        System.out.println("El mayor sismo fue de: " + mayorSismo);
        System.out.println("");

        inicio(sismos);
    }
    private static void contarMayorigual5(double[][] sismos){

        int mayorIgual5 = 0;

        for(int fila = 0; fila < sismos.length; fila++){
            for(int columna = 0; columna < sismos[fila].length; columna++){

                if(sismos[fila][columna] >= 5.0){

                    mayorIgual5 ++;
                }
            }
        }
        System.out.println("Cantidad de sismos mayor igual 5: " + mayorIgual5);
        System.out.println("");

        inicio(sismos);
    }
    private static void alertaMayorIgual7(double[][] sismos){

        for(int fila = 0; fila < sismos.length; fila++){
            for(int columna = 0; columna < sismos[fila].length; columna++){

                if(sismos[fila][columna] >= 7.0){

                    System.out.println("ALERTA SISMO!!!");
                }
            }
        }
        inicio(sismos);
    }
    private static void kill(){

        System.exit(1);
    }
}
