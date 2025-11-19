import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // === Crear materias ===
        Materia matematicas = new Materia("Matemáticas");
        Materia fisica = new Materia("Física");

        // === Crear estudiante ===
        List<Materia> materiasEstudiante = new ArrayList<>();
        materiasEstudiante.add(matematicas);
        Estudiante estudiante = new Estudiante("Juan", "Pérez", "12345678", 20, "Ingeniería", 8.5, materiasEstudiante);

        // === Crear profesor ===
        List<Materia> materiasProfesor = new ArrayList<>();
        materiasProfesor.add(matematicas);
        Profesor profesor = new Profesor("Ana", "Gómez", "87654321", 45, "Matemáticas", 15, materiasProfesor);

        // === Crear personal ===
        Personal personal = new Personal("Carlos", "López", "11223344", 30, "Administración", "Secretario", "2020-01-15");

        // === Universidad ===
        Universidad universidad = new Universidad();
        universidad.agregarMiembro(estudiante);
        universidad.agregarMiembro(profesor);
        universidad.agregarMiembro(personal);

        System.out.println("=== Procesando todos los miembros (polimorfismo) ===");
        for (MiembroUniversidad miembro : universidad.getMiembros()) {  
            System.out.println("Rol: " + miembro.obtenerRol());
            System.out.println("Información: " + miembro.obtenerInformacionCompleta());
            System.out.println("---");
        }

        universidad.listarTodos();

        System.out.println("\n=== Buscando profesores ===");
        List<MiembroUniversidad> profesores = universidad.buscarPorRol("Profesor");
        for (MiembroUniversidad p : profesores) {
            System.out.println(p.obtenerInformacionCompleta());
        }

        universidad.mostrarRoles();


        // === Crear otros 3 estudiantes y agregarlos a la universidad ===
        Estudiante e1 = new Estudiante("Juan", "Zuluaga", "123", 20, "Ingeniería", 8.5, new ArrayList<>());
        Estudiante e2 = new Estudiante("Ana", "Pérez", "456", 22, "Medicina", 9.0, new ArrayList<>());
        Estudiante e3 = new Estudiante("Carlos", "Gómez", "789", 21, "Derecho", 7.5, new ArrayList<>());

        universidad.agregarMiembro(e1);
        universidad.agregarMiembro(e2);
        universidad.agregarMiembro(e3);

        // === Ordenar estudiantes por apellido usando la lógica interna de Universidad ===
        System.out.println("\n=== Estudiantes ordenados por apellido ===");

        List<Estudiante> ordenados = universidad.ordenarEstudiantesPorApellido();

        for (Estudiante e : ordenados) {
            System.out.println(e.getApellido() + ", " + e.getNombre());
        }
    }
}
