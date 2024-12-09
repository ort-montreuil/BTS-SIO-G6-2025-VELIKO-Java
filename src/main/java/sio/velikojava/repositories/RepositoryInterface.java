package sio.velikojava.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RepositoryInterface <T,ID> {
    void create(T obj) throws SQLException;
    void update(T obj) throws SQLException;
    void delete(ID id);
    T get(ID id);
    ArrayList<T> getAll() throws SQLException;
}

