package classC.EarthquakeSort;
import java.utils.*;

public class QuakeSort {
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quake);
    int minimumIndex = from;
    for(int i = from +1; i < quakes.size(); i++) {
        if(quakes.get(i).getMagnitude() < quakes.get(minimumIndex){
            minimumIndex = i;
        }
    }
    return minimumIndex;
}
