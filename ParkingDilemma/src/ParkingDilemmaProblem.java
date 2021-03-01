import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParkingDilemmaProblem {

	public static void main(String[] args) {
		List<Long> cars = Arrays.asList(2L, 6L, 21L, 25L, 12L, 15L);
		int k = 3;
		long minParkingRoof = carParkingRoof(cars, k);
		System.out.println("Minimum Parking Roof length is: " + minParkingRoof);
	}
	
	public static long carParkingRoof(List<Long> cars, int k) {
	    // Write your code here
	        if (cars.size() == 0 || k < 0) {
	            return 0;
	        }

	        Collections.sort(cars);
	        long minDist = Long.MAX_VALUE;

	        for (int i = 0; i <= cars.size() - k; i++) {
	            minDist = Math.min(minDist, cars.get(i + k - 1) - cars.get(i));
	        }

	        return minDist + 1;
	    }

}
