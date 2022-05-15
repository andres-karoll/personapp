package co.edu.javeriana.as.personapp.terminal;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.domain.Telefono;

import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

public class terminal {

    // Simulación de un cls
    public static void cls() {
        for (int i = 0; i < 12; i++) {
            System.out.println(".");
        }
    }

    // Menu principal
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("Seleccione el modulo que desea utilizar: ");
            System.out.println("1. Modulo de Personas");
            System.out.println("2. Modulo de estudios");
            System.out.println("3. Modulo de profesión");
            System.out.println("4. Modulo de telefono");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            cls();
            // Seleccionar el modulo
            switch (opcion) {
                // Modulo de personas
                case "1":
                    System.out.println("Modulo de Personas");
                    System.out.println("1. Crear una persona");
                    System.out.println("2. Buscar una persona");
                    System.out.println("3. Listar personas");
                    System.out.println("4. Eliminar una persona");
                    System.out.println("5. Salir");
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.nextLine();
                    cls();
                    // Seleccionar la opcion del modulo
                    switch (opcion) {
                        // Crear una persona
                        case "1":
                            System.out.println("------------------------------------------------------");
                            System.out.println("Crear una persona");
                            Persona persona = new Persona();

                            System.out.println("Ingrese el nombre de la persona: ");
                            String nombre = sc.nextLine();
                            System.out.println("Ingrese el apellido de la persona: ");
                            String apellido = sc.nextLine();
                            System.out.println("Ingrese la cc de la persona: ");
                            int cc = sc.nextInt();
                            System.out.println("Ingrese el genero de la persona: ");
                            String genero = sc.nextLine();
                            System.out.println("Ingrese la edad de la persona: ");
                            int edad = sc.nextInt();
                            // TODO Make the request or call whoever i have to call
                            cls();
                            break;
                        // Buscar una persona
                        case "2":
                            System.out.println("Buscar una persona");
                            System.out.println("Ingrese el nombre de la persona: ");
                            System.out.println("Ingrese el apellido de la persona: ");
                            System.out.println("Ingrese la cc de la persona: ");
                            System.out.println("Ingrese el genero de la persona: ");
                            System.out.println("Ingrese la edad de la persona: ");
                            cls();
                            break;
                        // Listar personas
                        case "3":
                            System.out.println("Listar personas");
                            System.out.println("Ingrese el nombre de la persona: ");
                            System.out.println("Ingrese el apellido de la persona: ");
                            System.out.println("Ingrese la cc de la persona: ");
                            System.out.println("Ingrese el genero de la persona: ");
                            System.out.println("Ingrese la edad de la persona: ");
                            cls();
                            break;
                        // Eliminar una persona
                        case "4":
                            System.out.println("Eliminar una persona");
                            System.out.println("Ingrese el nombre de la persona: ");
                            System.out.println("Ingrese el apellido de la persona: ");
                            System.out.println("Ingrese la cc de la persona: ");
                            System.out.println("Ingrese el genero de la persona: ");
                            System.out.println("Ingrese la edad de la persona: ");
                            cls();
                            break;
                    }
                    break;
                // Modulo de estudios
                case "2":
                    pass();
                    break;
                // Modulo de profesion
                case "3":
                    pass();
                    break;
                // Modulo de telefono
                case "4":
                    pass();
                    break;
            }
        } while (!Objects.equals(opcion, "5"));


    }
}
