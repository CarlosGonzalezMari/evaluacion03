<%-- 
    Document   : Ingreasr requerimiento
    Created on : 29-06-2020, 22:06:27
    Author     : Carlos_MDFK
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Doctores"%>
<%@page import="modelos.Asignaciones"%>
<%@page import="modelos.Especialidades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Horas</title>
    </head>
    <body>
        <h1>Registrar horas de pacientes</h1>
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
                <tr>
                    <th>Porfavor ingrese su nombre, apellido, run y motivo de la consulta</th>
                    <td><textarea name="requerimiento" type="text" rows="12" cols="50" placeholder="Ingrese Motivo de la consulta"/></textarea></td>
                </tr>
                <tr>
                    <th><input type="submit" value="Guardar"/>
                        <input type="hidden" name="accion" value="2"/>
                    </th>
                <td>
                <th><a href="menu.jsp">
                        <input type="button" value="Volver al menú" /></a></th>
                <% if(request.getParameter("mensaje")!=null){%>
                    <%=request.getParameter("mensaje") %>
                <%}%>
        </table></center>
        </form>
    </body>
</html>
