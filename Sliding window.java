public class Solution {
    public int solve(int[] A, int B) {
        // Brute force
        int min=Integer.MAX_VALUE;
        int index =0;
        for(int i =0;i<=A.length-B;i++){
            int sum = 0;
            for(int j = i;j<i+B;j++){
                sum = sum + A[j];
            }
            if(sum < min){
                min = sum;
                index = i;
            }
        }return index;

        // prefixSum
        int N = A.length;
        int P[] = new int [N];
        P[0] = A[0];
        for(int i = 1;i<N;i++){
            P[i] = P[i-1] + A[i];
        }
        int sum = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        int k = 0, e = B-1;
        while(e < N){
            if(k==0){
                sum = P[e];
            }else{
                sum = - P[k-1] + P[e];
            }
            if(sum<min){
                min = sum;
                index = k;
            }
            k++;
            e++; 
        }return index;


        // Sliding window
        int sum = 0;
        for(int i = 0;i<B;i++){
            sum = sum + A[i];
        }
        int min = sum;
        int j = 1, k = B,index = 0;
        while(k<A.length){
            sum = sum + A[k] - A[j-1];
            if(sum<min){
                min = sum;
                index = j;
            }
            j++;
            k++;
        }return index; 

    }
}
