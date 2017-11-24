package kata5P2.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5P2.model.Mail;


public class MailListReaderDDBB {
    public static List<Mail> read(String name) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        List<Mail> mailList = new ArrayList<Mail>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata5P2\\KATA.sDB");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM MAIL");
        while(rs.next()){
            mailList.add(new Mail(rs.getString("mail")));
        }
        return mailList;             
    }
}
