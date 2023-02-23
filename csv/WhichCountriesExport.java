import edu.duke. *;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportsOfInterests){
        //for each row in the CSV
            //check the exports column contains exports
            //if true print country from row 
            for(CSVRecord record : parser){
                String export = record.get("Exports");
                if(export.contains(exportsOfInterests)) {
                    String country = record.get("Country");
                    System.out.println(country);
                }
            }
    }
    public  void whoExportsCoffee () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser,"coffee");
    }
}