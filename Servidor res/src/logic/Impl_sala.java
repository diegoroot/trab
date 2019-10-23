/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import interfaces.IRes;
import interfaces.ISala;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import persistence.NotFoundException;

import persistence.Sala;
import persistence.SalaDao;

/**
 *
 * @author carlo
 */
public class Impl_sala extends UnicastRemoteObject implements ISala{
    public Impl_sala() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
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


public  boolean addSala(String sal_num_equ,String sal_ubicacion,String sal_nombre) throws RemoteException {
        boolean add = true;

		// crear el value object de user
		Sala u = new Sala();
		u.setSal_num_equ(sal_num_equ);
		u.setSal_ubicacion(sal_ubicacion);
                u.setSal_nombre(sal_nombre);
            

		// crear el DAO a manipular
		SalaDao user = new SalaDao();
		
		try {
			user.create(getConnection(),u);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
    }

public List listSalas() throws RemoteException {
        List l=null;	
		//crear los DAO a manipular
	      SalaDao user= new SalaDao();
            
	    try{
	    	l=user.loadAll(getConnection());
	    	
	    }
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return l;
 
    }

public boolean deleteSala(int id) throws RemoteException {
		boolean del=true;
		//crear el value object a eliminar
		Sala u=new Sala(id);
		//crear los DAO a manipular
	    SalaDao sala= new SalaDao();
            
	    try{
	    	sala.delete(getConnection(),u);
	    }
	    catch(SQLException e){
	    	del=false;
	    	e.printStackTrace();
	    } catch (NotFoundException e) {
			// TODO Auto-generated catch block
	    	del=false;
	    	e.printStackTrace();
		}
	    return del;
	}

    @Override
    public Sala searchSala(int sal_id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   
}