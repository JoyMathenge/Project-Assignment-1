// package FruitServiceEngine.web.servlets;

package servlets;

import server.Compute;
import server.tasks.CalculateCost;
import server.tasks.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// @WebServlet("/printReceipt")
public class PrintReceiptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double totalCost = Double.parseDouble(request.getParameter("totalCost"));
        double amountGiven = Double.parseDouble(request.getParameter("amountGiven"));
        String cashier = request.getParameter("cashier");

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Compute engine = (Compute) registry.lookup("FruitComputeEngine");
            Task<String> task = new CalculateCost(totalCost, amountGiven, cashier);
            String result = (String) engine.executeTask(task);

            response.getWriter().write(result);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
