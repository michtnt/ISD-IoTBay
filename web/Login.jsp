<%@page import="IoTBay.mvp.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="./css/main.css">
 <body>
     <div class="main-component">
         <div class="dashboard-form-container with-bg has-subheading">
        <h1 class="form-title">Login</h1>
        <form method="post" action="checkLogin">
            <table>
                <tr>
                    <td>
                        <label for="loginemail">Email</label>
                    </td>
                    <td>
                        <input type ="text" id="loginemail" name="loginemail" required><br>
                    </td>
                <tr>
                    <td>
                        <label for="loginpassword">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="loginpass" name="loginpass" required>
                    </td>
                </tr>
            </table>
        
       
        
            <input type="submit" value="Submit" class = "btn btn-blue" : blue button>
          
         </div> 
     </div> 
        </form>

 

    </body>
</html>