/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import persistence.Sala;

/**
 *
 * @author carlo
 */
public interface ISala extends Remote{
    Sala searchSala(int sal_id)throws RemoteException;
    boolean addSala(String sal_num_equ,String sal_ubicacion,String sal_nombre)throws RemoteException;
    boolean deleteSala(int sal_id)throws RemoteException;
    List listSalas()throws RemoteException;
}
