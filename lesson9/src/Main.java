import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcConnection.init();
        Suppliers supp = new Suppliers();
        supp.id = 6;
        supp.phone = "888888";
        supp.email = "ssssss@mail.ru";
        supp.date_reg = "2017-10-04";
        supp.adress = "zzzzzz";
        supp.name = "NewNewName";
        SuppliersRep sRep = new SuppliersRep();
        //sRep.add(supp);
        //sRep.update(supp);
        sRep.remove(supp);
        ArrayList<Object> suppliers = sRep.getALL();
        System.out.println(suppliers);
    }
}
