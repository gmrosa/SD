package br.com.furb.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Client de RMI.
 * 
 * @author Guilherme Rosa
 *
 */
public class RMIClient {
    static IRemoteObject obj = null;

    /**
     * Obt�m um objeto remoto.
     * 
     * @param remoteObject objeto remoto
     * @return inst�ncia
     */
    public static Object lookup(IRemoteObject remoteObject) {
	return lookup(LocalHost.getAddress(), remoteObject);
    }

    /**
     * Obt�m um objeto remoto.
     * 
     * @param address endere�o IP
     * @param remoteObject objeto remoto
     * @return inst�ncia
     */
    public static Object lookup(String address, IRemoteObject remoteObject) {
	try {
	    return ((IRemoteObject) Naming.lookup(String.format("//%s/%s", LocalHost.getAddress(), remoteObject.getName()))).getObject();
	} catch (RemoteException | MalformedURLException | NotBoundException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static void main(String[] args) throws RemoteException {
	MyLocalDateTime mld = new MyLocalDateTime();
	System.out.println(mld.getRemoteObject());
	MyInteger mi = new MyInteger();
	System.out.println(mi.getRemoteObject());
    }

}
