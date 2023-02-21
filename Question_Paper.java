import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question_Paper {
    void frame(){
        JFrame f = new JFrame("Java Quiz");

        f.setBounds(200, 100, 500, 500);
        f.setLayout(null);
        JPanel panel = new JPanel();

        panel.setBounds(0, 0, 480, 480);
        panel.setLayout(null);
        f.add(panel);
        JLabel Title = new JLabel("Java Quiz");
        Title.setBounds(200, 5, 200, 30);
        Title.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel que1 = new JLabel();
        JLabel que2= new JLabel();
        JLabel que3 = new JLabel();
        JLabel que4 = new JLabel();
        JLabel que5 = new JLabel();
        JLabel que6 = new JLabel();
        JLabel que7= new JLabel();
        JLabel que8 = new JLabel();
        JLabel que9 = new JLabel();
        JLabel que10 = new JLabel();
        que1.setText("1. Who invented Java Programming? ");
        que1.setBounds(40,50,400,30);
        JRadioButton A=new JRadioButton();
        JRadioButton B=new JRadioButton();
        JRadioButton C=new JRadioButton();
        JRadioButton D=new JRadioButton();
        ButtonGroup bg=new ButtonGroup();
        A.setBounds(40,90,400,30);
        B.setBounds(40,130,400,30);
        C.setBounds(40,170,400,30);
        D.setBounds(40,210,400,30);
        A.setText("Guido van Rossum"); B.setText("James Gosling");
        C.setText("Dennis Ritchie"); D.setText("Bjarne Stroustrup");

        JButton Privious =new JButton("Privious");
        Privious.setBounds(60,300,100,30);

        JButton Next =new JButton("Next");
        Next.setBounds(220,300,100,30);
        bg.add(A);bg.add(B);bg.add(C);bg.add(D);
        panel.add(Title);panel.add(que1);
        panel.add(que1);
        panel.add(que2);
        panel.add(que3);
        panel.add(que4);
        panel.add(que5);
        panel.add(que6);
        panel.add(que7);
        panel.add(que8);
        panel.add(que9);
        panel.add(que10);
        panel.add(A);  panel.add(B);  panel.add(C);  panel.add(D);
        panel.add(Privious); panel.add(Next);

        f.setVisible(true);

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(B.isSelected()){
                    System.out.println("Correct");
                } else{
                    System.out.println("incorrect");
                }
                que1.setText("2. Which statement is true about Java?");
                A.setText("Java is a sequence-dependent programming language");
                B.setText("Java is a code dependent programming language");
                C.setText("Java is a platform-dependent programming language");
                D.setText("Java is a platform-independent programming language");

            }
        }  ; Next.addActionListener(ac);

    }

    public static void main(String[] args) {
        Question_Paper qp=new Question_Paper();
        qp.frame();

    }
}
