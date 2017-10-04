import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersRep implements Repository{

    @Override
    public ArrayList<Object> getALL() throws SQLException {
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("SELECT * FROM suppliers");//Возврат объекта "con" и создаём запрос через его метод prepareStatement
        ResultSet result = ps.executeQuery();//executeQuery только для SELECT для остального(UPDATE,INSERT,DELETE) executeUpdate
        ArrayList<Object> list = new ArrayList<Object>();
        while(result.next()){//Переход на строку ниже в ResultSet(изначально указывает на не существующую строку). result.next() возвращает true пока есть строки, если строк нет то false
            Suppliers supp = new Suppliers();
            supp.id = result.getInt("id");
            supp.name = result.getString("name");
            supp.adress = result.getString("adress");
            supp.date_reg = result.getString("date_reg");
            supp.email = result.getString("email");
            supp.phone = result.getString("phone");
            list.add(supp);
        }
        return list;
    }

    @Override
    public void add(Object o) throws SQLException {
        Suppliers supp = (Suppliers) o;
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("INSERT INTO suppliers(name,adress,date_reg,email,phone) VALUES (?,?,?,?,?)");
        ps.setString(1,supp.name);//Заменем "вопросики"
        ps.setString(2,supp.adress);
        ps.setString(3,supp.date_reg);
        ps.setString(4,supp.email);
        ps.setString(5,supp.phone);
        ps.executeUpdate();
    }

    @Override
    public void update(Object o) throws SQLException {
        Suppliers supp = (Suppliers) o;
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("UPDATE suppliers SET name = ? ,adress = ?, date_reg = ?, email = ?, phone = ? WHERE id = ?");
        ps.setString(1,supp.name);
        ps.setString(2,supp.adress);
        ps.setString(3,supp.date_reg);
        ps.setString(4,supp.email);
        ps.setString(5,supp.phone);
        ps.setInt(6,supp.id);
        ps.executeUpdate();
    }

    @Override
    public void remove(Object o) throws SQLException {
        Suppliers supp = (Suppliers) o;
        PreparedStatement ps = JdbcConnection.getConnection().prepareStatement("DELETE FROM suppliers WHERE id = ?");
        ps.setInt(1,supp.id);
        ps.executeUpdate();
    }
}
