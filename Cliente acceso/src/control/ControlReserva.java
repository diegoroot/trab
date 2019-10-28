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
     public String ipserver ="";
     public ControlReserva() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(ipserver,10000);
		ir= (IRes) r.lookup("Reserva");
		
        }
     
        public Res searchReserva(int res_id){
		try{
			u=ir.searchRes(res_id);
                        
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
        public static void main(String[] args) throws RemoteException, NotBoundException {
        ControlReserva c = new ControlReserva();
            System.out.println(c.searchReserva(57));
    }
   
     
}
