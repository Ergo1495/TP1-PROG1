import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Universidad {
    private List<MiembroUniversidad> miembros;

    public Universidad() {
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        miembros.add(miembro);
    }

    public List<MiembroUniversidad> getMiembros() {
        return miembros;
    }

    public void listarTodos() {
        System.out.println("Lista de todos los miembros:");
        for (MiembroUniversidad miembro : miembros) {
            System.out.println(miembro.obtenerInformacionCompleta());
        }
    }

    public void mostrarRoles() {
        System.out.println("Roles en la universidad:");
        for (MiembroUniversidad miembro : miembros) {
            System.out.println("- " + miembro.obtenerRol());
        }
    }

    public List<MiembroUniversidad> buscarPorRol(String rol) {
        List<MiembroUniversidad> resultado = new ArrayList<>();
        for (MiembroUniversidad miembro : miembros) {
            if (miembro.obtenerRol().equalsIgnoreCase(rol)) {
                resultado.add(miembro);
            }
        }
        return resultado;
    }

    public List<Estudiante> ordenarEstudiantesPorApellido() {
        List<Estudiante> estudiantes = new ArrayList<>();
        for (MiembroUniversidad m : miembros) {
            if (m instanceof Estudiante) {
                estudiantes.add((Estudiante) m);
            }
        }
        Estudiante[] arr = estudiantes.toArray(new Estudiante[0]);
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            
           
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getApellido().compareTo(arr[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            
          
            if (indiceMinimo != i) {
                Estudiante temp = arr[i];
                arr[i] = arr[indiceMinimo];
                arr[indiceMinimo] = temp;
            }
        }
        
      
        estudiantes = Arrays.asList(arr);
        return new ArrayList<>(estudiantes);
    }

    
    public Estudiante buscarEstudiantePorApellido(String apellido) {
        List<Estudiante> ordenados = ordenarEstudiantesPorApellido();
        int low = 0;
        int high = ordenados.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = ordenados.get(mid).getApellido().compareTo(apellido);
            if (cmp == 0) {
                return ordenados.get(mid);
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; 
    }


    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
      
        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
        
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = estudiantes[mid].getApellido().compareTo(apellido);
            if (cmp == 0) {
                return mid; 
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }
}
