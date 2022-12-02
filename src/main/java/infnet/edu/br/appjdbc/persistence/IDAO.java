package infnet.edu.br.appjdbc.persistence;

import java.util.List;

public interface IDAO<T> {

        Boolean save(T obj);    
        Boolean update(T obj);
        Boolean delete(T obj);
        T get(Integer id);
        List<T> getAll();

}
