
package logic;

import interfaces.IProfesor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import persistence.NotFoundException;
import persistence.Profesor;
import persistence.ProfesorDao;
import persistence.Res;

/**
 *
 * @author carlo
 */
public class Impl_profesor  extends UnicastRemoteObject implements IProfesor{
      public Impl_profesor() throws RemoteException {
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
public List listProfesor() throws RemoteException {
        List l=null;	
		//crear los DAO a manipular
	       ProfesorDao user= new ProfesorDao();
            
	    try{
	    	l=user.loadAll(getConnection());
	    	
	    }
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return l;
 
    }

    public Profesor searchProfesor(String doc_cod) throws RemoteException {
      Profesor u=new Profesor(doc_cod);	
		//crear los DAO a manipular
	     ProfesorDao profesor = new ProfesorDao();
            
	    try{
	    	profesor.load(getConnection(),u);
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
    
    public boolean delProfesor(String doc_cod) throws RemoteException {
		boolean del=true;
		//crear el value object a eliminar
		Profesor u=new Profesor(doc_cod);
		//crear los DAO a manipular
	    ProfesorDao profesor= new ProfesorDao();
            
	    try{
	    	profesor.delete(getConnection(),u);
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
    
    
  
    public boolean addProfesor(String doc_nombre,String doc_password,String doc_apellidos,String doc_cod) throws RemoteException {
        boolean add = true;

		// crear el value object de user
		Profesor u = new Profesor();
		u.setDoc_nombre(doc_nombre);
		u.setDoc_apellidos(doc_apellidos);
                u.setDoc_cod(doc_cod);
               u.setDoc_password(doc_password);

		// crear el DAO a manipular
		ProfesorDao user = new ProfesorDao();
		
		try {
			user.create(getConnection(),u);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
    }
   
    public boolean updateUser(int id,String nombre ,String password, String apellidos, String cod)throws RemoteException{
        boolean update=true;
		//crear el value object a actualizar
		Profesor u=new Profesor();
		u.setAll(id, nombre, password, null, apellidos, cod);
		//crear los DAO a manipular
	    ProfesorDao user= new ProfesorDao();
            
	    try{
	    	user.save(getConnection(),u);
	    }
	    catch(SQLException e){
	    	update=false;
	    	e.printStackTrace();	
	    } catch (NotFoundException e) {
			// TODO Auto-generated catch block
	    	update=false;
	    	e.printStackTrace();
			
		}
	    return update;
        
    }

  

}