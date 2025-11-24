import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionEstudiantes {
    private List<Estudiante> estudiantes;

    public GestionEstudiantes(){
        this.estudiantes = new ArrayList<>();
    }

    public boolean registrarEstudiantes(Estudiante e){
        if (buscarPorId(e.getIdEst()) != null){
            return false;
        }
        return true;
    }

    public Estudiante buscarPorId(String id){
        return estudiantes.stream().filter(s -> s.getIdEst().equals(id)).findFirst().orElse(null);
    }

    public boolean actualizarEstudiante(String id, String nuevoNombre, String nuevoCurso, String nuevaDireccion, String prioridad){
        Estudiante e = buscarPorId(id);
        if (e != null){
            e.setNombre(nuevoNombre);
            e.setCurso(nuevoCurso);
            e.setDireccion(nuevaDireccion);
            e.setPrioridad(prioridad);
            return true;
        }
        return false;
    }

    public boolean asignarRuta(String idEst, String numRuta){
        Estudiante e = buscarPorId(idEst);
        if(e != null){
            e.setNumeroRuta(numRuta);
            return true;
        }
        return false;
    }

   public boolean eliminarEstudiante(String id){
        return estudiantes.removeIf(e -> e.getIdEst().equals(id));
   }

   public List<Estudiante> listarEstudiante(){
        return new ArrayList<>(estudiantes);
   }

    public List<Estudiante> filtrarPorPrioridad(String prioridad){
        return estudiantes.stream()
                .filter(e -> e.getPrioridad() != null && e.getPrioridad().equals(prioridad))
                .collect(Collectors.toList());
    }

    public List<Estudiante> listarPorRuta(String numeroRuta){
        return estudiantes.stream().filter(e -> numeroRuta.equals(e.getNumeroRuta())).collect(Collectors.toList());
    }

}