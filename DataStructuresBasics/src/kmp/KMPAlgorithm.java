package kmp;

public class KMPAlgorithm {
    public static void main(String[] args) {





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
