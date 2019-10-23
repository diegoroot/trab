/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.IRes;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import persistence.Res;

/**
 *
 * @author carlo
 */
public class ControlReserva {
        private Res u=null;
    private IRes ir=null;
     List l;
     public ControlReserva() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IRes) r.lookup("Reserva");
		
        }
     
     
     	public List listReserva(){
            
		try{
			 l =   ir.listReserva();
		}
		catch(RemoteException e){
			e.printStackTrace();
			l=null;
		}
		return l;
	}
        
   public boolean canReserva(int id){
		boolean del=true;
		try{
			if(!ir.canReserva(id))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
   
    public boolean addReserva( Time inicio, Time fin, int id_sal, int id_doc, Date fecha, int token){
		boolean add=true;
		try{
			if(!ir.addReserva(inicio, fin, id_sal, id_doc, fecha, token))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
    
      public Res searchReserva(int res_id){
		try{
			u=ir.searchReserva(res_id);
                        
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}

   
     
}
