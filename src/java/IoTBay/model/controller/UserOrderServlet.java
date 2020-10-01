

import IoTBay.mvp.model.OrderLine;
import IoTBay.mvp.model.Orders;
import IoTBay.model.dao.OrderDBManager;
import IoTBay.model.dao.OrderLineDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tayla
 */
public class UserOrderServlet extends HttpServlet{
    
    public void init() {
        
    }
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        
        OrderDBManager manager = (OrderDBManager) session.getAttribute("orderManager");
        Orders order = new Orders(userID);
        int orderID = order.getOrderID();
        try {
            manager.addOrder(orderID, userID);
        } 
        catch (SQLException ex) {
            Logger.getLogger(UserOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("orderID", orderID);
        request.getRequestDispatcher("Welcome.jsp").include(request, response);
        
    }

}