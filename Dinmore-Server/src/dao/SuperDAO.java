/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bilal
 * @param <T>
 * @param <ID>
 */
public interface SuperDAO<T, ID> {
    
    public void setSesstion(Session session);

    public boolean save(T t) throws Exception;

    public boolean delete(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public T search(ID id) throws Exception;

    public List<T> getAll() throws Exception;
}
