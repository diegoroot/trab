/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.IProfesor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import persistence.Profesor;
import sun.applet.Main;

/**
 *
 * @author carlo
 */
public class ControlProfesor {
    private Profesor u=null;
   List l;
    private IProfesor ir=null;
    public String ipserver="";
    public ControlProfesor() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(ipserver,10000);
		ir= (IProfesor) r.lookup("Profesor");
		
        }
    
    public boolean addProfesor(String doc_nombre,String doc_password,String doc_apellidos,String doc_cod){
		boolean add=true;
		try{
			if(!ir.addProfesor(doc_nombre,doc_password,doc_apellidos,doc_cod))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
    
    	public List listarProfesor(){
            
		try{
			 l =   ir.listProfesor();
		}
		catch(RemoteException e){
			e.printStackTrace();
			l=null;
		}
		return l;
	}
        
   public boolean delProfesor(String doc_cod){
		boolean del=true;
		try{
			if(!ir.delProfesor(doc_cod))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
   
   public Profesor searchProfesor(String doc_cod){
		try{
			u=ir.searchProfesor(doc_cod);
                        
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
   
   public boolean updateUser(int id,String nombre ,String password, String apellidos, String cod){
		boolean update=true;
		try{
			if(!ir.updateUser(id, nombre, password, apellidos, cod))
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
        
	
}
