
public class Equi {

	public static void main (String[] args){
		String str = new String("aaa");
		System.out.println(str.length());
		System.out.println(str.charAt(3));
		Equi e = new Equi();
		int[] a = {-7, 1, 5, 2, -4, 3, 0};
		int output = e.equi(a);
		System.out.println(output);
	}
	
	//instead of using arrays here to hold the cumulative total we could use variables
	//run through and calc the total
	
	//should make our arrays long long instead of int since we need to hold a cumulative sum of ints.
	public int equi ( int[] A ) {
	 // write your code here
	 int equilibrium        = -1;
	 int arraySize         = A.length;
	 int[] upwardCount     = new int[arraySize];
	 int[] downwardCount   = new int[arraySize];
	 
	 for (int i = 0; i < arraySize; i++){
	     //case where we are on the first element
	     if (i == 0){
	         upwardCount[i] = A[i];
	         downwardCount[arraySize-1] = A[arraySize-1];
	     } else {
	         upwardCount[i] = upwardCount[i-1] + A[i];
	         downwardCount[arraySize-1-i] = downwardCount[arraySize-i] + A[arraySize-1-i];
	     }
	 }
	 StringBuilder builder = new StringBuilder();
	 for (int i = 0; i < arraySize; i++){
		 builder.append("["+i+"]"+upwardCount[i]+", ");
	 }
	 System.out.println(builder.toString());
	 StringBuilder downBuilder = new StringBuilder();
	 for (int i = 0; i < arraySize; i++){
		 downBuilder.append("["+i+"]"+downwardCount[i]+", ");
	 }
	 System.out.println(downBuilder.toString());
	 boolean found = false;
	 for (int i = 0; i < arraySize && !found; i++){
	     if (upwardCount[i] == downwardCount[i]){
	         equilibrium = i;
	         found = true;
	         System.out.println(i+",["+upwardCount[i]+"]["+downwardCount[arraySize-1-i]+"]");
	     }
	 }
	 
	 	return equilibrium;
	}


	
}
