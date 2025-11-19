import java.util.List;
public class Estudiante extends Persona implements MiembroUniversidad{
  private String carrera;
  private double promedio;
  private List<Materia>materias;  

   public Estudiante (String nombre,String apellido,String documento,int edad,String carrera,double promedio,List<Materia> materias){
    super (nombre,apellido,documento,edad);
    this.carrera=carrera;
    this.promedio=promedio;
    this.materias=materias;
   }

   public String getCarrera(){
     return carrera;
   }

  public void setCarrera (String carrera){
    this.carrera=carrera;
  }

  public double getPromedio(){
   return promedio; 
  }
 
  public List<Materia> getMaterias(){
    return materias;
  }
public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    @Override
    public String obtenerRol() {
        return "Estudiante";
    }
    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
    public String toString() {
    
        String nombresMaterias = materias.stream()
                                         .map(Materia::getNombre)
                                         .reduce((a, b) -> a + ", " + b)
                                         .orElse("Sin materias");
    
        return "Estudiante {\n" +
               "  Nombre: " + getNombre() + " " + getApellido() + "\n" +
               "  Documento: " + getDocumento() + "\n" +
               "  Edad: " + getEdad() + "\n" +
               "  Carrera: " + carrera + "\n" +
               "  Promedio: " + promedio + "\n" +
               "  Materia: [" + nombresMaterias + "]\n" +
               "}";
    }
    
    
}
