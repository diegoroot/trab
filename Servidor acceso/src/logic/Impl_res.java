/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import interfaces.IRes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import persistence.NotFoundException;
import persistence.Res;
import persistence.ResDao;

/**
 *
 * @author carlo
 */
public class Impl_res extends UnicastRemoteObject implements IRes {
      public Impl_res() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


    public Res searchRes(int res_id) throws RemoteException {
    	Res u=new Res(res_id);	
		//crear los DAO a manipular
	           ResDao reserva= new ResDao();
                   System.out.println("id impl:"+u.getRes_id());
           
	    try{
	    	reserva.load(getConnection(),u);
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