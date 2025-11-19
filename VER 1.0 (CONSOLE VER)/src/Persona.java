public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String id;

    public Persona(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public abstract String obtenerRol();

    public String obtenerInformacionCompleta() {
        return obtenerRol() + ": " + nombre + " " + apellido + " (ID: " + id + ")";
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}