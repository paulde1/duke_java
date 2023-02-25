import static org.junit.Assert.*;
import org.junit.Test;
import org.apache.commons.csv.CSVParser;
import edu.duke.FileResource;
import edu.duke.DirectoryResource;
import java.io.File;

public class CSVWeatherTest {
    CSVWeatherReader wr = new CSVWeatherReader();
    CSVParser parser;

    private <T> void p(T t){System.out.print(t);}
    private <T> void pl(T t) {System.out.println(t);}
    
    private void getFile() {
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        
    }
    
    
    public void testColdestHourInFile() {
        
        getFile();
        CSVRecord coldest = wr.coldestHourInFile(parser);
        // print record:
        p("Lowest temperature in selected file: ");
        p(coldest.get(wr.TEMP_NAME));
        pl(" recorded: " + coldest.get(wr.UTC_DATE));
        
        
    }
    
    public void testFileWithColdestTemperature() {
        
        wr.fileWithColdestTemperature();

    }
    
    public void testLowestHumidityInFile() {
    
        getFile();
        CSVRecord lowest = wr.lowestHumidityInFile(parser);
        // print record:
        p("Lowest humidity in selected file: ");
        p(lowest.get(wr.HUM_NAME));
        pl(" recorded: " + lowest.get(wr.UTC_DATE));
    
    }
    
    public void testLowestHumidityInManyFiles(){
        
        wr.lowestHumidityInManyFiles();
        
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        getFile();
        int value = 80;
        wr.averageTemperatureWithHighHumidityInFile(parser, value);
    
    }
}