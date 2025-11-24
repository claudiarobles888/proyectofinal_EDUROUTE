import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PlataformaEduRoute {

    // Gestores de lógica
    private GestionEstudiantes gestorEst;
    private GestionParadas gestorPar;
    private GestionRutas gestorRut;
    private GestionAsignacion gestorAsign;

    // Componentes del formulario (vienen del .form)
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtIdEstudiante;
    private JTextField txtNombreEstudiante;
    private JTextField txtCurso;
    private JTextField txtDireccion;
    private JComboBox<String> cbPrioridad;
    private JButton btnIngresarEst;
    private JTable table1;
    private JTextArea txtAEstudiantes;

    public PlataformaEduRoute() {
        inicializarGestores();
        configurarEventos();
        inicializarPrioridadesSiHaceFalta();
        actualizarAreaEstudiantes(); // por si luego precargas datos
    }

    /**
     * Crea las instancias de los gestores.
     */
    private void inicializarGestores() {
        gestorEst = new GestionEstudiantes();
        gestorPar = new GestionParadas();
        gestorRut = new GestionRutas();
        // GestionAsignacion recibe los gestores por constructor
        gestorAsign = new GestionAsignacion(gestorEst, gestorPar, gestorRut);
    }

    /**
     * Registra listeners de botones y demás eventos.
     */
    private void configurarEventos() {
        btnIngresarEst.addActionListener(this::accionRegistrarEstudiante);
    }

    /**
     * Si el combo de prioridad está vacío en diseño,
     * aquí le cargamos valores por defecto.
     */
    private void inicializarPrioridadesSiHaceFalta() {
        if (cbPrioridad.getItemCount() == 0) {
            cbPrioridad.addItem("Alta");
            cbPrioridad.addItem("Media");
            cbPrioridad.addItem("Baja");
        }
    }

    /**
     * Acción ejecutada al presionar "Ingresar Estudiante".
     */
    private void accionRegistrarEstudiante(ActionEvent e) {
        String idEst = txtIdEstudiante.getText().trim();
        String nombre = txtNombreEstudiante.getText().trim();
        String curso = txtCurso.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String prioridad = (cbPrioridad.getSelectedItem() != null)
                ? cbPrioridad.getSelectedItem().toString()
                : "";

        // Validar campos vacíos
        if (idEst.isEmpty() || nombre.isEmpty() || curso.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(
                    Ventana,
                    "Complete todos los campos antes de registrar.",
                    "Campos incompletos",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Validar ID duplicado
        if (gestorEst.buscarPorId(idEst) != null) {
            JOptionPane.showMessageDialog(
                    Ventana,
                    "Ya existe un estudiante con ese ID.",
                    "ID duplicado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Crear objeto Estudiante
        Estudiante est = new Estudiante(idEst, nombre, curso, direccion, prioridad);

        // Registrar en la lista del gestor
        boolean registrado = gestorEst.registrarEstudiante(est);

        if (registrado) {
            JOptionPane.showMessageDialog(
                    Ventana,
                    "Estudiante registrado exitosamente."
            );

            limpiarFormulario();
            actualizarAreaEstudiantes();

        } else {
            JOptionPane.showMessageDialog(
                    Ventana,
                    "Ocurrió un error al registrar el estudiante.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void limpiarFormulario() {
        txtIdEstudiante.setText("");
        txtNombreEstudiante.setText("");
        txtCurso.setText("");
        txtDireccion.setText("");
        if (cbPrioridad.getItemCount() > 0) {
            cbPrioridad.setSelectedIndex(0);
        }
        txtIdEstudiante.requestFocus();
    }

    private void actualizarAreaEstudiantes() {
        if (txtAEstudiantes == null) return;

        StringBuilder sb = new StringBuilder();
        List<Estudiante> lista = gestorEst.listarEstudiante();

        if (lista.isEmpty()) {
            sb.append("No hay estudiantes registrados aún.");
        } else {
            sb.append("Estudiantes registrados:\n");
            sb.append("-------------------------\n");
            for (Estudiante e : lista) {
                sb.append("ID: ").append(e.getIdEst()).append("\n");
                sb.append("Nombre: ").append(e.getNombre()).append("\n");
                sb.append("Curso: ").append(e.getCurso()).append("\n");
                sb.append("Dirección: ").append(e.getDireccion()).append("\n");
                sb.append("Prioridad: ").append(e.getPrioridad()).append("\n");
                sb.append("-------------------------\n");
            }
        }

        txtAEstudiantes.setText(sb.toString());
        txtAEstudiantes.setCaretPosition(0); // subir al inicio
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("PlataformaEduRoute");
            frame.setContentPane(new PlataformaEduRoute().Ventana);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null); // centrar
            frame.setVisible(true);
        });
    }
}
