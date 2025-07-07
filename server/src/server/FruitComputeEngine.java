package server;


import server.tasks.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FruitComputeEngine extends UnicastRemoteObject implements Compute {

    public FruitComputeEngine() throws RemoteException {
        super();
    }

    public Object executeTask(Task<?> task) throws RemoteException {
        return task.execute();
    }

    public static void main(String[] args) {
        try {
            FruitComputeEngine engine = new FruitComputeEngine();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("FruitComputeEngine", engine);
            System.out.println("✔️ RMI Server is running on port 1099.");
        } catch (Exception e) {
            System.err.println("❌ Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

