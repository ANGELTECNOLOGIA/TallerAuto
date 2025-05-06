package tallerautos;

import java.util.Scanner;

public class TallerAutos {

    public static void main(String[] args) {
        
        int eleccion = -1;
        Coche rayoMcQueen = new Coche(0, 5, false, 20.1f);
        
        Scanner sc = new Scanner(System.in);
        
        while(eleccion != 0){
            System.out.println("\n--- Menú de acciones ---");
            System.out.println("1: Subir marcha");
            System.out.println("2: Bajar marcha");
            System.out.println("3: Encender motor");
            System.out.println("4: Apagar motor");
            System.out.println("5: Acelerar");
            System.out.println("6: Rotar llantas (grados)");
            System.out.println("7: Inflar llantas");
            System.out.println("0: Salir");
            System.out.print("Elección: ");
            
            eleccion = sc.nextInt();
            
            switch (eleccion) {
                case 1:
                    rayoMcQueen.subirMarcha();
                    break;
                case 2:
                    rayoMcQueen.bajarMarcha();
                    break;
                case 3:
                    rayoMcQueen.encender();
                    break;
                case 4:
                    rayoMcQueen.apagar();
                    break;
                case 5:
                    rayoMcQueen.acelerar();
                    break;
                case 6:
                    System.out.print("Grados (positivo=derecha, negativo=izquierda): ");
                    int grados = sc.nextInt();
                    rayoMcQueen.rotarDerechaIzquierda(grados);
                    break;
                case 7:
                    rayoMcQueen.inflarse();
                    break;
                default:
                    if (eleccion != 0) System.out.println("Opción inválida!");
            }
        }
        System.out.println("Programa terminado.");
        sc.close();
    }
}