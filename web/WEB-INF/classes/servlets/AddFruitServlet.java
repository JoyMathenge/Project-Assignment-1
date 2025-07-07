package servlets;

import server.Compute;
import server.tasks.AddFruitPrice;
import server.tasks.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// @WebServlet("/addFruit")
public class AddFruitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fruit = request.getParameter("fruit");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Compute engine = (Compute) registry.lookup("FruitComputeEngine");
            Task<String> task = new AddFruitPrice(fruit, price);
            String result = (String) engine.executeTask(task);

            response.getWriter().write(result);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
