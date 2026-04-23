package example.hello;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        
        System.out.println("Initiating client");
        
        String host = (args.length < 1) ? "localhost" : args[0];
        try {
            //Registry registry = LocateRegistry.getRegistry(host);
            //System.out.println("Registry has been located");
            //Hello stub = (Hello) registry.lookup("Hello");

            Hello stub = (Hello) Naming.lookup("rmi://" + host + "/MyHello"); 
            System.out.println("Found server");
            String response = stub.sayHello();
            System.out.println("Response: " + response);

            int result = stub.soma(100,1000);
            System.out.println("Response from soma: " + result);

            int sub = stub.subtracao(10, 5);
            System.out.println("Subtração: " + sub);

            int mult = stub.multiplicacao(10, 5);
            System.out.println("Multiplicação: " + mult);

            double div = stub.divisao(10, 2);
            System.out.println("Divisão: " + div);
            
            TextService textStub = (TextService) Naming.lookup("rmi://" + host + "/MyTextService");

            String maiusculo = textStub.maiusculo("teste rmi");
            System.out.println("Maiúsculo: " + maiusculo);

            String minusculo = textStub.minusculo("TESTE RMI");
            System.out.println("Minúsculo: " + minusculo);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
