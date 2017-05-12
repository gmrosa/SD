package br.com.furb.rmi;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * Objeto remoto de um {@link LocalDateTime}.
 * 
 * @author Guilherme Rosa
 *
 */
public class MyLocalDateTime extends AbstractRemoteObject<LocalDateTime> {

    private LocalDateTime obj;

    protected MyLocalDateTime() throws RemoteException {
	super();
    }

    protected MyLocalDateTime(LocalDateTime obj) throws RemoteException {
	super();
	this.obj = obj;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String getName() {
	return getClass().getSimpleName();
    }

    @Override
    public LocalDateTime getObjectImpl() {
	return obj;
    }

    public static void main(String[] args) throws RemoteException {
	new MyLocalDateTime(LocalDateTime.now()).addRemoteObject();
    }

}
