package br.com.furb.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Servidor RMI.
 * 
 * @author Guilherme Rosa
 *
 */
public class RMIServer {

    /**
     * Registra o objeto remoto no servidor.
     * 
     * @param remoteObject objeto remoto
     * @return true se conseguiu registrar
     */
    public static boolean rebing(IRemoteObject remoteObject) {
	try {
	    new Thread(new Runnable() {

		@Override
		public void run() {
		    try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind(remoteObject.getName(), remoteObject);
		    } catch (Throwable e) {
			throw new RuntimeException(e);
		    }
		}
	    }).start();
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return false;
    }

}
