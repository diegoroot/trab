/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import interfaces.IDocentes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import persistence.Docentes;
import persistence.DocentesDao;
import persistence.NotFoundException;

/**
 *
 * @author carlo
 */
public class Impl_docentes extends UnicastRemoteObject implements IDocentes{
      public Impl_docentes() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
          

        public Docentes searchDocente(String id, String password) throws RemoteException {
		//crear el value object a retornar
		Docentes u=new Docentes(id,password);	
		//crear los DAO a manipular
	           DocentesDao docente= new DocentesDao();
           
	    try{
	    	docente.load(getConnection(),u);
	    }
	    catch(SQLException e){
	    	u=null;
	    	e.printStackTrace();
	    } catch (NotFoundException e) {
			u=null;
			e.printStackTrace();
		}
	    return u;
	}
            public List searchUsers() throws RemoteException {
		List l=null;	
		//crear los DAO a manipular
	    DocentesDao docentes= new DocentesDao();
            
	    try{
	    	l=docentes.loadAll(getConnection());
	    	
	    }
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return l;
	}
      

 private Connection getConnection(){
		Connection conn=null;
		try{
            //registrar la clase del driver
            Class.forName("com.mysql.jdbc.Driver");
            //obtener el objeto de conexion
            conn=DriverManager.getConnection("jdbc:mysql://localhost/trabvivian","root","");// login=postgres , contraseña=postgres
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        return conn;
	
	}

 

  








    
}
