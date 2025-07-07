// package FruitServiceEngine.server.src.server.tasks;

package server.tasks;

import java.io.Serializable;

public interface Task<T> extends Serializable {
    T execute();
}

