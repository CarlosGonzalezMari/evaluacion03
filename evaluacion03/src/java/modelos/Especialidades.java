package modelos;

import controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Especialidades {
    private Conexion conexion;
    private int especialidadId;
    private int tipoId;
    private String especialidad;
    
    public Especialidades() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }
    
    public Especialidades(int especialidadId, int tipoId, String especialidad) throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
        this.especialidadId = especialidadId;
        this.tipoId = tipoId;
        this.especialidad = especialidad;
    }
    
        public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Especialidades> obtenerEspecialidades() throws SQLException, ClassNotFoundException{
        String sentencia = "select especialidadId, tipoId, especialidad from especialidades";
        ArrayList<Especialidades> especialidades = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            especialidades.add(new Especialidades(rs.getInt("especialidadId"),rs.getInt("tipoId"),rs.getString("especialidad")));
        }
        return especialidades;
    }
  
}
