package modelos;

import controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Doctores {
    private Conexion conexion;
    private int doctoresId;
    private String doctores;
    
    public Doctores() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }
     public Doctores(int doctoresId, String doctores) throws ClassNotFoundException, SQLException {
         conexion = new Conexion();
         this.doctoresId = doctoresId;
         this.doctores = doctores;
     }
     
         public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public int getDoctoresId() {
        return doctoresId;
    }

    public void setDoctoresId(int doctoresId) {
        this.doctoresId = doctoresId;
    }

    public String getDoctores() {
        return doctores;
    }

    public void setDoctores(String doctores) {
        this.doctores = doctores;
    }
     
    public ArrayList<Doctores> obtenerDoctores() throws SQLException, ClassNotFoundException{
        String sentencia = "select doctoresId, doctores from doctores";
        ArrayList<Doctores> doctores = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            doctores.add(new Doctores(rs.getInt("doctoresId"),rs.getString("doctores")));
        }
        return doctores;
    }
}