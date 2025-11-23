import java.util.ArrayList;
import java.util.List;

public class Ruta {
private String idRuta;
private String nombreRuta;
private String numeroRuta;
private List<Parada> paradas;

    public Ruta(String idRuta, String nombreRuta, String numeroRuta) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.numeroRuta = numeroRuta;
        this.paradas = new ArrayList<>();
    }

    public void agregarParada (Parada p){
        paradas.add(p);
    }

    public void eliminarParada(String idParada){
        paradas.removeIf(p -> p.getIdParada().equals(idParada));
    }

    public List<Parada> listarParadas(){
        return paradas;
    }

    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> result = new ArrayList<>();
        for (Parada p :paradas){
            result.addAll(p.listarEstudiantes());
        }
        return result;
    }

    public int calcularTiempoTotal(){
        return paradas.stream().mapToInt(p -> p.obtenerTiempoEstimado()).sum();
    }

}
