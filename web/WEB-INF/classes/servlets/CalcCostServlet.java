// package FruitServiceEngine.web.servlets;

package servlets;

import server.Compute;
import server.tasks.CalFruitCost;
import server.tasks.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// @WebServlet("/calcCost")
public class CalcCostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fruit = request.getParameter("fruit");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Compute engine = (Compute) registry.lookup("FruitComputeEngine");
            Task<String> task = new CalFruitCost(fruit, quantity);
            String result = (String) engine.executeTask(task);

            response.getWriter().write(result);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
