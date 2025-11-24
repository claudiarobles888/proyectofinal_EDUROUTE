import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Recorrido {
    private String idRecorrido;
    private LocalDate fecha;
    private String zona;
    private String estado;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Ruta ruta;

    public Recorrido(String idRecorrido, LocalDate fecha, String zona, Ruta ruta) {
        this.idRecorrido = idRecorrido;
        this.fecha = fecha;
        this.zona = zona;
        this.ruta = ruta;
        this.estado = "Pendiente";
    }

    public void inicio(){
        this.horaInicio = LocalTime.now();
        this.estado = "En curso";
    }

    public void finalizar(){
        this.horaFin = LocalTime.now();
        this.estado = "Finalizado";
    }

    public void registrarSubida(Estudiante e){
        System.out.println("Sube: " +e.getNombre());
    }

    public void registrarBajada(Estudiante e){
        System.out.println("Baja: " +e.getNombre());
    }

    public void replanificarAusencia (List<Estudiante> estudiantes){
        System.out.println("Replanificando recorrido");
    }
}

