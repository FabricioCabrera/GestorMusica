package com.modelTabla;

import com.modelo.Musica;
import com.vista.RegistrodeMusica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Faby
 */
public class ModelTableMusica extends AbstractTableModel {

    //Arreglo con el nombre de las columnas
    public String[] m_colNames = {"Título", "Autor", "Artista", 
        " Álbum", "Año de lanzamiento", "Género Musical"};

    public List<Musica> musica;
    private RegistrodeMusica gcontableMusica;

    public ModelTableMusica(List<Musica> musica, RegistrodeMusica gcontableMusica) {
        this.musica = musica;
        this.gcontableMusica = gcontableMusica;
    }

    //Determina el número de filas que tengo en mi tabla
    @Override
    public int getRowCount() {
        return musica.size();
    }

    //Determina el número de columnas que tengo en mi tabla
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Musica canción = musica.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return canción.getTitulo();
            case 1:
                return canción.getAutor();
            case 2:
                return canción.getArtista();
            case 3:
                return canción.getAlbum();
            case 4:
                return canción.getAño_creacion();
            case 5:
                return canción.getGenero();
        }
        return new String();
    }
    //Sirve para definir los nombres de las columnas
    @Override
    public String getColumnName(int column) {
        return m_colNames[column];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gcontableMusica.clickMusica(musica.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Musica> getMusica() {
        return musica;
    }
    public void setMusica(List<Musica> musica) {
        this.musica = musica;
    }
}
