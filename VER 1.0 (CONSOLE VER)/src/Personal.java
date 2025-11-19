public class Personal extends Persona {
    public Personal(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
    }

    @Override
    public String obtenerRol() {
        return "Personal";
    }
}