
/**
* This class contains methods to manipulate 1-2 year parameters
* to calculate leap year
* 
* @date 20160823
*/
public class LeapYear {
	
	/**
	*	Tests the parameter if it is a leap year or not
	* 
	* @param year
	* @return boolean
	*/
	public boolean findOut(int year) {
		if ((year % 100 == 0) && (year % 400 == 0) )
			return true;
		else if ((year % 100 != 0) && (year % 4 == 0))
			return true;
			
		return false;
	}
	
	/**
	*	Counts how many leap years are between 2 years. Includes
	* the parameter years in counting if they are leap years.
	* Problem: I'd like this function to return a result based
	* on a few math formula, as much as possible.
	* 
	* @param year1, year2
	* @return int
	*/
	public int countBetween(int year1, int year2) {
		/*
		float diff = year2 - year1;
		float lastBooleanYearCount = findOut(year2) ? 1 : 0;
		if (diff >= 400f) { // Something wrong here... +/-1 to result
			int result = (year2 - year1) / 4;
			System.out.println(result);
			
			float subtractor = ((year2 - year1) / 400f * 2f) 
				+ lastBooleanYearCount
			System.out.println(subtractor);
			
			return Math.round(result - subtractor);
		}
		
		return Math.round((year2 - year1) / 4f) 
			+ lastBooleanYearCount;
		//*/
		int noOfYears = 0;
		for (int i = year1; i <= year2; i++) {
			if (findOut(i))
				noOfYears++;
		}
		
		return noOfYears;
	}
	
	/**
	*	Lists all leap years between the parameters
	* 
	* @param year1, year2
	* @return int[]
	*/
	public int[] list(int year1, int year2) {
		int[] leapYears = new int[countBetween(year1, year2)];
		
		int j = 0;
		for (int i = year1; i <= year2; i++) {
			if (findOut(i)) {
				leapYears[j] = i;
				j++;
			}
		}
		
		return leapYears;
	}
	
	/*
	* Because I'm feeling sleepy right now because it's 1:29 AM, I 
	* tested the methods using this main() method.
	* 
	* Test data so far:
	* 2000-2100
	* 2000-2400 (having problem with this test data on list())
	* 2000-2800 (having problem with this test data on list())
	* 2000-2000
	* 1999-1999
	* 0-4 (having problem with this test data on countBetween(), 
	*	maybe because 1 * 4 = 4)
	* 0-0 (having problem with this test data on countBetween())
	* 1-1 (having problem with this test data on countBetween())
	* 2400-2100 (don't know if this is really an error but...)
	*/
	public static void main(String[] args) {
		
		int year1 = Integer.parseInt(args[0]);
		int year2 = Integer.parseInt(args[1]);
		LeapYear l = new LeapYear();
		
		System.out.printf("Is year %s, a leap year? ", args[0]);
		System.out.println(l.findOut(year1));
		System.out.println();
		
		System.out.printf("No. of leap years between %s and %s "
			, args[0], args[1]);
		System.out.println(l.countBetween(year1, year2));
		System.out.println();
		
		int[] leapYears = l.list(year1, year2);
		System.out.printf("Leap years between %s and %s."
			, args[0], args[1]);
			
		for (int year : leapYears)
			System.out.println(year);
	}
}