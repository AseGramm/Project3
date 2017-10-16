import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordsForm extends JFrame{
    private JPanel panelScore;
    private JTextArea scoreField;

    public RecordsForm() throws SQLException {
        setContentPane(panelScore);
        setBounds(20,20,300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RecordsRep recordsRep = new RecordsRep();
        ArrayList<Record> records = new ArrayList<>();
        records = recordsRep.getRecords();
        for(Record record:records){
            scoreField.setText(scoreField.getText()+record);
        }
    }
}

