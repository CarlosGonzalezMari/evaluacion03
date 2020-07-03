package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Registrar;
import modelos.Usuario;


@WebServlet(name = "Menu", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        String accion = request.getParameter("accion");
                        
        switch(accion){
            case "1": iniciarSesion(request,response);
            break;
            case "2": registrarHoras(request,response);
            break;
            case "3": consultarRequerimiento(request,response);
            break;
            case "4": consultarRequerimientoDos(request,response);
            break;
            case "5": cerrarRequerimientos(request,response);
            break;
        }
                      
        }
        catch(Exception e){
            response.sendRedirect("index.jsp?mensaje="+e.getMessage());
        }
    }
       
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException{
        String usuario = request.getParameter("usuario").trim();
        String password = request.getParameter("password").trim();
        if(usuario.isEmpty()||password.isEmpty()){
            response.sendRedirect("index.jsp?mensaje=Complete todos los campos");
        }else{
            Usuario u = new Usuario();
            u.setUsuario(usuario);
            u.setPassword(password);
            if(u.iniciarSesion()){
                response.sendRedirect("menu.jsp");
            }else{
                response.sendRedirect("index.jsp?mensaje=Datos Incorrectos");
            }
        }   
    }
    
    private void registrarHoras(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
        Registrar r = new Registrar(0, getString("gerencia",request), getString("departamento",request), 
                getString("asignar",request), getString("encargado",request), getString("requerimiento",request), null);
        response.sendRedirect("ingresarRequerimientos.jsp?mensaje="+r.ingresarRequerimientos());
        } catch (Exception e) {
                response.sendRedirect("ingresarRequerimientos.jsp?mensaje="+e.getMessage());
            }
    }
    
    private void consultarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
        Requerimientos r = new Requerimientos(0, getString("gerencia",request), getString("departamento",request), 
                getString("asignar",request), null, null, null);
        ArrayList<Requerimientos> listRequerimientos = r.consultarRequerimientos();
        request.setAttribute("listRequerimientos", listRequerimientos);
        request.getRequestDispatcher("consultarRequerimientos.jsp").forward(request, response);
        } catch (Exception e) {
                response.sendRedirect("consultarRequerimientos.jsp?mensaje="+e.getMessage());
            }
    }
    
    private void consultarRequerimientoDos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
        Requerimientos r = new Requerimientos(0, getString("gerencia",request), getString("departamento",request), 
                getString("asignar",request), null, null, null);
        ArrayList<Requerimientos> listRequerimientos = r.consultarRequerimientosDos();
        request.setAttribute("listRequerimientos", listRequerimientos);
        request.getRequestDispatcher("cerrarRequerimientos.jsp").forward(request, response);
        } catch (Exception e) {
                response.sendRedirect("cerrarRequerimientos.jsp?mensaje="+e.getMessage());
            }
    }
    
    private void cerrarRequerimientos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            int idReq = Integer.parseInt(request.getParameter("cerrarRequerimiento"));
            Requerimientos req = new Requerimientos(idReq, getString("gerencia",request), getString("departamento",request), 
                getString("asignar",request), null, null, null);
            ArrayList<Requerimientos> listRequerimientos = req.cerrarRequerimientos();
            request.setAttribute("listRequerimientos", listRequerimientos);
            request.getRequestDispatcher("cerrarRequerimientos.jsp").forward(request, response);
        } catch (Exception e) {
                response.sendRedirect("cerrarRequerimientos.jsp?mensaje="+e.getMessage());
            }
    }
    
    private String getString(String nombre,HttpServletRequest request){
        return request.getParameter(nombre);
    }
    private int getInt(String nombre,HttpServletRequest request){
        return Integer.parseInt(request.getParameter(nombre));
    }       
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
