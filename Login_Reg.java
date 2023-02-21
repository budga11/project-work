import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Login_Reg {

    // Class.forname()
    String user,pass,name1,name2,Mobile,Add;
    static JButton Home;
    static JFrame reg;
    static JFrame log;
    void register() {
        reg = new JFrame("Registeration Page");
        reg.setSize(600, 500);
        reg.setLocation(650, 40);
        reg.setLayout(null);
        JPanel p = new JPanel();
        p.setBounds(10, 10, 580, 480);
        p.setLayout(null);

        reg.add(p);
        JLabel l = new JLabel("First Name");
        l.setBounds(10, 10, 120, 30);
        JTextField tf = new JTextField();
        tf.setBounds(130, 10, 300, 30);
        p.add(l);
        p.add(tf);
        JLabel l1 = new JLabel("Last Name");
        l1.setBounds(10, 50, 120, 30);
        JTextField t1 = new JTextField();
        t1.setBounds(130, 50, 300, 30);
        p.add(l1);
        p.add(t1);
        JLabel l2 = new JLabel("Username/email");
        l2.setBounds(10, 90, 120, 30);
        JTextField t2 = new JTextField();
        t2.setBounds(130, 90, 300, 30);
        p.add(l2);
        p.add(t2);
        JLabel l3 = new JLabel("Password");
        l3.setBounds(10, 130, 120, 30);
        JPasswordField pwd = new JPasswordField();
        pwd.setBounds(130, 130, 300, 30);
        p.add(l3);
        p.add(pwd);
        JLabel l5 = new JLabel("Mobile No.");
        l5.setBounds(10, 170, 120, 30);
        JTextField t5 = new JTextField();
        t5.setBounds(130, 170, 300, 30);
        p.add(l5);
        p.add(t5);
        JLabel l4 = new JLabel("Address");
        l4.setBounds(10, 210, 120, 30);
        JTextArea area = new JTextArea();
        area.setBounds(130, 210, 300, 50);
        p.add(l4);
        p.add(area);

        JButton b1 = new JButton("Register");
        b1.setBounds(220, 280, 120, 30);
        b1.setBackground(Color.CYAN);
        JLabel label = new JLabel();
        label.setBounds(100, 320, 400, 30);
        p.add(b1);
        p.add(label);

        Home=new JButton("Home");
        Home.setBounds(220,330,120,30);
        p.add(Home);
        reg.setVisible(true);


        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = t2.getText();
                pass = pwd.getText();
                name1 = tf.getText();
                name2 = t1.getText();
                Mobile = t5.getText();
                Add = area.getText();
                try {
                    if (!user.equals("") && !pass.equals("") && !name1.equals("") && !name2.equals("")
                            && !Mobile.equals("") && !Add.equals("")) {
                        if (user.contains("@") && user.contains(".") && Mobile.length()==10) {


                            BufferedReader reader=new BufferedReader(new FileReader("src/DataInput.txt"));
                            String line="";

                            boolean alreadyRegistered = false;
                            while ((line = reader.readLine()) != null) {
                                if (line.contains(user)) {
                                    alreadyRegistered = true;
                                    break;
                                }
                            }
                            reader.close();

                            if (!alreadyRegistered) {
                                FileWriter fw = new FileWriter("src/DataInput.txt", true);
                                fw.write(name1 + name2 + "\n" + user + "\n" + pass + "\n" + Mobile + "\n" + Add + "\n");
                                fw.close();
                                label.setText("Registration successful");
                                System.out.println("congratulations");
                            }else {
                                label.setText("You are already registered. Try logging in");
                            }
                        } else {
                            System.out.println("Invalid Username/Email");
                            label.setText("Invalid Username/Email or Mobile no. ");
                        }
                    }else{
                        label.setText("Empty Fields!!!!");
                    }


                }catch(Exception i){
                    System.out.println(i);
                }
            }
        }

                ;b1.addActionListener(ac);
        ActionListener h=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                log.setVisible(true);
                reg.setVisible(false);
            }
        };Home.addActionListener(h);

    }
    void login(){
        log=new JFrame("Login page");

        log.setSize(600,500);
        log.setLocation(50,20);
        log.setLayout(null);
        JPanel p=new JPanel();
        p.setBounds(10,10,580,480);
        p.setLayout(null);
        log.add(p);
        JLabel l=new JLabel("Username");
        l.setBounds(10,10,60,30);
        JLabel l1=new JLabel("Password");
        l1.setBounds(10,60,60,30);
        JButton Login=new JButton("Login");
        Login.setBounds(180,110,100,30);
        Login.setBackground(Color.PINK);
        JTextField tf=new JTextField();
        tf.setBounds(100,10,300,30);
        JPasswordField pwd=new JPasswordField();
        pwd.setBounds(100,60,300,30);
        JLabel l2=new JLabel("New user ? Register here/Activate ");
        l2.setBounds(120,180,300,30);
        l2.setBackground(Color.YELLOW);
        JButton Register=new JButton("Register");
        Register.setBounds(180,240,100,30);
        Register.setBackground(Color.CYAN);
        JLabel label=new JLabel();
        label.setBounds(150,320,300,30);
        p.add(label);
        p.add(l);p.add(l1);p.add(pwd);p.add(Login);p.add(tf);p.add(l2);p.add(Register);
        log.setVisible(true);

        JFrame f1=new JFrame("Login data");
        f1.setSize(300,300);
        f1.setLocation(400,500);
        f1.setLayout(null);
        ActionListener click=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user=tf.getText();
                String pass=pwd.getText();
                try{
                    if (!user.equals("") && !pass.equals("")) {
                        //    FileReader rd = new FileReader("src/DataInput.txt");
                        BufferedReader reader = new BufferedReader(new FileReader("src/DataInput.txt"));
                        String line = "";
                        Scanner sc = new Scanner(reader);
                        while (sc.hasNextLine()) {
                            line = sc.nextLine();
                            System.out.println(line);
                            System.out.println(user);
                            if (line.contains(user) ) {
                                label.setText("Login Successful");
                                f1.setVisible(true);
                                break;
                            } else {
                                label.setText("Invalid username or password");
                            }
                        }
                    } else {
                        label.setText("Username and password cannot be empty");
                    }
                }      catch (Exception n){
                    System.out.println(n);
                }

            }
        };Login.addActionListener(click);
        ActionListener ok=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                register();
                log.setVisible(false);
            }
        };Register.addActionListener(ok);

    }
    public static void main(String[] args) {
        Login_Reg l=new Login_Reg();
        l.login();
        // l.register();

    }
}