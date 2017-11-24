package kata5P2.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata5P2.model.Histogram;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuider;
import kata5P2.view.MailListReader;

public class Kata5P2 {
    private List<String> mailList;
    private String filename;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();      
    }
    public void execute() throws FileNotFoundException, IOException{
        input();
        process();
        output();
    }
    
    public void input() throws FileNotFoundException, IOException{
        filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emailsFile.txt";
        mailList = MailListReader.read(filename);
    
    }
    
    public void process(){
        histogram = MailHistogramBuider.build(mailList);
    }
    
    public void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();      
    }

    
}
