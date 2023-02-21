import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notes {

    static void note(){
        JFrame f=new JFrame("Notes");
        f.setLayout(null);
        f.setBackground(Color.pink);
        f.setBounds(100,100,500,500);
        JPanel p=new JPanel();
        p.setBackground(Color.decode("#c883fc"));
        p.setLayout(null);
        p.setBounds(05,05,855,450);
        f.add(p);


        JLabel title=new JLabel("Write Notes:-");
        title.setBounds(100,10,200,30);
        title.setFont(new Font("Arial",Font.BOLD,18));

        JLabel name=new JLabel("Enter File Name:-");
        JTextField file=new JTextField();
        name.setBounds(20,40,100,30);
        file.setBounds(135,50,305,30);

        JTextArea writ = new JTextArea();
        writ.setBounds(130,100,300,260);
        JScrollPane scrollPane = new JScrollPane(writ);
        scrollPane.setBounds(130,100,300,260);
        p.add(scrollPane);


        JButton save=new JButton("Save Notes");
        JButton update=new JButton("Update Notes");
        JButton show=new JButton("Show Notes");
        save.setBounds(130,390,100,20);
        update.setBounds(300,390,110,20);
        show.setBounds(10,150,110,20);

        JTextArea showdata=new JTextArea();
        showdata.setBounds(505,10,335,425);
        JScrollPane scrollPane1 = new JScrollPane(showdata);
        scrollPane1.setBounds(505,10,335,425);

        showdata.setEditable(false);



        JComboBox<String> cfile = new JComboBox<String>();
        //JComboBox cfile=new JComboBox(fname);
        cfile.setBounds(05,100,120,25);
        p.add(cfile);

        p.add(show);

        p.add(save);p.add(update);
        p.add(name);f.add(file);
        p.add(title);
        File folder = new File("C:\\Users\\admin\\IdeaProjects\\First_project");
        File[] listOfFiles = folder.listFiles();

        for (File file1 : listOfFiles) {
            if (file1.isFile()) {
                cfile.addItem(file1.getName());}}
        ActionListener a=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename=file.getText();
                //cfile.addItem(filename);


                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))) {
                    String note;

                    System.out.println("Enter a note (type 'exit' to stop): ");
                    note = writ.getText();
                    if (note.equals("exit")) {
                    }
                    writer.write(note);
                    writer.newLine();




                    System.out.println("Notes stored successfully in " + filename);
                } catch (IOException ee) {
                    System.out.println("Error writing to file " + filename);
                    ee.printStackTrace();
                }
                writ.setText("");
                file.setText("");
                showdata.setText("");
            }
        };save.addActionListener(a);
        ActionListener upd=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String update=(String) cfile.getSelectedItem();
                file.setText(update);
                File file=new File("C:\\Users\\admin\\IdeaProjects\\First_project\\"+update);
                try {
                    BufferedReader reader=new BufferedReader(new FileReader(file));
                    String line;
                    while ((line=reader.readLine())!=null){
                        writ.append(line+"\n"); }

                }catch (Exception tt){
                    System.out.println(tt);
                }
            }
        };update.addActionListener(upd);
        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = (String) cfile.getSelectedItem();
                System.out.println(fileName);
                File file = new File("C:\\Users\\admin\\IdeaProjects\\First_project\\" + fileName);
                StringBuilder contents = new StringBuilder();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        contents.append(line);
                        contents.append(System.lineSeparator());
                    }
                    reader.close();
                    //  String filename=file.getText();
                    f.setBounds(100,100,880,500);
                    p.add(scrollPane1);

                  /*  writ.setText("");
                    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                        String line="";
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                           showdata.append(line+"\n"); }*/
                }catch (Exception y){
                    System.out.println(y);
                }
                showdata.setText(contents.toString());
            }
        };show.addActionListener(ac);

        for (File file1 : listOfFiles) {
            if (file1.isFile()) {
                cfile.addItem(file1.getName());}}

        f.setVisible(true);
    }
    public static void main(String[] args) {
        note();
    }
}
