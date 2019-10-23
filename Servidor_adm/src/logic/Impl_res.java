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

    @Override
    public Res searchRes(int res_id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

public boolean addReserva( Time inicio, Time fin, int id_sal, int id_doc, Date fecha){
            boolean add = true;

		// crear el value object de user
		Res u = new Res();
		u.setRes_hora_ini(inicio);
		u.setRes_hora_fin(fin);
                u.setRes_id_sal(id_sal);
               u.setRes_id_doc(id_doc);
               u.setRes_fecha((java.sql.Date) fecha);

		// crear el DAO a manipular
		ResDao reserva = new ResDao();
		
		try {
			reserva.create(getConnection(),u);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
    
}

    public List listReserva() throws RemoteException {
        List l=null;	
		//crear los DAO a manipular
	      ResDao res= new ResDao();
            
	    try{
	    	l=res.loadAll(getConnection());
	    	
	    }
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return l;
 
    }

   
    public boolean canReserva(int id) throws RemoteException {
       boolean del=true;
		//crear el value object a eliminar
		Res u=new Res(id);
		//crear los DAO a manipular
	    ResDao reserva= new ResDao();
            
	    try{
	    	reserva.delete(getConnection(),u);
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
    
}