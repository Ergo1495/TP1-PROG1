import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private String codigo;
    private List<Estudiante> estudiantesInscritos;

    public Materia(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estudiantesInscritos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public List<Estudiante> getEstudiantesInscritos() { return estudiantesInscritos; }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (!estudiantesInscritos.contains(estudiante)) {
            estudiantesInscritos.add(estudiante);
        }
    }

    public void desinscribirEstudiante(Estudiante estudiante) {
        estudiantesInscritos.remove(estudiante);
    }

    public String obtenerInformacionCompleta() {
        return "Materia: " + nombre + " (Código: " + codigo + ") - Estudiantes inscritos: " + estudiantesInscritos.size();
    }

    public void listarEstudiantes() {
        System.out.println("Estudiantes inscritos en " + nombre + ":");
        for (Estudiante e : estudiantesInscritos) {
            System.out.println("- " + e.obtenerInformacionCompleta());
        }
    }
}