// package FruitServiceEngine.web.servlets;

package servlets;

import server.Compute;
import server.tasks.UpdateFruitPrice;
import server.tasks.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// @WebServlet("/updateFruit")
public class UpdateFruitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fruit = request.getParameter("fruit");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Compute engine = (Compute) registry.lookup("FruitComputeEngine");
            Task<String> task = new UpdateFruitPrice(fruit, price);
            String result = (String) engine.executeTask(task);

            response.getWriter().write(result);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
