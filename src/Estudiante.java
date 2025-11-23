public class Estudiante {
    private String idEst;
    private String nombre;
    private String curso;
    private String direccion;
    private String prioridad;
    private Parada paradaAsignada;
    private boolean ausente;

    public Estudiante(String idEst, String nombre, String curso, String direccion, String prioridad) {
        this.idEst = idEst;
        this.nombre = nombre;
        this.curso = curso;
        this.direccion = direccion;
        this.prioridad = prioridad;
        this.ausente = false;
    }

    public void asignarParada(Parada parada){
        this.paradaAsignada = parada;
    }

    public Parada obtenerParada(){
        return paradaAsignada;
    }

    public void marcarAusente(){
        this.ausente = true;
    }

    public String getIdEst() {
        return idEst;
    }

    public void setId(String idEst) {
        this.idEst = idEst;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isAusente() {
        return ausente;
    }

    @Override
    public String toString() {
        return "Estudiante" +
                "\nid=" + idEst +
                "\nnombre=" + nombre +
                "\ncurso=" + curso +
                "\ndireccion=" + direccion +
                "\nprioridad=" + prioridad;
    }
}
