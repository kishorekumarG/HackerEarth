import java.util.Scanner;

public class TidyNumbers {
public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Getting input from user
		int noOfTestCase = input.nextInt();
		long[] number = new long[noOfTestCase];
		long[] result = new long[noOfTestCase];
		
		//System.out.println("Enter the number : ");
		for(int i =0; i < noOfTestCase; i++){
			number[i] = input.nextLong();
		}
		input.close();
		
		for(int i = 0; i < noOfTestCase; i++){
				long res = checkTidy(number[i]);
				result[i] = res;
		}
		
		//Print Output
		for(int i = 0; i < noOfTestCase; i++){
			System.out.println(result[i]);
		}
	}
	
	//Converting Integer to String
	public static String convert(long number)
	{
	    long quotient = number/10;
	    long remainder = number%10;

	    if (quotient == 0)
	    {
	        return (remainder+"");      
	    }
	    else 
	    	return convert(quotient) + " " + remainder;	                
	}
	
	//Checking for tidy number
	public static long checkTidy(long number)
	{
		String str = null;
		int descendingOrder = 0;
		str = convert(number);
		String numberString[] = str.split(" ");
		for(int j = numberString.length-1; j > 0; j--){
			if(Integer.parseInt(numberString[j]) >= Integer.parseInt(numberString[j-1]))
				descendingOrder++;
		}
		if(descendingOrder < numberString.length-1)
			return checkTidy(number - 1);
		return number;
	}
}