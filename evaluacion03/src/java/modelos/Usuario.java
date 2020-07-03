package modelos;

import controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private String usuario;
    private String password;
    private Conexion conexion;

    public Usuario() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public Usuario(String usuario, String password) throws ClassNotFoundException, SQLException {
        this.usuario = usuario;
        this.password = password;
        conexion = new Conexion();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }   
    
    public boolean iniciarSesion() throws SQLException{
        String sentencia = "select * from usuario where nombre ='"+usuario+"' "
                + " and password = '"+password+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        boolean respuesta = false;
        if(rs.next()){
            respuesta = true;
        }
        return respuesta;
    }
}