package modelos;

import controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Registrar {
    private String gerencia;
    private String departamento;
    private String asignacion;
    private String encargado;
    private int requerimientoid;
    private String descripcion;
    private String estado;
    private Conexion conexion;
    
    
    public Registrar() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public Registrar(int requerimientoid, String gerencia,String departamento,String asignacion,String encargado, String descripcion, String estado) throws ClassNotFoundException, SQLException {
        this.requerimientoid = requerimientoid;
        this.gerencia = gerencia;
        this.departamento = departamento;
        this.asignacion = asignacion;
        this.encargado = encargado;
        this.descripcion = descripcion;
        this.estado = estado;
        conexion = new Conexion();
    }
    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
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
                + "'"+gerencia+"',"+ "'"+departamento+"','"+asignacion+"','"+encargado+"','"+descripcion+"','Abierto')";
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
    
    public ArrayList<Registrar> consultarRequerimientos() throws SQLException, ClassNotFoundException{
        String sentencia = "SELECT requerimientoid, gerencia, departamento, asignacion, descripcion FROM "
                + "requerimientos WHERE gerencia='"+gerencia+"' and departamento='"+departamento+"' and asignacion='"+asignacion+"'";
        ArrayList<Registrar> requerimientos = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            requerimientos.add(new Registrar(rs.getInt("requerimientoid"), rs.getString("gerencia"), rs.getString("departamento"),rs.getString("asignacion"), null, rs.getString("descripcion"), null));
        }
        return requerimientos;
    }
    
    public ArrayList<Registrar> consultarRequerimientosDos() throws SQLException, ClassNotFoundException{
        String sentencia = "SELECT requerimientoid, gerencia, departamento, asignacion, descripcion, estado FROM "
                + "requerimientos WHERE gerencia='"+gerencia+"' and departamento='"+departamento+"' and asignacion='"+asignacion+"' and estado='Abierto'";
        ArrayList<Registrar> requerimientos = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            requerimientos.add(new Registrar(rs.getInt("requerimientoid"), rs.getString("gerencia"), rs.getString("departamento"),rs.getString("asignacion"), null, rs.getString("descripcion"), rs.getString("estado")));
        }
        return requerimientos;
    }
    
    public ArrayList<Registrar> cerrarRequerimientos() throws SQLException, ClassNotFoundException{
        String sentencia = "UPDATE requerimientos SET estado = 'Cerrado' WHERE requerimientoid = "+requerimientoid+"";
        ArrayList<Registrar> requerimientos = new ArrayList();
        if(conexion.ejecutarSQL(sentencia)==1){
            String sentenciaSelect = "SELECT gerencia, departamento, asignacion FROM requerimientos WHERE requerimientoid = "+requerimientoid+"";
            ResultSet rs = conexion.consultarSQL(sentenciaSelect);
            while(rs.next()){
                gerencia = rs.getString("gerencia");
                departamento = rs.getString("departamento");
                asignacion = rs.getString("asignacion");
            }
            requerimientos = consultarRequerimientosDos();
        }
        return requerimientos;
    }
}