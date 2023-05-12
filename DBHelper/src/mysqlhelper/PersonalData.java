package mysqlhelper;

public class PersonalData {
    public Integer ID;
    public String name;
    public Long number;
    public String password;

    public PersonalData(Integer ID, String name, Long number, String password) {
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.password = password;
    }
}
