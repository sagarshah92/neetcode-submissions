class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int total = nums1.length+nums2.length;
        int mindex =0;
        boolean isEven = false;
        if(total%2==0){
            mindex=(total/2);
            isEven = true;
        } else{
            mindex=total/2;
        }
        System.out.println(mindex);
        int n1index =0;
        int n2index =0;
        int prevprevnum=0;
        int prevnum=0;
        while(mindex>=0){
            if(n1index<nums1.length && n2index<nums2.length){
                if(nums1[n1index]<=nums2[n2index]){
                    prevprevnum= prevnum;
                    prevnum = nums1[n1index];
                    n1index++;
                } else {
                    prevprevnum= prevnum;
                    prevnum = nums2[n2index];
                    n2index++;
                }
            } else if(n1index<nums1.length){
                prevprevnum= prevnum;
                prevnum = nums1[n1index];
                n1index++;
            } else {
                prevprevnum= prevnum;
                prevnum = nums2[n2index];
                n2index++;
            }
            mindex--;
        }
        
        if(!isEven){
            return (double)prevnum;
        }

        System.out.println(prevprevnum+" "+prevnum);

        return (double)(prevprevnum+prevnum)/2;
    }
}
