import java.util.ArrayList;
import java.util.List;

public class GestionParadas {
    private List<Parada> paradas;

    public GestionParadas(){
        this.paradas = new ArrayList<>();
    }

    public void registrarParada(Parada p){
        paradas.add(p);
    }

    public Parada buscarPorId(String id){
        return paradas.stream()
                .filter(p -> p.getIdParada().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Parada buscarPorNombre(String nombre){
        return paradas.stream().filter(p -> p.getNombreParada().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public boolean eliminarParada(String idParada){
        Parada p = buscarPorId(idParada);
        if(p != null && p.listarEstudiantes().isEmpty()){
            paradas.remove(p);
            return true;
        }
        return false;
    }

    public List<Parada> listar(){
        return new ArrayList<>(paradas);
    }
}
