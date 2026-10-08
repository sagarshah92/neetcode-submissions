class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }

        if (n==0){
            return 1;
        }

        long N = n;
        double res = calculatePow(x, Math.abs(N));

        return (n>0)?res:1/res;


    }

    double calculatePow(double x, long n){
        if(n==1){
            return x;
        }

        double half = calculatePow(x, n/2);

        return (n%2==0)? half*half : x*half*half;
    }
}
