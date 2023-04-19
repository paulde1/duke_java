package classC.EarthquakeSort;
import java.utils.*;

public class QuakeSort {
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from){
    int minimumIndex = from;
    for(int i = from +1; i < quakes.size(); i++) {
        if(quakes.get(i).getMagnitude() < quakes.get(minimumIndex).getMagnitude()){
            minimumIndex = i;
        }
    }
    return minimumIndex;
 }
 public void sortByMagnitude(ArrayList<QuakeEntry> in) {
    for (int i = 0; i < in.size(); i++) {
        int minimumIndex = getSmallestMagnitude(in, i);
        QuakeEntry qi = in.get(i);
        QuakeEntry qmin = in.get(minimumIndex);
        in.set(i, qmin);
        in.set(minimumIndex, qi);
    }
 }
 public void testSort () {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "data/nov20quakedata.atom";
    ArrayList < QuakeEntry> list = parser.read(source);
    sortByMagnitude(source);
 }
}
