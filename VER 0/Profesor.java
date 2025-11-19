import java.util.List;

public class Profesor extends Persona implements MiembroUniversidad{
   private String especialidad;
   private int aniosExperiencia;
   private List<Materia> materiasAsignadas;

public Profesor (String nombre,String apellido,String documento,int edad,String especialidad,int aniosExperiencia,List<Materia> materiasAsignadas){
 super(nombre,apellido,documento,edad);
 this.especialidad=especialidad;
 this.aniosExperiencia=aniosExperiencia;
 this.materiasAsignadas=materiasAsignadas;
}

public String getEspecialidad(){
  return especialidad;  
}

public void setEspecialidad(){
  this.especialidad=especialidad;  
}

public void setAniosExperiencia(int aniosExperiencia){
  this.aniosExperiencia=aniosExperiencia;
}

public List<Materia> getMateriasAsignadas(){
  return materiasAsignadas;
}

public void setMateriasAsignadas(){
  this.materiasAsignadas=materiasAsignadas;  
}

public void asignarMateria(Materia materia) {
        if (materiasAsignadas != null && !materiasAsignadas.contains(materia)) {
            materiasAsignadas.add(materia);
            materia.setProfesor(this);  
        }
    }

     @Override
    public String obtenerRol() {
        return "Profesor";
    }
    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
public String toString() {
    return "Profesor {\n" +
           "  Nombre: " + getNombre() + " " + getApellido() + "\n" +
           "  Documento: " + getDocumento() + "\n" +
           "  Edad: " + getEdad() + "\n" +
           "  Especialidad: " + especialidad + "\n" +
           "  Años de experiencia: " + aniosExperiencia + "\n" +
           "}";
}

    
}
