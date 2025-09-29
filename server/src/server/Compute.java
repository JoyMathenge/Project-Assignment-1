// package FruitServiceEngine.server.src.server;
//
package server;

import server.tasks.Task;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
    Object executeTask(Task<?> task) throws RemoteException;
}

