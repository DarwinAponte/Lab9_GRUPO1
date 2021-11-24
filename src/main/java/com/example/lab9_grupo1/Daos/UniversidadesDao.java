package com.example.lab9_grupo1.Daos;

import com.example.lab9_grupo1.Beans.*;
import sun.nio.cs.UnicodeEncoder;

import java.sql.*;
import java.util.ArrayList;

public class UniversidadesDao extends BaseDao {
    public ArrayList<Universidades> listaUniversidadesRanking(int idUniversidad, String nombre, String pais, int ranking, int numeroAlumnos, String fotoUniversidad) {

        ArrayList<Universidades> listaUniversidadesRanking = new ArrayList<>();

        String sql = ""; // query que permita mostrar universidades por ranking

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Universidades universidades = new Universidades();
                universidades.setIdUniversidad(rs.getInt(1));
                universidades.setNombre_universidad(rs.getString(2));
                universidades.setPais_universidad(rs.getString(3));
                universidades.setRanking(rs.getInt(4));
                universidades.setRanking(rs.getInt(5));
                universidades.setFoto_universidad(rs.getString(6));
                listaUniversidadesRanking.add(universidades);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUniversidadesRanking;

    }

    public boolean agregarUniversidades(Universidades universidades) { //retorna falso si surge una excepcion

        String sql = ""; // query respectivo, es con insert into y values

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, universidades.getIdUniversidad());
            pstmt.setString(2, universidades.getNombre_universidad());
            pstmt.setString(3, universidades.getPais_universidad());
            pstmt.setInt(4, universidades.getRanking());
            pstmt.setInt(5, universidades.getNumero_alumnos());
            pstmt.setString(6, universidades.getFoto_universidad());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean editarUniversidades(Universidades universidades) {
        String sql = ""; // query respectivo, es con update, set y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, universidades.getIdUniversidad());
            pstmt.setString(2, universidades.getNombre_universidad());
            pstmt.setString(3, universidades.getPais_universidad());
            pstmt.setInt(4, universidades.getRanking());
            pstmt.setInt(5, universidades.getNumero_alumnos());
            pstmt.setString(6, universidades.getFoto_universidad());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void eliminarUniversidades(int idUniversidad) {
        String sql = ""; // query respectivo, se usa delete from y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, idUniversidad);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}