package com.vista;

import com.modelo.Musica;
import com.toedter.calendar.JDateChooser;
import com.utilidades.Utilidades;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestionMusica {

    private JTextField txttitulo;
    private JTextField txtartista;
    private JTextField txtalbum;
    private JDateChooser jDateChooseraño;
    private JComboBox ComboBoxgenero;
    private JDateChooser jDateFechaNacimiento;
    private Utilidades utilidades;
    private JFrame frameGestionMusica;

    public GestionMusica(JTextField txttitulo, JTextField txtartista, JTextField txtalbum, JDateChooser jDateChooseraño, JComboBox ComboBoxgenero, JDateChooser jDateFechaNacimiento, Utilidades utilidades, JFrame frameGestionMusica) {
        this.txttitulo = txttitulo;
        this.txtartista = txtartista;
        this.txtalbum = txtalbum;
        this.jDateChooseraño = jDateChooseraño;
        this.ComboBoxgenero = ComboBoxgenero;
        this.jDateFechaNacimiento = jDateFechaNacimiento;
        this.utilidades = utilidades;
        this.frameGestionMusica = frameGestionMusica;
    }

    public JTextField getTxttitulo() {
        return txttitulo;
    }

    public void setTxttitulo(JTextField txttitulo) {
        this.txttitulo = txttitulo;
    }

    public JTextField getTxtartista() {
        return txtartista;
    }

    public void setTxtartista(JTextField txtartista) {
        this.txtartista = txtartista;
    }

    public JTextField getTxtalbum() {
        return txtalbum;
    }

    public void setTxtalbum(JTextField txtalbum) {
        this.txtalbum = txtalbum;
    }

    public JDateChooser getjDateChooseraño() {
        return jDateChooseraño;
    }

    public void setjDateChooseraño(JDateChooser jDateChooseraño) {
        this.jDateChooseraño = jDateChooseraño;
    }

    public JComboBox getComboBoxgenero() {
        return ComboBoxgenero;
    }

    public void setComboBoxgenero(JComboBox ComboBoxgenero) {
        this.ComboBoxgenero = ComboBoxgenero;
    }

    public JDateChooser getjDateFechaNacimiento() {
        return jDateFechaNacimiento;
    }

    public void setjDateFechaNacimiento(JDateChooser jDateFechaNacimiento) {
        this.jDateFechaNacimiento = jDateFechaNacimiento;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameGestionMusica() {
        return frameGestionMusica;
    }

    public void setFrameGestionMusica(JFrame frameGestionMusica) {
        this.frameGestionMusica = frameGestionMusica;
    }
    
    public void limpiarCamposMusica() {
        txttitulo.setText("");
        txtartista.setText("");
        txtalbum.setText("");
        jDateChooseraño.setDate(null);;
        ComboBoxgenero.setSelectedIndex(0);
    }

    public Musica guardarEditar(boolean isEditar) {
        if (txttitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionMusica, "El campo Título no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txttitulo.requestFocus();// Sirve para ubicar el cursor en un campo vacio.
            return null;
        }
        if (txtartista.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionMusica, "El campo Artista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtartista.requestFocus();
            return null;
        }
        if (txtalbum.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionMusica, "El campo album no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtalbum.requestFocus();
            return null;
        }


        
        Musica cancion = new Musica();
        cancion.setTitulo(txttitulo.getText());
        cancion.setArtista(txtartista.getText());
        cancion.setAlbum(txtalbum.getText());
        cancion.setAño_creacion(jDateChooseraño.getDate());
        cancion.setGenero(String.valueOf(ComboBoxgenero.getSelectedItem()));
        cancion.setFecha_registro(new Date());
        return cancion;
    }

}
