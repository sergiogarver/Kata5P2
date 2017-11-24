package kata5P2.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuider;
import kata5P2.view.MailListReaderDDBB;

public class Kata5P2 {
    private List<Mail> mailList;
    private String filename;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        Kata5P2 kata5P2 = new Kata5P2();
        kata5P2.execute();      
    }
    public void execute() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }
    
    public void input() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata5P2\\KATA.sDB";
        mailList = MailListReaderDDBB.read(filename);
    
    }
    
    public void process(){
        histogram = MailHistogramBuider.build(mailList);
    }
    
    public void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();      
    }

    
}
