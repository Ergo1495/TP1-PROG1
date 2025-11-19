public class Profesor extends Persona {
    public Profesor(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
    }

    @Override
    public String obtenerRol() {
        return "Profesor";
    }
}