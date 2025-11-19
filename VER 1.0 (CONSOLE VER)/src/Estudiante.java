public class Estudiante extends Persona {
    public Estudiante(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }
}