import java.util.LinkedList;


public class DistinctAbsoluteTest {
	public static void main(String[] args){
		int[] a = {-5,-6,-3,-1,0,3,6,7};
		DistinctAbsoluteTest sol = new DistinctAbsoluteTest();
		
		System.out.println(sol.absDistinct(a));
		
	}
	public int absDistinct ( int[] A ) {
		LinkedList<Integer> abs = new LinkedList<Integer>();
		for (int i = 0; i < A.length; i++){
			
			int abInt = 0;
			int val = A[i];
			if (val < 0){
				abInt = val * -1;
			} else {
				abInt = A[i];
			}
			boolean found = false;
			for (int j = 0; j < abs.size() && !found; j++){
				Integer abval = abs.get(j);
				if (abval.intValue() == abInt){
					//already have it
					found = true;
				} else {
					//continue
				}
			}
			if (!found){
				abs.add(abInt);
			}
			
		}
		return abs.size();
	}
}