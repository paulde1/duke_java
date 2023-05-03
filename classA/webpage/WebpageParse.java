package classA.webpage;
import edu.duke.*;

public class WebpageParse {
    public void readWebpage() {
        URLResource file = new  URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String item : file.words()) {
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"",pos); //find the specified string backwards
                int end = item.indexOf("\"", pos+1); //finds the specified string forwards
                System.out.println(item.substring(beg+1,end));
                System.out.println(item.substring(beg,end));

            }
       	}
    }
}
