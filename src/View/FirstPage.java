package View;

import Controller.ExeSQL;
import Model.User;

import javax.swing.*;

/**
 * Created by dell on 2016/5/4.
 */
public class FirstPage extends JFrame{
    public FirstPage(User user){
        ExeSQL sql1=new ExeSQL();
        sql1.connSQL();
        this.setTitle("ESchoolbag");
        JMenuBar jmb=new JMenuBar();
        JMenu UserName = new JMenu("欢迎您   "+user.getName());
        jmb.add(UserName);
        this.setJMenuBar(jmb);
        this.setSize(600, 500);
        this.setLocation(300, 200);
        this.setVisible(true);
    }
}
