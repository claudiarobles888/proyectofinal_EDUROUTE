import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String idBus;
    private String placa;
    private int estado;
    private int capacidad;
    private List<Conductor> conductores;

    public Bus(String idBus, String placa, int capacidad) {
        this.idBus = idBus;
        this.placa = placa;
        this.estado = 1;
        this.capacidad = capacidad;
        this.conductores = new ArrayList<>();
    }

    public void asignarConductor(Conductor conductor){
        if (conductores.size() < 2){
            conductores.add(conductor);
        }
    }

    public List<Conductor> listarConductores(){
        return conductores;
    }

    public boolean estadoDisponible(){
        return estado == 1;
    }

    public String getIdBus() {
        return idBus;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidad() {
        return capacidad;
    }
}