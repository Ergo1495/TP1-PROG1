import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Clase Universidad para manejar la lista de personas, materias y carreras
public class Universidad {
    private List<Persona> miembros;
    private List<Materia> materias;
    private List<Carrera> carreras;

    public Universidad() {
        this.miembros = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    public void agregarMiembro(Persona miembro) {
        miembros.add(miembro);
    }

    public List<Persona> getMiembros() {
        return miembros;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void listarTodos() {
        System.out.println("Lista de todos los miembros:");
        for (int i = 0; i < miembros.size(); i++) {
            System.out.println((i + 1) + ". " + miembros.get(i).obtenerInformacionCompleta());
        }
    }

    public void listarMaterias() {
        System.out.println("Lista de todas las materias:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).obtenerInformacionCompleta());
        }
    }

    public void listarCarreras() {
        System.out.println("Lista de todas las carreras:");
        for (int i = 0; i < carreras.size(); i++) {
            System.out.println((i + 1) + ". " + carreras.get(i).obtenerInformacionCompleta());
        }
    }

    public void mostrarRoles() {
        System.out.println("Roles en la universidad:");
        for (Persona miembro : miembros) {
            System.out.println("- " + miembro.obtenerRol());
        }
    }

    public List<Persona> buscarPorRol(String rol) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona miembro : miembros) {
            if (miembro.obtenerRol().equalsIgnoreCase(rol)) {
                resultado.add(miembro);
            }
        }
        return resultado;
    }

    // Método para ordenar estudiantes por apellido (usando Selection Sort iterativo)
    public List<Estudiante> ordenarEstudiantesPorApellido() {
        List<Estudiante> estudiantes = new ArrayList<>();
        for (Persona m : miembros) {
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

    // Método para buscar un estudiante por apellido (usando búsqueda binaria iterativa después de ordenar)
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
        return null; // No encontrado
    }

    // Método estático para búsqueda binaria de estudiantes por apellido (iterativa)
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

    // Método estático para ordenar estudiantes por apellido usando Selection Sort recursivo
    public static void selectionSortRecursivo(Estudiante[] estudiantes, int n, int indice) {
        if (indice >= n - 1) {
            return;
        }
        int indiceMinimo = indice;
        for (int j = indice + 1; j < n; j++) {
            if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                indiceMinimo = j;
            }
        }
        if (indiceMinimo != indice) {
            Estudiante temp = estudiantes[indice];
            estudiantes[indice] = estudiantes[indiceMinimo];
            estudiantes[indiceMinimo] = temp;
        }
        selectionSortRecursivo(estudiantes, n, indice + 1);
    }

    // Método estático para búsqueda binaria recursiva de estudiantes por apellido
    public static int busquedaBinariaRecursiva(Estudiante[] estudiantes, String apellido, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int cmp = estudiantes[mid].getApellido().compareTo(apellido);
        if (cmp == 0) {
            return mid;
        } else if (cmp < 0) {
            return busquedaBinariaRecursiva(estudiantes, apellido, mid + 1, high);
        } else {
            return busquedaBinariaRecursiva(estudiantes, apellido, low, mid - 1);
        }
    }

    // Método auxiliar para usar búsqueda binaria recursiva (primero ordena el array)
    public static int buscarEstudianteRecursivo(Estudiante[] estudiantes, String apellido) {
        selectionSortRecursivo(estudiantes, estudiantes.length, 0);
        return busquedaBinariaRecursiva(estudiantes, apellido, 0, estudiantes.length - 1);
    }

    // Método para editar un miembro (por índice)
    public void editarMiembro(int indice, String nuevoNombre, String nuevoApellido, String nuevoId) {
        if (indice >= 0 && indice < miembros.size()) {
            Persona miembro = miembros.get(indice);
            miembro.setNombre(nuevoNombre);
            miembro.setApellido(nuevoApellido);
            miembro.setId(nuevoId);
            System.out.println("Miembro editado exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para eliminar un miembro (por índice)
    public void eliminarMiembro(int indice) {
        if (indice >= 0 && indice < miembros.size()) {
            miembros.remove(indice);
            System.out.println("Miembro eliminado exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para asignar un estudiante a una materia
    public void asignarEstudianteAMateria(int indiceEstudiante, int indiceMateria) {
        if (indiceEstudiante >= 0 && indiceEstudiante < miembros.size() && indiceMateria >= 0 && indiceMateria < materias.size()) {
            Persona p = miembros.get(indiceEstudiante);
            if (p instanceof Estudiante) {
                Materia m = materias.get(indiceMateria);
                m.inscribirEstudiante((Estudiante) p);
                System.out.println("Estudiante asignado a la materia.");
            } else {
                System.out.println("El índice no corresponde a un estudiante.");
            }
        } else {
            System.out.println("Índices inválidos.");
        }
    }

    // Método para asignar un estudiante a una carrera
    public void asignarEstudianteACarrera(int indiceEstudiante, int indiceCarrera) {
        if (indiceEstudiante >= 0 && indiceEstudiante < miembros.size() && indiceCarrera >= 0 && indiceCarrera < carreras.size()) {
            Persona p = miembros.get(indiceEstudiante);
            if (p instanceof Estudiante) {
                Carrera c = carreras.get(indiceCarrera);
                c.inscribirEstudiante((Estudiante) p);
                System.out.println("Estudiante asignado a la carrera.");
            } else {
                System.out.println("El índice no corresponde a un estudiante.");
            }
        } else {
            System.out.println("Índices inválidos.");
        }
    }
}