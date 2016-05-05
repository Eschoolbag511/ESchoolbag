package View;

import Controller.ExeSQL;
import Model.Course;
import Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

        JTable table=new JTable(){ public boolean isCellEditable(int row, int column) { return false;}};
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addColumn("课程名称");
        tableModel.addColumn("上传人");
        tableModel.addColumn("年级");
        tableModel.addColumn("链接");
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane pane=new JScrollPane(table);
        Container contentPane=this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JComboBox jcb1=new JComboBox<String>();
        jcb1.addItem("请选择");
        jcb1.addItem("大学一年级");
        jcb1.addItem("大学二年级");
        jcb1.addItem("大学三年级");
        jcb1.addItem("大学四年级");

        ArrayList<Course> CourseList =sql1.GetCourseList();
        for(Course exp:CourseList){
            String[] rowValues = {
                    exp.getName(),exp.getTeacherid(),exp.getGrade().toString(),exp.getUrl()
            };
            tableModel.addRow(rowValues);
        }


        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn())){
                    if(table.getSelectedRow()==0){
                        System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                        JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });

        JButton filter=new JButton("筛选");
        JPanel J1 =new JPanel();
        J1.add(jcb1);
        J1.add(filter);
        this.add(J1,BorderLayout.NORTH);
        this.add(pane,BorderLayout.CENTER);
        this.setSize(600, 500);
        this.setLocation(300, 200);
        this.setVisible(true);
    }
}
