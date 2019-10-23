/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.IDocentes;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import persistence.Docentes;

/**
 *
 * @author carlo
 */
public class controlreservas {
    private Docentes u=null;
    private IDocentes ir=null;
    
    public controlreservas() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IDocentes) r.lookup("Usuario");
		
        }
    public Docentes searchUser(String id, String password){
		try{
			u=ir.searchDocente(id, password);
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	
    
}
