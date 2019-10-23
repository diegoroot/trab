/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Time;

import java.util.List;
import persistence.Profesor;
import persistence.Res;
import java.sql.Date;

/**
 *
 * @author carlo
 */
public interface IRes extends Remote {
    boolean addReserva( Time inicio, Time fin, int id_sal, int id_doc, Date fecha)throws RemoteException;
    Res searchRes(int res_id)throws RemoteException;
    boolean canReserva(int id)throws RemoteException;
    List listReserva()throws RemoteException;
   
}

 