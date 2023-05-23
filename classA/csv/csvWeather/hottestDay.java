package classA.csv.csvWeather;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class hottestDay {
     public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;   //start with largestSoFar as nothing
        for(CSVRecord currentRow : parser) {   //For each row (currentRow) in the CSV File
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar); //If largestSoFar is nothing
        }
        return largestSoFar //largestSoFar is our answer
    }
    
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord current = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(current, largestSoFar);
        }
        return largestSoFar;
    }
    
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        if(largestSoFar == null) {
            largestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if(currentTemp > largestTemp) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }
    
    public void testHottestInDay() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("Hottest Temperature was: " + largest.get("TemperatureF") +
     " at " + largest.get("TimeEST"));
    }
    
    public void testHottestInManyDays() {
        CSVRecord largest = hottestInManyDays();
        System.out.println("Hottest Temperature was: " + largest.get("TemperatureF") +
         " at " + largest.get("DateUTC"));
    }
}
