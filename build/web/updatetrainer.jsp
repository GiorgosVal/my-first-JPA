<%-- 
    Document   : updatetrainer
    Created on : Jul 1, 2019, 2:32:19 AM
    Author     : giorgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update trainer</title>
    </head>
    <body>
        <h1>Update trainer</h1>
        <%--    <jsp:useBean id="student" class="entities.Student" scope="page" />      --%>
        <%--    <jsp:setProperty name="student" property="lName" value="Tasos" />       --%>
        <%--    Student surname: <%= student.getlName() %>                              --%>

        <a href="/TrainersJPA">Home</a>
        
        <form method="POST" action="updatetrainer">
            <input id="id" type="text" name="id" value="<%= request.getAttribute("id") %>" hidden><br />
            
            <label for="fname">Name:</label>
            <input id="fname" type="text" name="fname" value="<%= request.getAttribute("fname") %>"><br />

            <label for="lname">Surname:</label>
            <input id="lname" type="text" name="lname" value="<%= request.getAttribute("lname") %>"><br />

            <label for="subject">Subject:</label>
            <input id="subject" type="text" name="subject" value="<%= request.getAttribute("subject") %>"><br />
            
            <input type="submit" name="submit">
        </form> 
    </body>
</html>
