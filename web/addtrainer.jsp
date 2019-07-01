<%-- 
    Document   : addtrainer
    Created on : Jul 1, 2019, 2:32:02 AM
    Author     : giorgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add trainer</title>
    </head>
    <body>
        <h1>Add a new trainer</h1>
        <%--    <jsp:useBean id="student" class="entities.Student" scope="page" />      --%>
        <%--    <jsp:setProperty name="student" property="lName" value="Tasos" />       --%>
        <%--    Student surname: <%= student.getlName() %>                              --%>

        <a href="/TrainersJPA">Home</a>
        
        <form method="POST" action="addtrainer">
            <label for="fname">Name:</label>
            <input id="fname" type="text" name="fname"><br />

            <label for="lname">Surname:</label>
            <input id="lname" type="text" name="lname"><br />

            <label for="subject">Subject:</label>
            <input id="subject" type="text" name="subject"><br />
            
            <input type="submit" name="submit">
        </form> 
    </body>
</html>
