import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
//This method returns an integer that is the number of points in Shape s. 
public int getNumPoints(Shape s) {
    int numPoints = 0;
    for (Point currPt : s.getPoints()) {
        numPoints += 1;
}
return numPoints;
}
// This method returns a number of type double that is the calculated average of all the sides’ lengths in the Shape S.
    public double getAverageLength(Shape s) {
   double averageLength = getPerimeter(s)/getNumPoints(s);
    return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);  
            if(currDist > largestSide){
                largestSide = currDist;
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currX = getX(currPt);  
            if(currX > largestX){
                largestX = currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largeX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("numPoints = " + points);
        System.out.println("average length = " + averageLength);
        System.out.println("largest side = " + largestSide);
        System.out.println("largest X = " + largeX);

    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    // has no return value, hence its return type is void. 
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    // has no return value, hence its return type is void. 
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
// has no return value, hence its return type is void. 
    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
