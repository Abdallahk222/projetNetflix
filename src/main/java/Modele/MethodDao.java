package Modele;

import java.sql.Connection;
import java.util.List;

public abstract class MethodDao<T> {


    public Connection connection=DAO.getInstance();
    /** Methode d'ajout d'élement pour chaque table du DAO */
    public abstract void ajouter(T obj);

    /** Methode de mis à jour d'élement pour chaque table du DAO */
    public abstract void update(T obj);

    /** Methode d'ajout d'élement pour chaque table du DAO */
    public abstract void supprimer(T obj);

    /** Methode de listage d'élément pour chaque table du DAO */
    public abstract List<T> lister();
}
