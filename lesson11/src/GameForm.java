import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameForm extends JFrame{
    private JPanel panel;
    private JTextField setWordField;
    private JButton setWordButton;
    private JButton helpButton;
    private JButton skipButton;
    private JLabel numberHealth;
    private JPanel assotiationPanel1;
    private ArrayList<Question> questions;
    private int questionNumber = 0;
    private Question currentQuestion;
    private int assotiationNumber;
    private int hintsCount;
    private int tryCount;
    private int score = 0;

    public GameForm() throws SQLException {
        setContentPane(panel);
        setBounds(10,20,600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QuestionRep questionRep = new QuestionRep();
        questions = questionRep.getQuestions();
        showNextQuestion();
        setWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = setWordField.getText();
                String correctAnswer = currentQuestion.answer;
                setWordField.setText("");
                if(answer.equalsIgnoreCase(correctAnswer)){
                    JOptionPane.showMessageDialog(null,"Вы угадали","Win",JOptionPane.INFORMATION_MESSAGE);
                    score += tryCount+2*hintsCount;
                    if(questionNumber==questions.size()){
                        RecordsRep recordsRep = new RecordsRep();
                        try {
                            recordsRep.addRecord(PlayersRep.playerId,score);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        setVisible(false);
                        RecordsForm recordsForm = null;
                        try {
                            recordsForm = new RecordsForm();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        recordsForm.setVisible(true);
                    }
                    else{
                        showNextQuestion();
                    }
                }
                else{
                    tryCount--;
                    if(tryCount==0){
                        JOptionPane.showMessageDialog(null,"Вы проиграли. Правильный ответ "+currentQuestion.answer,"Lose",JOptionPane.INFORMATION_MESSAGE);
                        if(questionNumber==questions.size()){
                            RecordsRep recordsRep = new RecordsRep();
                            try {
                                recordsRep.addRecord(PlayersRep.playerId,score);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            setVisible(false);
                            RecordsForm recordsForm = null;
                            try {
                                recordsForm = new RecordsForm();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            recordsForm.setVisible(true);
                        }
                        else{
                            showNextQuestion();
                        }
                    }
                    else{
                        updateTryCountLabelText();
                    }
                }
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hintsCount--;
                updateHintsButtonText();
                assotiationNumber++;
                String assotiatoin = currentQuestion.words[assotiationNumber];
                addAssotiation(assotiatoin);
                if(hintsCount==0){
                    helpButton.setEnabled(false);
                }
            }
        });
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Вы проиграли. Правильный ответ "+currentQuestion.answer,"Lose",JOptionPane.INFORMATION_MESSAGE);
                if(questionNumber==questions.size()){
                    RecordsRep recordsRep = new RecordsRep();
                    try {
                        recordsRep.addRecord(PlayersRep.playerId,score);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    setVisible(false);
                    RecordsForm recordsForm = null;
                    try {
                        recordsForm = new RecordsForm();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    recordsForm.setVisible(true);
                }
                else{
                    showNextQuestion();
                }
            }
        });
    }

    private void addAssotiation(String assotiation){
        JLabel label = new JLabel(assotiation);
        label.setBackground(Color.GRAY);
        label.setForeground(Color.ORANGE);
        assotiationPanel1.add(label);
        assotiationPanel1.updateUI();
    }

    private void showNextQuestion(){
        questionNumber++;
        currentQuestion = questions.get(questionNumber-1);
        assotiationPanel1.removeAll();
        assotiationNumber = 0;
        addAssotiation(currentQuestion.words[0]);
        helpButton.setEnabled(true);
        hintsCount = currentQuestion.words.length-1;
        tryCount = 5;
        updateHintsButtonText();
        updateTryCountLabelText();
    }

    private void updateHintsButtonText(){
        String s = String.format("Подсказка (%d)",hintsCount);
        helpButton.setText(s);
    }

    private void updateTryCountLabelText(){
        String s = String.format("У вас осталось %d попыток",tryCount);
        numberHealth.setText(s);
    }
}
