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
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu Principal</h1>
        <form action="Menu" method="post">
            
                <table style="border: 3; ">
                    <tr>
                        <h6><a href="ingresarRequerimientos.jsp">
                            <input type="button" value="Reservar horas" /></h6>
                    </tr>
                    
                    <tr>
                        <h6><a href="consultarRequerimientos.jsp">
                            <input type="button" value="Consultar horas" /></h6>
                    </tr>
                    
                    <tr>
                        <h6><a href="cerrarRequerimientos.jsp">
                            <input type="button" value="Cancelar horas" /></h6>   
                    </tr>                    
                </table>
            <tr>
                        <h6><a href="index.jsp">
                            <input type="button" value="Volver a autentificacion" /></h6>   
                    </tr>
            
           <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
        </form>
    </body>
</html>