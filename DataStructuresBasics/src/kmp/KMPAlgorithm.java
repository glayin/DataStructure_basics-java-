package kmp;

public class KMPAlgorithm {
    public static void main(String[] args) {

		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		//String str2 = "BBC";
		
		int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
		System.out.println("next=" + Arrays.toString(next));
		
		int index = kmpSearch(str1, str2, next);
		System.out.println("index=" + index); // 15了



    }

    public static int[] KmpNext(String dest){

        int[] next = new int[dest.length()];

        for(int i = 0, j = 1; i < dest.length(); i++){
            //if the values of i and j are not equal, get the j from next[j-1]
            while (i>0 && dest.charAt())

            //when it the corresponding value of i matches j, j plus 1;
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
