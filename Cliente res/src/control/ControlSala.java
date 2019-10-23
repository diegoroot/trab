/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import interfaces.ISala;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import persistence.Sala;


/**
 *
 * @author carlo
 */
public class ControlSala {
     private Sala u=null;
    private ISala ir=null;
     List l;
     public ControlSala() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (ISala) r.lookup("Salas");
		
        }
     
      public  boolean addSala(String sal_num_equ,String sal_ubicacion,String sal_nombre){
		boolean add=true;
		try{
			if(!ir.addSala(sal_num_equ,sal_ubicacion,sal_nombre))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
      
      public List listSalas(){
            
		try{
			 l =   ir.listSalas();
		}
		catch(RemoteException e){
			e.printStackTrace();
			l=null;
		}
		return l;
	}
      public boolean deleteSala(int id){
		boolean del=true;
		try{
			if(!ir.deleteSala(id))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
      
      public static void main(String[] args) throws RemoteException, NotBoundException {
        ControlSala cs = new ControlSala();
          System.out.println(cs.listSalas());
    }
}
