import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlataformaEduRoute {
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtIdEstudiante;
    private JTextField txtNombreEstudiante;
    private JTextField txtCurso;
    private JComboBox cbDireccion;
    private JComboBox cbPrioridad;
    private JButton btnIngresarEst;
    private JComboBox cbParada;

    public PlataformaEduRoute() {
        btnIngresarEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idEst = txtIdEstudiante.getText();
                String nombre = txtNombreEstudiante.getText();
                String curso = txtCurso.getText();
                String direccion = cbDireccion.getSelectedItem().toString();
                String prioridad = cbPrioridad.getSelectedItem().toString();
                String paradaAsignada = cbParada.getSelectedItem().toString();
            }
        });
    }
}
