<%-- 
    Document   : ConsultarRequerimiento
    Created on : 29-06-2020, 22:07:18
    Author     : Carlos_MDFK
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Doctores"%>
<%@page import="modelos.Especialidades"%>
<%@page import="modelos.Asignaciones"%>
<%@page import="modelos.Requerimientos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Horas</title>
    </head>
    <body>
        <h1>Consultar Horas Registradas</h1>
        <form action="Menu" method="post">
            <center><table style="border: 2; ">
                <tr>
                    <th>Doctores</th>
                    <% try{
                    Doctores ge = new Doctores(); 
                    ArrayList<Doctores> doctores = ge.obtenerDoctores(); 
                    %>
                    <td><select name="doctores">
                        <option disabled selected>Seleccionar</option>   
                        <% for(Doctores g: doctores){%>
                        <option value="<%= g.getDoctores()%>"> 
                            <%= g.getDoctores()%>
                        </option>
                        <% }%>
                    </select></td>
                    <%
                            }catch(Exception e){ 
                                out.println(e.getMessage());
                            } %>
                </tr>  
                <tr>
                    <th>Horas disponibles</th>
                     <% try{
                    Asignaciones as = new Asignaciones(); 
                    ArrayList<Asignaciones> asignaciones = as.obtenerAsignacion(); 
                    %>
                    <td><select name="asignar">
                        <option disabled selected>Seleccionar</option>    
                        <% for(Asignaciones a: asignaciones){%>
                        <option value="<%= a.getAsignacion()%>"> 
                            <%= a.getAsignacion()%>
                        </option>
                        <% }%>
                    </select></td>
                    <%
                            }catch(Exception e){ 
                                out.println(e.getMessage());
                            } %>
                </tr>
                <tr>
                    <th>Especialidades:</th>
                    <% try{
                    Especialidades es = new Especialidades(); 
                    ArrayList<Especialidades> especialidades = es.obtenerEspecialidades(); 
                    %>
                    <td><select name="especialidades">
                        <option disabled selected>Seleccionar</option>
                        <% for(Especialidades e: especialidades){%>
                        <option value="<%= e.getEspecialidad()%>"> 
                            <%= e.getEspecialidad()%>
                        </option>
                        <% }%>
                    </select></td>
                    <%
                            }catch(Exception e){ 
                                out.println(e.getMessage());
                            } %>
                </tr>
            </td>
            <td>
                <tr>
                <th><input type="submit" value="Buscar"/>
                <input type="hidden" name="accion" value="3"/></th>
                </tr>  
            </td>
            </tr>
        </table>                
        <table border="2">
            <tr>
                <td><b>Doctores</b></td>
                <td><b>Horas Disponibles</b></td>           
                <td><b>Especialidades</b></td>
            </tr>    
            <% if(request.getAttribute("listRequerimientos")!=null){
                    ArrayList<Requerimientos> req = (ArrayList<Requerimientos>)request.getAttribute("listRequerimientos");
                    for(Requerimientos r: req){%>
                    <tr>
                        <td><%=r.getDoctores()%></td>           
                        <td><%=r.getAsignacion()%></td>
                        <td><%=r.getDescripcion()%></td>
                    </tr>
            <%}} %>            

            <% if(request.getParameter("mensaje")!=null){%>
                <%=request.getParameter("mensaje") %>
            <%}%>
        </table></center>
                    <tr>
                <th><h3><a href="menu.jsp"></h3>
                <input type="button" value="Volver al menú" />
            </tr>
        </form>
    </body>
</html>