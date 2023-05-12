package mysqlhelper;
import java.sql.*;
import java.util.ArrayList;

import com.lambdaworks.crypto.SCryptUtil;
public class MySQLHelper {
    private Connection con;
    private String account = "account";
    private String personalData = "personalData";
    private String schema = "bank";
    private String user = "root";
    private String password = "root";
    private String host = "localhost";
    private int port = 3306;
    private String connStr = "jdbc:mysql://" + host + ":" + port;
    public MySQLHelper() throws SQLException {
        con = DriverManager.getConnection(connStr, user, password);
    }
    public boolean isExist(long number) throws SQLException {
        String sql = "select count(*) from bank.account where number = " + number;
        ResultSet a = con.createStatement().executeQuery(sql);
        return a.getInt(1) == 1;
    }
    public ArrayList<Account> selectAccount(int personalID) throws Exception {
        String sql = "select * from bank.account where ID = " + personalID;
        ResultSet a = con.createStatement().executeQuery(sql);
        ArrayList<Account> accs = new ArrayList<>();
        while (a.next())
        {
            accs.add(new Account(a.getInt(1),a.getInt(2),a.getString(3), a.getDouble(4)));
        }
        return accs;
    }
    public PersonalData selectPersonalData(int ID) throws SQLException {
        String sql = "select * from bank.personaldata where ID = " + ID;
        ResultSet a = con.createStatement().executeQuery(sql);
        return new PersonalData(a.getInt(1),a.getString(4), a.getLong(2),a.getString(3));
    }
    public void insertAccount(Account chel) throws SQLException {
        String sql = "insert into bank.account(ID, personalid, type, money) values(" + chel.ID + ","+ chel.personalID +"," + chel.type + "," + chel.money+")";
        con.createStatement().execute(sql);
    }
    public void insertPersonalData(PersonalData chel) throws SQLException {
        String sql = "insert into bank.personaldata(ID, name, number, password) values(" + chel.ID + "," + chel.name + "," + chel.number+","+chel.password+")";
        con.createStatement().execute(sql);
    }
    public void updateAccount(Account chel) throws SQLException {
        String sql = "update bank.account set " +
                (chel.type != null ? "type = " + chel.type + "," : "") +
                (chel.money != null ? "money = " + chel.money : "") +
                (chel.personalID != null ? "personalid = " + chel.personalID : "") +
                "where ID = " + chel.ID;
        con.createStatement().execute(sql);
    }
    public void updatePersonalData(PersonalData chel) throws SQLException {
        String sql = "update bank.personaldata set " +
                (chel.number != null ? "type = " + chel.number + "," : "") +
                (chel.name != null ? "money = " + chel.name : "") +
                (chel.password != null ? "money = " + chel.password : "") +
                "where ID = " + chel.ID;
        con.createStatement().execute(sql);
    }
    public String getName(int ID) throws SQLException {
        String sql = "select name from bank.account where id =" + ID;
        return con.createStatement().executeQuery(sql).getString(1);
    }
    public int getID(long number) throws SQLException {
        String sql = "select ID from bank.personalData where number =" + number;
        return con.createStatement().executeQuery(sql).getInt(1);
    }
    public void deleteAccount(int ID) throws SQLException {
        String sql = "delete from bank.account where id =" + ID;
        con.createStatement().execute(sql);
    }
    public boolean isCorrect(long number, String password) throws SQLException {
        String sql = "SELECT * FROM bank.personalData where number = " + number;
        ResultSet set = con.createStatement().executeQuery(sql);
        return SCryptUtil.check(set.getString(3), password);
    }
}
