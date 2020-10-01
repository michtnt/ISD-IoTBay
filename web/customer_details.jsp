<!--/**
 *
 * @author Michael
 */-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="./css/customer.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <div class="main-component">
                    <title class="title">Customer Details</title>
        <div class="dashboard-form-container with-bg has-subheading">
        
    </head>
    
    <%
        String ID = (String) session.getAttribute("ID");
        String username = (String) session.getAttribute("Username");
        String firstname = (String) session.getAttribute("Firstname");
        String lastname = (String) session.getAttribute("Lastname");
        String address = (String) session.getAttribute("Address");
        String email = (String) session.getAttribute("Email");

    %>
    
    
    <body>
<h1>Customer Details</h1>
<form action="Update_Customer_Servlet" method="POST">
<p hidden><input type="ID" name="ID" value="<%=ID%>"><br></p>
<label class="subtitle" for="USERNAME">Username : </label><br>
<p><input class="subtitle" type="USERNAME" name="USERNAME" value="<%=username%>"><br></p>

<label class="subtitle" for="FNAME">First Name : </label><br>
<p><input class="subtitle" type="FNAME" name="FNAME" value="<%=firstname%>"><br></p>

<label class="subtitle" for="LNAME">Last Name : </label><br>
<p><input class="subtitle" type="LNAME" name="LNAME" value="<%=lastname%>"><br></p>

<label class="subtitle" for="ADDRESS">Address : </label><br>
<p><input class="subtitle" type="ADDRESS" name="ADDRESS" value="<%=address%>"><br></p>

<label class="subtitle" for="EMAIL">Email : </label><br>
<p><input cclass="subtitle" type="EMAIL" name="EMAIL" value="<%=email%>"><br></p>



<table>
<tr>
    <td><input type="submit" class="btn-blue" value="Save" onclick ="Update()"></form></td>
    <td></td>
    <form action="customer_details.jsp" method="POST">
    <p hidden><input name="ID" value="<%=ID%>"><br></p>
    <p hidden><input name="USERNAME" value="<%=username%>"><br></p>
    <td><input type="submit" value="Cancel"></form></td>
</tr>
<tr>
    <td></td>
    <td><form action="index.html" method="POST"><input type="submit" value="Back"></form></td>
    <td></td>
</tr> 
<tr>
    <td></td>
    <td><form action="ActivateUser" method="POST">   
<p hidden><input name="ID" value="<%=ID%>"><br></p>
<input type="submit" value="Activate" onclick ="Active()"></form></td>
    <td></td>
</tr> 
<tr>
    <td></td>
    <td><form action="DeactivateUser" method="POST">
<p hidden><input name="ID" value="<%=ID%>"><br></p>
<input type="submit" value="Deactive" onclick ="Deactive()"></form></td>
    <td></td>
</tr> 
    <td></td>
    <td>
    <form action="Delete_Servlet" method="POST">
    <p hidden><input type="ID" name="ID" value="<%=ID%>"><br></p>
    <input type="submit" value="Delete" onclick ="Delete()"></form>
    </td>
    <td></td>

</table>   
<script>
function Delete() 
{
alert ("User have been deleted!");
}
function Update() 
{
alert ("User details have been updated!");
}
function Active() 
{
alert ("User have been Activated!");
}
function Deactive() 
{
alert ("User details have been Deactivated!");
}
</script>
</body>


</html>
