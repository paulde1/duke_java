import edu.duke. *;
import org.apache.commons.csv.*;

public class CSV {
    public void readFood() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.get CSVParser();
        for(CSVRecord record : parser) {
            System.out.print(record.get("name") + " ");
             System.out.print(record.get("Favorite color "));
             System.out.println(record.get("Favorite food "));
        };
    };
};
