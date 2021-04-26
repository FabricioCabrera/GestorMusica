package com.controlador;

import com.modelo.Musica;
import com.utilidades.Utilidades;
import java.sql.Connection;
import com.conexion.Conexionbase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faby
 */
public class Musicabd {

    public Utilidades utilidades;

    public Musicabd() {
        utilidades = new Utilidades();
    }

    //Creamos el método para ingresar un registro de música
    public boolean CrearRegistroM(Musica cancion) {
        Statement stm = null;
        Connection con = null;
        String sql;
        if (cancion.getFecha_registro() == null) {
            sql = "INSERT INTO registromusica (idregistromusica, titulo, artista, "
                    + "album, año_creacion, genero, fecha_registro, autor ) "
                    + "VALUES ('" + String.valueOf(cancion.getIdregistromusica()) + "','"
                    + "" + cancion.getTitulo() + "', '"
                    + "" + cancion.getArtista() + "', '"
                    + "" + cancion.getAlbum() + "', '"
                    + "" + utilidades.devolverFecha(cancion.getAño_creacion()) + "', '"
                    + "" + cancion.getGenero() + "', '"
                    + "" + cancion.getAutor() + "')";

        } else {
            sql = "INSERT INTO registromusica (idregistromusica, titulo, artista, "
                    + "album, año_creacion, genero, fecha_registro, autor ) "
                    + "VALUES ('" + String.valueOf(cancion.getIdregistromusica()) + "','"
                    + "" + cancion.getTitulo() + "', '"
                    + "" + cancion.getArtista() + "', '"
                    + "" + cancion.getAlbum() + "', '"
                    + "" + utilidades.devolverFecha(cancion.getAño_creacion()) + "', '"
                    + "" + cancion.getGenero() + "', '"
                    + "" + utilidades.devolverFecha(cancion.getFecha_registro()) + "', '"
                    + "" + cancion.getAutor() + "')";
        }
        try {
            Conexionbase co = new Conexionbase();
            con = co.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            stm.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getLocalizedMessage());
        }
        return false;
    }

    //Creamos el método para eliminar un registro de música
    public boolean EliminarMusica(Musica eliminar) {
        Statement stm = null;
        Connection con = null;

        String sql = "delete from registromusica where idregistromusica= "
                + "" + eliminar.getIdregistromusica();
        try {
            Conexionbase co = new Conexionbase();
            con = co.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            stm.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getLocalizedMessage());
        }
        return false;
    }

    //Creamos el método para editar un registro de música
    public boolean EditarMusica(Musica edita) {
        Statement stm = null;
        Connection con = null;
        if (edita.getFecha_registro() == null) {
            String sql = "UPDATE registromusica SET titulo='" + edita.getTitulo() + ""
                    + "', artista='" + edita.getArtista() + "', album='" + edita.getAlbum() + ""
                    + "', año_creacion='" + utilidades.devolverFecha(edita.getAño_creacion()) + ""
                    + "', genero= '" + edita.getGenero() + "', autor= '" + edita.getAutor() + ""
                    + "'  WHERE (idregistromusica=" + edita.getIdregistromusica() + ")";

        } else {
            String sql = "UPDATE registromusica SET titulo='" + edita.getTitulo() + ""
                    + "', artista='" + edita.getArtista() + "', album='" + edita.getAlbum() + ""
                    + "', año_creacion='" + utilidades.devolverFecha(edita.getAño_creacion()) + ""
                    + "', genero= '" + edita.getGenero() + ""
                    + "', fecha_registro= '" + utilidades.devolverFecha(edita.getFecha_registro()) + ""
                    + "', autor= '" + edita.getAutor() + ""
                    + "'  WHERE (idregistromusica=" + edita.getIdregistromusica() + ")";
            try {
                Conexionbase co = new Conexionbase();
                con = co.Conectar();
                stm = con.createStatement();
                stm.execute(sql);
                stm.close();
                con.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error de clase editar" + ex.getLocalizedMessage());
            }
            return false;
        }
        return true;
    }

    //Sirve para traer todos los registros de música de la base de datos 
    public List<Musica> ObtenerRegistroM() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM registromusica";
        List<Musica> listaMusica = new ArrayList<>();
        try {
            co = new Conexionbase().Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Musica c = new Musica();
                c.setIdregistromusica(rs.getInt("idregistromusica"));
                c.setTitulo(rs.getString("titulo"));
                c.setArtista(rs.getString("artista"));
                c.setAlbum(rs.getString("album"));
                c.setAño_creacion(rs.getDate("año_creacion"));
                c.setGenero(rs.getString("genero"));
                c.setFecha_registro(rs.getDate("fecha_registro"));
                c.setAutor(rs.getString("autor"));
                listaMusica.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaMusica;
    }

    public List<Musica> ObtenerMusicaSql(String subSql) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;

        // String sql = "SELECT * FROM registromusica where  idregistromusica=" + subSql;
        String sql = "SELECT * FROM registromusica  where " + subSql;
        List<Musica> listaMusica = new ArrayList<>();
        try {
            co = new Conexionbase().Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Musica c = new Musica();
                c.setIdregistromusica(rs.getInt("idregistromusica"));
                c.setTitulo(rs.getString("titulo"));
                c.setArtista(rs.getString("artista"));
                c.setAlbum(rs.getString("album"));
                c.setAño_creacion(rs.getDate("año_creacion"));
                c.setGenero(rs.getString("genero"));
                c.setFecha_registro(rs.getDate("fecha_registro"));
                c.setAutor(rs.getString("autor"));
                listaMusica.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                System.out.println(stackTrace);
            }
        }
        return listaMusica;
    }

    //Metodo para buscar una canción por alguno de sus atributos
    public Musica buscarCancion(String cod) {
        //conexión con la base de datos
        Connection con = null;
        //Interfáz de acceso a la base de datos
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de las base de datos
        ResultSet rs = null;
        Musica cancion = null;
        String sql = "SELECT * FROM registromusica where titulo ='" + cod + "';";
        try {
            Conexionbase co = new Conexionbase();
            con = co.Conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                cancion = new Musica();
                cancion.setIdregistromusica(rs.getInt(1));
                cancion.setTitulo(rs.getString(2));
                cancion.setArtista(rs.getString(3));
                cancion.setAlbum(rs.getString(4));
                cancion.setAño_creacion(rs.getDate(5));
                cancion.setGenero(rs.getString(6));
                cancion.setFecha_registro(rs.getDate(7));
                cancion.setAutor(rs.getString(8));
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error de clase buscar" + ex.getLocalizedMessage());
        }
        return cancion;
    }
}
