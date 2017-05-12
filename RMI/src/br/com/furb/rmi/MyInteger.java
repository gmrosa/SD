package br.com.furb.rmi;

import java.rmi.RemoteException;

/**
 * Objeto remoto de um {@link Integer}.
 * 
 * @author Guilherme Rosa
 *
 */
public class MyInteger extends AbstractRemoteObject<Integer> {

    private Integer obj = 0;

    protected MyInteger() throws RemoteException {
	super();
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String getName() throws RemoteException {
	return getClass().getName();
    }

    @Override
    public Integer getObjectImpl() {
	return ++obj;
    }

    public static void main(String[] args) throws RemoteException {
	new MyInteger().addRemoteObject();
    }

}
