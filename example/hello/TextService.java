package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextService extends Remote {
    String maiusculo(String texto) throws RemoteException;
    String minusculo(String texto) throws RemoteException;
}