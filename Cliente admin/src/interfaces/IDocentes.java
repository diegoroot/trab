
package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import persistence.Docentes;

public interface IDocentes extends Remote {
       Docentes searchDocente(String id, String password)throws RemoteException;
}
