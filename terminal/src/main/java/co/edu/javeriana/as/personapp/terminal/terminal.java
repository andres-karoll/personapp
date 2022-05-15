package co.edu.javeriana.as.personapp.terminal;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.service.PersonaService;
import co.edu.javeriana.as.personapp.core.service.EstudioService;
import co.edu.javeriana.as.personapp.core.service.ProfesionService;
import co.edu.javeriana.as.personapp.core.service.TelefonoService;

import java.util.ArrayList;
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

    // Simulación de un pause
    public static void pause() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Presione enter para continuar...");
        sc.nextLine();
    }

    // Menu principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;
        int cc, id;
        PersonaService personaService = new PersonaService();
        EstudioService estudioService = new EstudioService();
        ProfesionService profesionService = new ProfesionService();
        TelefonoService telefonoService = new TelefonoService();
        Persona persona;
        Estudio estudio;
        Profesion profesion;
        Telefono telefono;
        ArrayList<Telefono> telefonos;
        ArrayList<Estudio> estudios;

        do {
            System.out.println("Seleccione el modulo que desea utilizar: ");
            System.out.println("1. Modulo de Personas");
            System.out.println("2. Modulo de estudios");
            System.out.println("3. Modulo de profesión");
            System.out.println("4. Modulo de telefono");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            cls();
            // Seleccionar el modulo
            switch (opcion) {
                // Modulo de personas
                case "1":
                    System.out.println("------------------------------------------------------");
                    System.out.println("Modulo de Personas");
                    System.out.println("1. Crear una persona");
                    System.out.println("2. Buscar una persona");
                    System.out.println("3. Listar personas");
                    System.out.println("4. Eliminar una persona");
                    System.out.println("5. Editar una persona");
                    System.out.println("0. Salir");
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.nextLine();
                    cls();
                    // Seleccionar la opcion del modulo
                    switch (opcion) {
                        // Crear una persona
                        case "1":
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tCrear una persona");
                            persona = new Persona();
                            telefono = new Telefono();
                            telefonos = new ArrayList<>();
                            estudios = new ArrayList<>();
                            estudio = new Estudio();
                            System.out.println("Ingrese el nombre de la persona: ");
                            persona.setNombre(sc.nextLine());
                            System.out.println("Ingrese el apellido de la persona: ");
                            persona.setApellido(sc.nextLine());
                            System.out.println("Ingrese la cc de la persona: ");
                            persona.setCc(sc.nextInt());
                            System.out.println("Ingrese el genero de la persona: ");
                            persona.setGenero(Genero.valueOf(sc.next()));
                            System.out.println("Ingrese la edad de la persona: ");
                            persona.setEdad(sc.nextInt());
                            System.out.println("Ingrese el telefono de la persona: ");
                            telefono.setNum(sc.nextLine());
                            System.out.println("Ingrese el operador de telefono de la persona: ");
                            telefono.setOper(sc.nextLine());
                            telefono.setDuenio(persona);
                            telefonos.add(telefono);
                            persona.setTelefonos(telefonos);
                            System.out.println("Ingrese el id de la profesion de la persona: ");
                            estudio.setIdProfesion(sc.nextInt());
                            estudio.setCcPersona(persona.getCc());
                            System.out.println("Ingrese la universidad en la que estudio: ");
                            estudio.setUniversidad(sc.nextLine());
                            estudios.add(estudio);
                            persona.setEstudios(estudios);
                            estudioService.crear(estudio);
                            telefonoService.crear(telefono);

                            System.out.println(personaService.crear(persona));

                            pause();
                            cls();
                            break;
                        // Buscar una persona
                        case "2": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tBuscar una persona");
                            System.out.println("Ingrese la cc de la persona: ");
                            cc = sc.nextInt();
                            System.out.println(personaService.buscarPorId(cc).toString());
                            pause();
                            cls();
                            break;
                        // Listar personas
                        case "3": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tListar personas");
                            System.out.println("Total de personas: " + personaService.contar());
                            System.out.println("Listado de personas: ");
                            System.out.println(personaService.buscarTodo().toString());
                            pause();
                            cls();
                            break;
                        // Eliminar una persona
                        case "4": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tEliminar una persona");
                            System.out.println("Ingrese la cc de la persona: ");
                            cc = sc.nextInt();
                            System.out.println(personaService.eliminar(cc));
                            pause();
                            cls();
                            break;
                        // Editar una persona
                        case "5":
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tEditar una persona");
                            System.out.println("Ingrese la cc de la persona: ");
                            cc = (sc.nextInt());
                            persona = personaService.buscarPorId(cc);
                            telefono = new Telefono();
                            estudio = new Estudio();
                            System.out.println("Ingrese el nombre de la persona: ");
                            persona.setNombre(sc.nextLine());
                            System.out.println("Ingrese el apellido de la persona: ");
                            persona.setApellido(sc.nextLine());
                            System.out.println("Ingrese la cc de la persona: ");
                            persona.setCc(sc.nextInt());
                            System.out.println("Ingrese el genero de la persona: ");
                            persona.setGenero(Genero.valueOf(sc.next()));
                            System.out.println("Ingrese la edad de la persona: ");
                            persona.setEdad(sc.nextInt());
                            System.out.println("Ingrese el telefono de la persona: ");
                            telefono.setNum(sc.nextLine());
                            System.out.println("Ingrese el operador de telefono de la persona: ");
                            telefono.setOper(sc.nextLine());
                            telefono.setDuenio(persona);
                            persona.getTelefonos().add(telefono);
                            System.out.println("Ingrese el id de la profesion de la persona: ");
                            estudio.setIdProfesion(sc.nextInt());
                            estudio.setCcPersona(persona.getCc());
                            System.out.println("Ingrese la universidad en la que estudio: ");
                            estudio.setUniversidad(sc.nextLine());
                            persona.getEstudios().add(estudio);

                            estudioService.crear(estudio);
                            telefonoService.crear(telefono);

                            System.out.println(personaService.editar(cc, persona));
                            pause();
                            cls();
                            break;
                        // Salir
                        case "0":
                            System.out.println("Saliendo...");
                            break;
                    }
                    break;
                // Modulo de estudios
                case "2":
                    System.out.println("------------------------------------------------------");
                    System.out.println("\tModulo de estudios");
                    System.out.println("1. Buscar un estudio");
                    System.out.println("2. Listar estudios");
                    System.out.println("3. Eliminar un estudio");
                    System.out.println("4. Editar un estudio");
                    System.out.println("0. Salir");
                    System.out.println("------------------------------------------------------");
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        // Buscar un estudio
                        case "1": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tBuscar un estudio");
                            System.out.println("Ingrese el id de la profesion: ");
                            id = sc.nextInt();
                            System.out.println("Ingrese la cc de la persona: ");
                            cc = sc.nextInt();
                            System.out.println(estudioService.buscarPorId(cc, id).toString());
                            pause();
                            cls();
                            break;
                        // Listar estudios
                        case "2": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tListar estudios");
                            System.out.println("Total de estudios: " + estudioService.contar());
                            System.out.println("Listado de estudios: ");
                            System.out.println(estudioService.buscarTodo().toString());
                            pause();
                            cls();
                            break;
                        // Eliminar un estudio
                        case "3": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tEliminar un estudio");
                            System.out.println("Ingrese el id de la profesion: ");
                            id = sc.nextInt();
                            System.out.println("Ingrese la cc de la persona: ");
                            cc = sc.nextInt();

                            System.out.println(estudioService.eliminar(cc, id));

                            pause();
                            cls();
                            break;
                        // Editar un estudio
                        case "4":
                            estudio = new Estudio();
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tEditar un estudio");
                            System.out.println("Ingrese el id de la profesion: ");
                            id = sc.nextInt();
                            System.out.println("Ingrese la cc de la persona: ");
                            cc = sc.nextInt();


                            System.out.println(estudioService.editar(id, cc, estudio));
                            pause();
                            cls();
                            break;
                        // Salir
                        case "0":
                            System.out.println("Saliendo...");
                            break;
                    }
                    break;
                // Modulo de profesion
                case "3":
                    System.out.println("------------------------------------------------------");
                    System.out.println("Modulo de profesion");
                    System.out.println("1. Crear una profesion");
                    System.out.println("2. Buscar una profesion");
                    System.out.println("3. Listar profesiones");
                    System.out.println("4. Eliminar una profesion");
                    System.out.println("5. Editar una profesion");
                    System.out.println("0. Salir");
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.nextLine();
                    cls();
                    // Seleccionar la opcion del modulo
                    switch (opcion) {
                        // Crear una profesion
                        case "1": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tCrear una profesion");
                            profesion = new Profesion();
                            System.out.println("Ingrese el nombre de la profesion: ");
                            profesion.setNom(sc.nextLine());
                            System.out.println("Ingrese el id de la profesion: ");
                            profesion.setId(sc.nextInt());
                            System.out.println("Ingrese la descripción de la profesion: ");
                            profesion.setDes(sc.nextLine());
                            System.out.println(profesionService.crear(profesion));
                            pause();
                            cls();
                            break;
                        // Buscar una profesion
                        case "2": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tBuscar una profesion");
                            System.out.println("Ingrese el id de la profesion: ");
                            id = sc.nextInt();
                            System.out.println(profesionService.buscarPorId(id).toString());
                            pause();
                            cls();
                            break;
                        // Listar profesiones
                        case "3": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tListar profesiones");
                            System.out.println("Total de profesiones: " + profesionService.contar());
                            System.out.println("Listado de profesiones: ");
                            System.out.println(profesionService.buscarTodo().toString());
                            pause();
                            cls();
                            break;
                        // Eliminar una profesion
                        case "4": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tEliminar una profesion");
                            System.out.println("Ingrese el id de la profesion: ");
                            id = sc.nextInt();
                            System.out.println(profesionService.eliminar(id));
                            System.out.println(profesionService.eliminar(id));
                            pause();
                            cls();
                            break;
                        // Editar una profesion
                        case "5": // DONE
                            System.out.println("------------------------------------------------------");
                            System.out.println("\tEditar una profesion");
                            System.out.println("Ingrese el id de la profesion que desea editar: ");
                            id = sc.nextInt();
                            profesion = new Profesion();
                            System.out.println("---Editando profesion---");
                            System.out.println("Ingrese el nombre de la profesion: ");
                            profesion.setNom(sc.nextLine());
                            System.out.println("Ingrese el id de la profesion: ");
                            profesion.setId(sc.nextInt());
                            System.out.println("Ingrese la descripción de la profesion: ");
                            profesion.setDes(sc.nextLine());
                            System.out.println(profesionService.editar(id, profesion));
                            pause();
                            cls();
                            break;
                        // Salir
                        case "0":
                            System.out.println("Saliendo...");
                            break;
                    }
                    break;
                // Modulo de telefono
                case "4":
                    break;
                // Salir
                case "0":
                    System.out.println("Saliendo...");
                    break;
            }
        } while (!Objects.equals(opcion, "0"));


    }
}
