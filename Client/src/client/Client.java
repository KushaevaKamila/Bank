package client;

import pack.Actions;
import pack.Interaction;
import pack.Pack;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String host;
    private int port;
    private Socket s;
    private Interaction interaction;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
    }
    public void start() throws Exception {
        s = new Socket(host, port);
        interaction = new Interaction(s);
        new Thread(()->{
            try {
                interaction.startInteraction(this::parse);
            } catch (Exception e) {

            }
        }).start();
    }

    public void onError(Exception e)
    {
        Pack errorPack = new Pack();
        errorPack.message = e.getMessage();
        errorPack.action = Actions.ERROR;
        try
        {
            interaction.send(errorPack);
        }
        catch(Exception ignored) {

        }
    }
    public Void parse(Pack pack){
        BankEvent be = new BankEvent(pack);
        fireEvent(be);
        return  null;
    }
    protected List<BankListener> listeners = new ArrayList<>();
    public void addListener(BankListener a)
    {
        listeners.add(a);
    }
    public void fireEvent(BankEvent e){
        for(int i = 0; i < listeners.size(); i++)
        {
            listeners.get(i).BankAvailable(e);
        }
    }
    public void send(Pack userData) throws IOException {
        interaction.send(userData);
    }
}