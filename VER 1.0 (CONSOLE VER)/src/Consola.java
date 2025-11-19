import java.util.List;
import java.util.Scanner;

// Clase Consola para manejar la interfaz de usuario
public class Consola {
    private Universidad universidad;
    private Scanner scanner;

    public Consola() {
        this.universidad = new Universidad();
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú y manejar opciones
    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Sistema de Gestión de Universidad ===");
            System.out.println("1. Agregar miembro");
            System.out.println("2. Editar miembro");
            System.out.println("3. Eliminar miembro");
            System.out.println("4. Listar todos los miembros");
            System.out.println("5. Mostrar roles");
            System.out.println("6. Buscar por rol");
            System.out.println("7. Ordenar estudiantes por apellido");
            System.out.println("8. Buscar estudiante por apellido");
            System.out.println("9. Agregar materia");
            System.out.println("10. Listar materias");
            System.out.println("11. Asignar estudiante a materia");
            System.out.println("12. Agregar carrera");
            System.out.println("13. Listar carreras");
            System.out.println("14. Asignar estudiante a carrera");
            System.out.println("15. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intenta de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarMiembro();
                    break;
                case 2:
                    editarMiembro();
                    break;
                case 3:
                    eliminarMiembro();
                    break;
                case 4:
                    universidad.listarTodos();
                    break;
                case 5:
                    universidad.mostrarRoles();
                    break;
                case 6:
                    buscarPorRol();
                    break;
                case 7:
                    ordenarEstudiantes();
                    break;
                case 8:
                    buscarEstudiantePorApellido();
                    break;
                case 9:
                    agregarMateria();
                    break;
                case 10:
                    universidad.listarMaterias();
                    break;
                case 11:
                    asignarEstudianteAMateria();
                    break;
                case 12:
                    agregarCarrera();
                    break;
                case 13:
                    universidad.listarCarreras();
                    break;
                case 14:
                    asignarEstudianteACarrera();
                    break;
                case 15:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ===============================
    // MÉTODOS PRIVADOS DEL MENÚ
    // ===============================

    private void agregarMiembro() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Rol (Estudiante / Profesor / Administrativo): ");
        String rol = scanner.nextLine();

        universidad.agregarMiembro(nombre, apellido, rol);
        System.out.println("Miembro agregado correctamente.");
    }

    private void editarMiembro() {
        System.out.print("ID del miembro a editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo apellido: ");
        String apellido = scanner.nextLine();

        universidad.editarMiembro(id, nombre, apellido);
        System.out.println("Miembro editado correctamente.");
    }

    private void eliminarMiembro() {
        System.out.print("ID del miembro a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        universidad.eliminarMiembro(id);
        System.out.println("Miembro eliminado correctamente.");
    }

    private void buscarPorRol() {
        System.out.print("Rol a buscar (Estudiante / Profesor / Administrativo): ");
        String rol = scanner.nextLine();

        List<Miembro> lista = universidad.buscarPorRol(rol);
        lista.forEach(System.out::println);
    }

    private void ordenarEstudiantes() {
        System.out.println("Estudiantes ordenados por apellido:");
        universidad.ordenarEstudiantesPorApellido();
    }

    private void buscarEstudiantePorApellido() {
        System.out.print("Apellido a buscar: ");
        String apellido = scanner.nextLine();
        universidad.buscarEstudiantePorApellido(apellido);
    }

    private void agregarMateria() {
        System.out.print("Nombre de la materia: ");
        String nombre = scanner.nextLine();
        universidad.agregarMateria(nombre);
        System.out.println("Materia agregada correctamente.");
    }

    private void asignarEstudianteAMateria() {
        System.out.print("ID del estudiante: ");
        int idEst = Integer.parseInt(scanner.nextLine());

        System.out.print("ID de la materia: ");
        int idMat = Integer.parseInt(scanner.nextLine());

        universidad.asignarEstudianteAMateria(idEst, idMat);
        System.out.println("Estudiante asignado a la materia.");
    }

    private void agregarCarrera() {
        System.out.print("Nombre de la carrera: ");
        String nombre = scanner.nextLine();
        universidad.agregarCarrera(nombre);
        System.out.println("Carrera agregada correctamente.");
    }

    private void asignarEstudianteACarrera() {
        System.out.print("ID del estudiante: ");
        int idEst = Integer.parseInt(scanner.nextLine());

        System.out.print("ID de la carrera: ");
        int idCar = Integer.parseInt(scanner.nextLine());

        universidad.asignarEstudianteACarrera(idEst, idCar);
        System.out.println("Estudiante asignado a la carrera.");
    }
}
