package modelos;

import controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Requerimientos {
    private String doctores;
    private String departamento;
    private String asignacion;
    private String encargado;
    private int requerimientoid;
    private String descripcion;
    private String estado;
    private Conexion conexion;
    
    
    public Requerimientos() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public Requerimientos(int requerimientoid, String doctores,String departamento,String asignacion,String encargado, String descripcion, String estado) throws ClassNotFoundException, SQLException {
        this.requerimientoid = requerimientoid;
        this.doctores = doctores;
        this.departamento = departamento;
        this.asignacion = asignacion;
        this.encargado = encargado;
        this.descripcion = descripcion;
        this.estado = estado;
        conexion = new Conexion();
    }
    public String getDoctores() {
        return doctores;
    }

    public void setDoctores(String doctores) {
        this.doctores = doctores;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public String getEncargado() {
        return encargado;
    }
    
    public int getRequerimientoid() {
        return requerimientoid;
    }

    public void setRequerimientoid(int requerimientoid) {
        this.requerimientoid = requerimientoid;
    }
    
    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public String ingresarRequerimientos() throws SQLException{
        requerimientoid = selectId();
        String sentencia = "INSERT INTO requerimientos VALUES ('"+requerimientoid+"',"
                + "'"+doctores+"',"+ "'"+departamento+"','"+asignacion+"','"+encargado+"','"+descripcion+"','Abierto')";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "Requerimiento registrado";
        }else{
            return "No se pudo registrar el requerimiento";
        }
    }
    
    public int selectId() throws SQLException{
        String sentencia = "select requerimientoid from requerimientos order by requerimientoid asc";
        ResultSet rs = conexion.consultarSQL(sentencia);
        int value = 0;
        while(rs.next()){
            value = rs.getInt("requerimientoid");
        }
        return value+1;
    }
    
    public ArrayList<Requerimientos> consultarRequerimientos() throws SQLException, ClassNotFoundException{
        String sentencia = "SELECT requerimientoid, doctores, departamento, asignacion, descripcion FROM "
                + "requerimientos WHERE doctores='"+doctores+"' and departamento='"+departamento+"' and asignacion='"+asignacion+"'";
        ArrayList<Requerimientos> requerimientos = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            requerimientos.add(new Requerimientos(rs.getInt("requerimientoid"), rs.getString("doctores"), rs.getString("departamento"),rs.getString("asignacion"), null, rs.getString("descripcion"), null));
        }
        return requerimientos;
    }
    
    public ArrayList<Requerimientos> consultarRequerimientosDos() throws SQLException, ClassNotFoundException{
        String sentencia = "SELECT requerimientoid, doctores, departamento, asignacion, descripcion, estado FROM "
                + "requerimientos WHERE doctores='"+doctores+"' and departamento='"+departamento+"' and asignacion='"+asignacion+"' and estado='Abierto'";
        ArrayList<Requerimientos> requerimientos = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            requerimientos.add(new Requerimientos(rs.getInt("requerimientoid"), rs.getString("doctores"), rs.getString("departamento"),rs.getString("asignacion"), null, rs.getString("descripcion"), rs.getString("estado")));
        }
        return requerimientos;
    }
    
    public ArrayList<Requerimientos> cerrarRequerimientos() throws SQLException, ClassNotFoundException{
        String sentencia = "UPDATE requerimientos SET estado = 'Cerrado' WHERE requerimientoid = "+requerimientoid+"";
        ArrayList<Requerimientos> requerimientos = new ArrayList();
        if(conexion.ejecutarSQL(sentencia)==1){
            String sentenciaSelect = "SELECT doctores, departamento, asignacion FROM requerimientos WHERE requerimientoid = "+requerimientoid+"";
            ResultSet rs = conexion.consultarSQL(sentenciaSelect);
            while(rs.next()){
                doctores = rs.getString("doctores");
                departamento = rs.getString("departamento");
                asignacion = rs.getString("asignacion");
            }
            requerimientos = consultarRequerimientosDos();
        }
        return requerimientos;
    }
}