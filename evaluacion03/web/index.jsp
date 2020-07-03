<%-- 
    Document   : index
    Created on : 26-06-2020, 17:32:33
    Author     : Carlos_MDFK
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body><center><h1>"SANO COMO YOGURT</h1></center>
    <td><h1>Autentificación</h1></td>
        <center>  
        <form action="Menu" method="post">           
                <table style="border: 2; ">
                    <tr>
                        <th>Usuario</th>
                        <td><input type="text" name="usuario" placeholder="Usuario"/></td>
                    </tr>
                    
                    <tr>
                        <th>Password</th>
                        <td><input type="password" name="password" placeholder="Password"/></td>
                    </tr>   
                    
                    <td><input type="submit" value="Ingresar"/>
                        <input type="hidden" name="accion" value="1"/></td>                      
                </table>
                               
           <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
        </form>
        </center>       
    </body>
</html>