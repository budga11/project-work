import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class GuiRandomGame { static int flag = 0;
    static  int y=0; static String user;static int z=1;
    void game() {
        String item[] = {"Rock","Scissor","Paper"};
        Random r = new Random();
        int a = r.nextInt(item.length - 1);
        String array = item[a];
        System.out.println(array);
        Scanner x = new Scanner(System.in);




        JFrame game=new JFrame("game");
        game.setBounds(100,100,400,400);

        game.setLayout(null);
        JLabel user1=new JLabel("User Input");
        user1.setBounds(10,10,100,30);
        JTextField userInput=new JTextField();
        userInput.setBounds(120,10,200,30);

        JButton submit=new JButton("Submit");
        submit.setBounds(150,90,100,30);

        JLabel out1=new JLabel();
        JLabel out2=new JLabel();
        JLabel out3=new JLabel();
        JLabel out4=new JLabel();
        out1.setBounds(100,130,100,30);
        out2.setBounds(100,170,100,30);
        out3.setBounds(100,200,100,30);
        out4.setBounds(100,230,200,30);

        game.add(user1);game.add(userInput);game.add(submit);
        game.add(out1);game.add(out2);game.add(out3);game.add(out4);
        game.setVisible(true);


        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user = userInput.getText();
                if (user.equals(array)) {
                    System.out.println("ty");

                } else if (user.equals("Rock") && array.equals("Scissor")) {
                    out1.setText("won user");
                    flag++;
                } else if (user.equals("Paper") && array.equals("Rock")) {
                    //System.out.println("won user");
                    out1.setText("won user");
                    flag++;
                } else if (user.equals("Scissor") && array.equals("Paper")) {
                    // System.out.println(" user won");
                    out1.setText("won user");
                    flag++;
                } else {

                    out2.setText("won System");
                    y++;
                }

                out3.setText("chances left" + (3 - z));
                if (flag >= 2) {
                    System.out.println("you won Finally");
                    out4.setText("you won Finally");
                }
                if (y >= 2) {
                    System.out.println("Finally System won");
                    out4.setText(" Finally System won");
                }
                z++;
            }

        };submit.addActionListener(ac);
    }

    public static void main(String[] args) {
        GuiRandomGame g=new GuiRandomGame();
        g.game();

    }
}