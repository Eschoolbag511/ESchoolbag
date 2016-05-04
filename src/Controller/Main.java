package Controller;

import Model.User;

import java.util.ArrayList;

/**
 * Created by dell on 2016/5/4.
 */
public class Main {

    public static  void main(String arg[]){
        ExeSQL sql1=new ExeSQL();
        sql1.connSQL();
        ArrayList<User> userlist = new ArrayList<User>();
        userlist = sql1.GetUserList();
        for (User exp:userlist){
            System.out.println(exp.getId());
        }
    }
}
