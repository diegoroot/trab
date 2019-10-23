/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import logic.Impl_res;

/**
 *
 * @author carlo
 */
public class ObjectServer {
      public static void main(String[] args) throws RemoteException, MalformedURLException{
		

                Impl_res implres = new Impl_res();
             
             
                
		Registry r = LocateRegistry.createRegistry(10000);
	
                r.rebind("Reserva", implres);
               
         
                
	
                    System.out.println("Objeto reserva publicado " + implres);
                  
		
	}
}
