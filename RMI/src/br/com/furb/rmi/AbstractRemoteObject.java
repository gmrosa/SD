package br.com.furb.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Abstração para objeto remoto genérico.
 * 
 * @author Guilherme Rosa
 *
 * @param <O> qualquer objeto pode ser remoto
 */
public abstract class AbstractRemoteObject<O> extends UnicastRemoteObject implements IRemoteObject {

    private static final long serialVersionUID = 1L;

    protected AbstractRemoteObject() throws RemoteException {
	super();
    }

    @Override
    public O getObject() throws RemoteException {
	return getObjectImpl();
    }

    @Override
    public Object getRemoteObject() {
	return RMIClient.lookup(this);
    }

    @Override
    public boolean addRemoteObject() throws RemoteException {
	return RMIServer.rebing(this);
    }

    /**
     * @return instância do objeto
     */
    public abstract O getObjectImpl();

}
