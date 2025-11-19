import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private String codigo;
    private List<Materia> materias;
    private List<Estudiante> estudiantesInscritos;

    public Carrera(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.materias = new ArrayList<>();
        this.estudiantesInscritos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public List<Materia> getMaterias() { return materias; }
    public List<Estudiante> getEstudiantesInscritos() { return estudiantesInscritos; }

    public void agregarMateria(Materia materia) {
        if (!materias.contains(materia)) {
            materias.add(materia);
        }
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (!estudiantesInscritos.contains(estudiante)) {
            estudiantesInscritos.add(estudiante);
        }
    }

    public void desinscribirEstudiante(Estudiante estudiante) {
        estudiantesInscritos.remove(estudiante);
    }

    public String obtenerInformacionCompleta() {
        return "Carrera: " + nombre + " (Código: " + codigo + ") - Materias: " + materias.size() + ", Estudiantes: " + estudiantesInscritos.size();
    }

    public void listarMaterias() {
        System.out.println("Materias en " + nombre + ":");
        for (Materia m : materias) {
            System.out.println("- " + m.obtenerInformacionCompleta());
        }
    }

    public void listarEstudiantes() {
        System.out.println("Estudiantes inscritos en " + nombre + ":");
        for (Estudiante e : estudiantesInscritos) {
            System.out.println("- " + e.obtenerInformacionCompleta());
        }
    }
}