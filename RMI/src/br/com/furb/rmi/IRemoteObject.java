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
     * @return instância
     * @throws RemoteException
     */
    public Object getObject() throws RemoteException;

    /**
     * @return nome do método remoto
     * @throws RemoteException
     */
    public String getName() throws RemoteException;

    /**
     * @return instância remota
     * @throws RemoteException
     */
    public Object getRemoteObject() throws RemoteException;

    /**
     * Torna a instância visível remotamente.
     * 
     * @return true se conseguiu
     * @throws RemoteException
     */
    public boolean addRemoteObject() throws RemoteException;

}
