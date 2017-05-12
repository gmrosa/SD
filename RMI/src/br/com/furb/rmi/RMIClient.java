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
     * Obtém um objeto remoto.
     * 
     * @param remoteObject objeto remoto
     * @return instância
     */
    public static Object lookup(IRemoteObject remoteObject) {
	return lookup(LocalHost.getAddress(), remoteObject);
    }

    /**
     * Obtém um objeto remoto.
     * 
     * @param address endereço IP
     * @param remoteObject objeto remoto
     * @return instância
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
