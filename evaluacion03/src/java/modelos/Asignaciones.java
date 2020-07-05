package modelos;

import controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Asignaciones {
    private Conexion conexion;
    private int asignacionesid;
    private String asignacion;

    public Asignaciones() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();    
    }
    
    public Asignaciones(int asignacionesid, String asignacion) throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
        this.asignacionesid = asignacionesid;
        this.asignacion = asignacion;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public int getAsignacionesid() {
        return asignacionesid;
    }

    public void setAsignacionesid(int asignacionesid) {
        this.asignacionesid = asignacionesid;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }
    
    public ArrayList<Asignaciones> obtenerAsignacion() throws SQLException, ClassNotFoundException{
        String sentencia = "select asignacionesid, asignacion from asignaciones";
        ArrayList<Asignaciones> asignaciones = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            asignaciones.add(new Asignaciones(rs.getInt("asignacionesid"),rs.getString("asignacion")));
        }
        return asignaciones;
    }
} 

    
