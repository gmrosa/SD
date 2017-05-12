package br.com.furb.rmi;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Recursos para host local.
 * 
 * @author Guilherme Rosa
 *
 */
public class LocalHost {

    /**
     * @return o endereço de IP do host local
     * @throws UnknownHostException
     */
    public static final String getAddress() {
	try {
	    return Inet4Address.getLocalHost().getHostAddress();
	} catch (Throwable e) {
	    return "";
	}
    }

}
