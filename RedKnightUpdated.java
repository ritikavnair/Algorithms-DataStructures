package WorldCodeSprint12;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.awt.Point;

public class RedKnightUpdated {

    // Private members
	static int n ;
	static int i_start;
	static int j_start ;
	static int i_end ;
	static int j_end ;

    //  Prints the distance along with the sequence of moves.
    static void printShortestPath() {
        
        int curr_i = i_start;
        int curr_j = j_start;
        List<String> steps = new ArrayList<String>();
        
        // distance of curr_i,curr_j to the end point.
        double curr_dist = distanceToEnd(new Point(i_start, j_start));
        
        // Priorty list of directions
        List<String> directions = Collections.unmodifiableList(Arrays.asList("UL","UR","R","LR","LL","L"));
        Map<String, Point> directionPointMap = new HashMap<String, Point>();
        
        // End when current and end point are the same.
        while(curr_dist != 0){          
            
            // Adding the estimated next point in each direction into a map.
        	for(String direction : directions) {
        		directionPointMap.put(direction, nextPoint(curr_i, curr_j, direction));
        	}   	
        	
            // Find the closest distance that a next point in the above map, has to the end point.
            Double nextSmallestStep = closet(directionPointMap);
           
            // If no next point exists, then it is impossible to reach end point.
            if (nextSmallestStep == null)
            	break;
            
            // For multiple next points that are at same distance from end point,
            // follow the priority list.
            for(String direction : directions) {
            	Point nextPointInDirection = directionPointMap.get(direction);
        		if(nextPointInDirection != null && 
        				distanceToEnd(nextPointInDirection) == nextSmallestStep) {
        			curr_i = nextPointInDirection.x;
                    curr_j = nextPointInDirection.y;
                    steps.add(direction);
                    break;
        		}
        			
        	}
            
            // Update current distance to reflect the jump to the next point.
            curr_dist = distanceToEnd(new Point(curr_i, curr_j));
        }
        
        // If the end point was successfully reached, then print the steps.
        if(curr_i==i_end && curr_j==j_end){
        	System.out.println(steps.size());
        	String stepsPrint =  steps.stream().collect(Collectors.joining(" "));
        	System.out.println(stepsPrint);
        }
        else {
        	System.out.println("Impossible");
        }
    }
    
    // Returns the closest distance that a point in the map, has to the end point.
    static Double closet(Map<String, Point> directionPointMap) {
    	Map<String, Double> directionDistMap = new HashMap<String, Double>();
    	for (Map.Entry<String, Point> entry : directionPointMap.entrySet()) {
    		if(entry.getValue() !=null)
    			directionDistMap.put(entry.getKey(), distanceToEnd(entry.getValue()));    			
    	}
    	
    	Optional<java.util.Map.Entry<String, Double>> closetDist = directionDistMap.entrySet().stream().min((e1,e2) -> e1.getValue().compareTo(e2.getValue()));
    	if(closetDist.isPresent())	
    		return closetDist.get().getValue();
    	else 
    		return null;
    	
    }
    

    // Returns the next point in a particular direction
    static Point nextPoint(int i, int j, String direction) {
    	
    	int next_i = i, next_j = j;
    	
    	switch(direction) {
    	
    	case "UL": next_i = i - 2; next_j = j - 1; break;
    	case "UR": next_i = i - 2; next_j = j + 1; break;
    	case "R":  next_i = i;     next_j = j + 2; break;
    	case "LR": next_i = i + 2; next_j = j + 1; break;
    	case "LL": next_i = i + 2; next_j = j - 1; break;
    	case "L":  next_i = i;     next_j = j - 2; break;
    	}
    	if (i < 0 || j < 0 || i>=n || j >= n)
            return null;
        else
            return new Point(next_i,next_j);
    }
    
    // Returns the distance of a particular point to the end point.
    static double distanceToEnd(Point a){
        return Math.sqrt(Math.pow((i_end - a.getX()),2) + Math.pow((j_end - a.getY()),2));
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        i_start = in.nextInt();
        j_start = in.nextInt();
        i_end = in.nextInt();
        j_end = in.nextInt();
        printShortestPath();
        in.close();
    }
}

