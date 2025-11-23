import java.util.ArrayList;
import java.util.List;

public class Parada {
private String idParada;
private String nombreParada;
private int tiempoEstimado;
private String ubicacion;
private List<Estudiante> estudiantes;

    public Parada(String idParada, String nombreParada, int tiempoEstimado, String ubicacion) {
        this.idParada = idParada;
        this.nombreParada = nombreParada;
        this.tiempoEstimado = tiempoEstimado;
        this.ubicacion = ubicacion;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e){
        estudiantes.add(e);
        e.asignarParada(this);
    }

    public void eliminarEstudiante(String idEstudiante){
        estudiantes.removeIf(e -> e.getId().equals(idEstudiante));
    }

    public List<Estudiante> listarEstudiantes(){
        return estudiantes;
    }

    public int obtenerTiempoEstimado(){
        return tiempoEstimado;
    }

    public String getIdParada() {
        return idParada;
    }

    public void setIdParada(String idParada) {
        this.idParada = idParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    public void setNombreParada(String nombreParada) {
        this.nombreParada = nombreParada;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}