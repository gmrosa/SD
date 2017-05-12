package br.com.furb.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota.
 * 
 * @author Guilherme Rosa
 *
 */
public interface IRemoteObject extends Remote {

    /**
     * @return inst�ncia
     * @throws RemoteException
     */
    public Object getObject() throws RemoteException;

    /**
     * @return nome do m�todo remoto
     * @throws RemoteException
     */
    public String getName() throws RemoteException;

    /**
     * @return inst�ncia remota
     * @throws RemoteException
     */
    public Object getRemoteObject() throws RemoteException;

    /**
     * Torna a inst�ncia vis�vel remotamente.
     * 
     * @return true se conseguiu
     * @throws RemoteException
     */
    public boolean addRemoteObject() throws RemoteException;

}
