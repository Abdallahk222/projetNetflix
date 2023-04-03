package Modele;

import java.sql.Connection;
import java.util.List;

public abstract class MethodDao<T> {
    public Connection connection=DAO.getInstance();
    public abstract void ajouter(T obj);
    public abstract void update(T obj);
    public abstract void supprimer(T obj);
    public abstract List<T> lister();
}
