package client;

import java.util.EventObject;
public class BankEvent extends EventObject {

    private String message;
    public BankEvent(String source) {
        super(source);
        this.message = source;
    }
    public String getMessage1()
    {
        return message;
    }
}