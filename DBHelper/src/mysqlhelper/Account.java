package mysqlhelper;

public class Account {
    public Integer ID;
    public Integer personalID;
    public String type;
    public Double money;
    public Account(Integer ID)
    {
        this.ID = ID;
    }

    public Account(Integer ID,Integer personalID, String type, Double money) throws Exception {
        if(ID == null) throw new Exception("ID is null");
        this.ID = ID;
        this.personalID = personalID;
        this.type = type;
        this.money = money;
    }
}
