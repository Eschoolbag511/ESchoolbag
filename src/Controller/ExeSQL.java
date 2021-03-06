package Controller;

import Model.Course;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Sql执行类
 * Created by dell on 2016/5/4.
 */
public class ExeSQL {
    private Connection conn = null;
    private PreparedStatement statement = null;
    private ResultSet rs = null;

   // 连接到数据库
   public void connSQL() {
        String url = "jdbc:mysql://localhost:3306/e-schoolbag";
        String username = "root";
        String password = ""; // 加载驱动程序以连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }
        //捕获加载驱动程序异常
        catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "装载 JDBC/ODBC 驱动程序失败。");
            cnfex.printStackTrace();
        }
        //捕获连接数据库异常
        catch (SQLException sqlex) {
            System.err.println("无法连接数据库");
            sqlex.printStackTrace();
        }
    }

    // disconnect to MySQL
    void deconnSQL() {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            System.out.println("关闭数据库问题 ：");
            e.printStackTrace();
        }
    }

    //返回所有课程list
    public ArrayList<Course> GetCourseList(){
        String sql;
        sql="SELECT *FROM course";
        rs = selectSQL(sql);
        ArrayList<Course> CourseList = new ArrayList<Course>();
        try {
            while (rs.next()){
                Course course  = new Course();
                course.setId(rs.getString("id"));
                course.setName(rs.getString("name"));
                course.setGrade(rs.getInt("grade"));
                course.setTeacherid(rs.getString("teacherid"));
                course.setUrl(rs.getString("url"));
                CourseList.add(course);
            }
        }catch (SQLException e) {
            System.out.println("显示时数据库出错。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("显示出错。");
            e.printStackTrace();
        }
        return CourseList;
    }

    //返回所有用户的list
    public ArrayList<User> GetUserList(){
        String sql;
        sql = "select * from user";
        rs = selectSQL(sql);
        ArrayList<User> UserList = new ArrayList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPsd(rs.getString("psd"));
                user.setType(rs.getInt("type"));
                user.setProfile(rs.getString("profile"));
                UserList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("显示时数据库出错。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("显示出错。");
            e.printStackTrace();
        }

        return UserList;
    }

    //登录验证函数
    public boolean Login(String uid,String psd){
        String sql;
        sql = "select psd from user WHERE id='"+uid+"'";
        rs = selectSQL(sql);
        try{
            while (rs.next()){
                if (psd.equals(rs.getString("psd")))
                    return true;
            }
        } catch (SQLException e) {
            System.out.println("显示时数据库出错。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("显示出错。");
            e.printStackTrace();
        }
        return false;
    }

    //通过id找到对应user
    public User GetUserByid(String uid){
        String sql;
        sql="SELECT * FROM user WHERE id='"+uid+"'";
        rs = selectSQL(sql);
        User user = new User();
        try {
            while(rs.next()){
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setType(rs.getInt("type"));
            user.setProfile(rs.getString("profile"));
            }
        }catch (SQLException e) {
            System.out.println("显示时数据库出错。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("显示出错。");
            e.printStackTrace();
        }
        return user;
    }

    //查
    ResultSet selectSQL(String sql) {
        ResultSet r1 = null;
        try {
            statement = conn.prepareStatement(sql);
            r1 = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r1;
    }
    //改
    boolean updateSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("插入数据库时出错");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("插入时出错：");
            e.printStackTrace();
        }
        return false;
    }

    //删
    boolean deleteSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("插入数据库时出错");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("插入时出错");
            e.printStackTrace();
        }
        return false;
    }

    //增
    boolean insertSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("插入数据库时出错：");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("插入时出错：");
            e.printStackTrace();
        }
        return false;
    }

}
