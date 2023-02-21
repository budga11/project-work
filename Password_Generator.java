import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class Password_Generator  {
    static   Random pwd1;
    static int passw;

    static String  n,r,d, m,em;
    static String Name,Password,Email_ID,rank,pp,mobile;
    int a=1;


    void login()  {

        JFrame f = new JFrame("LOGIN PAGE");
        f.setBounds(100,100,500, 400);
        f.setLayout(null);
        JPanel p = new JPanel();
        p.setBounds(10, 10, 470, 350);
        p.setLayout(null);
        p.setBackground(Color.decode("#9677d4"));

        f.add(p);
        JLabel l = new JLabel("Username");
        l.setBounds(20, 20, 80, 30);
        JLabel l1 = new JLabel("Password");
        l1.setBounds(20, 80, 80, 30);
        p.add(l);
        p.add(l1);
        JTextField tf = new JTextField();
        tf.setBounds(130, 20, 300, 30);
        JPasswordField pwd = new JPasswordField();
        pwd.setBounds(130, 80, 300, 30);
        JButton LLogin = new JButton("Login");
        LLogin.setBackground(Color.decode("#77d4b3"));
        LLogin.setBounds(130, 140, 100, 30);
        JButton Register = new JButton("Register");
        Register.setBackground(Color.decode("#e65e99"));
        Register.setBounds(300, 140, 100, 30);

        JLabel showl=new JLabel();
        showl.setBounds(50,200,200,30);

        String[] columnNames = {"S.No.", "Name", "Rank","Domain","Mobile_NO."};

        Object[][] data = {};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);


        JTable jt = new JTable(tableModel);
        jt.setBounds(50, 230, 400, 100);
        JScrollPane sc=new JScrollPane(jt);
        sc.setBounds(50, 230, 400, 100);
        jt.setBackground(Color.LIGHT_GRAY);

        p.add(tf);
        p.add(pwd);
        p.add(LLogin);
        p.add(Register);
        JLabel l3 = new JLabel();
        l3.setBounds(60, 200, 400, 30);
        p.add(l3);
        p.add(showl);

        jt.setVisible(false);
        f.setVisible(true);



        JFrame f1=new JFrame("TCG ENROLLMENT");
        f1.setBackground(Color.decode("#9677d4"));
        f1.setBounds(500,100,420,420);
        f1.setLayout(null);
        JPanel panel=new JPanel();
        panel.setBackground(Color.decode("#9677d4"));
        panel.setBounds(5,5,410,410);
        panel.setLayout(null);
        f1.add(panel);
        JLabel Title=new JLabel("TCG ENROLLMENT");
        Title.setBounds(110,5,200,30);
        Title.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel Name=new JLabel("Name");
        Name.setBounds(30,50,70,25);
        JLabel Rank=new JLabel("Rank");
        Rank.setBounds(30,90,70,25);

        JLabel Domain=new JLabel("Domain");
        Domain.setBounds(30,130,70,25);
        JLabel Mobile=new JLabel("Mobile No.");
        Mobile.setBounds(30,170,70,25);
        JLabel Email=new JLabel("Email ID");
        Email.setBounds(30,210,70,25);
        panel.add(Title);panel.add(Name);panel.add(Rank);panel.add(Domain);
        panel.add(Mobile);panel.add(Email);
        JTextField Namet=new JTextField();
        Namet.setBounds(100,50,200,20);
        JTextField Rankt=new JTextField();
        Rankt.setBounds(100,90,200,20);
        JTextField Domaint=new JTextField();
        Domaint.setBounds(100,130,200,20);
        JTextField Mobilet=new JTextField();
        Mobilet.setBounds(100,170,200,20);
        JTextField Emailt=new JTextField();
        Emailt.setBounds(100,210,200,20);
        JButton SUBMIT=new JButton("SUBMIT");
        SUBMIT.setBounds(150,260,100,25);

        JButton Login=new JButton("Login");
        Login.setBounds(150,300,100,25);

        JLabel show= new JLabel();
        JLabel show1= new JLabel();
        JLabel show2= new JLabel();
        show.setBounds(100,325,300,25);
        show1.setBounds(100,350,300,25);
        show2.setBounds(100,375,300,25);



        panel.add(Namet);panel.add(Rankt);panel.add(Domaint);
        panel.add(Mobilet);panel.add(Emailt);panel.add(SUBMIT);
        panel.add(Login);
        panel.add(show);
        panel.add(show1);
        panel.add(show2);

        n=Namet.getText();
        r=Rankt.getText();
        d= Domaint.getText();
        m=Mobilet.getText();
        em= Emailt.getText();
        ActionListener login=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Prahlad","root","12345");
                    Statement smt=con.createStatement();

                    String qr = "Select * from TcgEnrollment1";
                    ResultSet rs = smt.executeQuery(qr);
                    while (rs.next()) {
                        String Name = rs.getString("Name");
                        String Password = rs.getString("Password");
                        String Email_ID = rs.getString("Email_ID");
                        String rank = rs.getString("Rank1");
                        String pp = rs.getString("Domain");
                        String mobile = rs.getString("Mobile_NO");
                        String id=rs.getString("id");

                        if (tf.getText().equals(Email_ID) && pwd.getText().equals(Password)) {
                            showl.setText("");
                            p.add(sc);
                            jt.setVisible(true);
                            Object[] data = {id, Name, rank, pp, mobile};
                            tableModel.addRow(data);
                        }
                        else{

                            showl.setText("please register before login");
                        }
                    }

                }catch (Exception y){
                    System.out.println(y);
                }

            }
        };LLogin.addActionListener(login);
        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                f.setVisible(false);
                showl.setText("");
                tf.setText("");
                pwd.setText("");
                jt.setVisible(false);
            }
        };Register.addActionListener(ac);
        ActionListener ac1=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwd1=new Random();
                passw=pwd1.nextInt(1111,9999);
                n=Namet.getText();
                r=Rankt.getText();
                d= Domaint.getText();
                m=Mobilet.getText();
                em= Emailt.getText();
                if(!n.equals("")&&!r.equals("")&&!d.equals("")&&!m.equals("")&&!em.equals("")) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Prahlad", "root", "12345");
                        Statement smt = con.createStatement();


                        System.out.println("table created sucessfully");

                        String qr = "Select * from TcgEnrollment1";
                        ResultSet rs = smt.executeQuery(qr);
                        while (rs.next()) {
                            Password = rs.getString("Password");
                            Email_ID = rs.getString("Email_ID");
                            rank = rs.getString("Rank1");
                            pp = rs.getString("Domain");
                            mobile = rs.getString("Mobile_NO");
                        }

                        if(!em.equals(Email_ID)) {
                            PreparedStatement psmt = con.prepareStatement("insert into TcgEnrollment1 values(?,?,?,?,?,?,?)");


                            psmt.setInt(1, 0);
                            psmt.setString(2, n);
                            psmt.setString(3, r);
                            psmt.setString(4, d);
                            psmt.setString(5, m);
                            psmt.setString(6, em);
                            psmt.setInt(7, passw);

                            psmt.executeUpdate();
                            System.out.println(passw + "\t" + em);
                            show.setText("Your Registration is done");
                            show1.setText("Your password is  " + passw);
                        } else{show.setText("You are already registred");
                            show1.setText("");}


                    } catch (Exception y) {
                        System.out.println(y);
                    }
                } else{show.setText("Please fill any details");
                    show1.setText("");}
            }
        };SUBMIT.addActionListener(ac1);

        ActionListener log=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                f.setVisible(true);
            }
        }; Login.addActionListener(log);
    }


    public static void main(String[] args) throws SQLException {
        Password_Generator t=new Password_Generator();

        t.login();
        System.out.println(passw);
    }
}
