<%@page import = "java.util.LinkedList"%>

<%-- 
    Document   : save
    Created on : May 25, 2020, 1:27:37 PM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="./css/customer.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<div class="main-component">

<div class="dashboard-form-container with-bg has-subheading">

<title class="title">List Customer</title>

    </head>
    <Body>
        <table style="width: 100%" class="fl-table">
        <tr>
            <th class="subtitle">ID</th>
            <th class="subtitle">Username</th>
            <th class="subtitle">Firstname</th>
            <th class="subtitle">Lastname</th>
            <th class="subtitle">Address</th>
            <th class="subtitle">Email</th>
            <th class="subtitle">Active</th>
            <th class="subtitle">Select</th>
        </tr>
    <%         
        
        LinkedList List  = (LinkedList) session.getAttribute("List");
        for(int i =0; i < List.size(); i = i + 7)
        {
      %>  
      

          <tr>
               <form action="Customer_Details" method="POST">
              <td>
                  <input class="subtitle" readonly="True" type="text" name="ID" value ="<%= List.get(i)  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="USERNAME" value ="<%= List.get(i+1)  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="FIRSTNAME" value ="<%= List.get(i+2)  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="LASTNAME" value ="<%= List.get(i+3)  %>">
              </td>
             <td>
                  <input class="subtitle" readonly="True" type="text" name="ADDRESS"  value ="<%= List.get(i+4)  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="EMAIL"  value ="<%= List.get(i+5)  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="ACTIVE"  value ="<%= List.get(i+6)  %>">
              </td>
              <td>
              <div>
                <div class="btn blue-btn">
                  <input type="submit" value="SELECT"></form>
                </div>
               </div>
              </td> 
          </tr>
      
      <%
        }
      %> 
      </table>
   
    
    </body>
</html>
