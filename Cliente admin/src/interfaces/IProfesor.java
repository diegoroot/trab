/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import persistence.Profesor;


/**
 *
 * @author carlo
 */
public interface IProfesor extends Remote{
    Profesor searchProfesor(String doc_cod)throws RemoteException;
        boolean updateUser(int id,String nombre ,String password, String apellidos, String cod)throws RemoteException;

    boolean delProfesor(String doc_cod)throws RemoteException;
    boolean addProfesor(String doc_nombre,String doc_password,String doc_apellidos,String doc_cod)throws RemoteException;
    List listProfesor()throws RemoteException;
 
}
