class Solution {
    public int calculate(String s) {
        Deque<String> q = new ArrayDeque<>();
        int l =0;
        int r =0;
        boolean isLastMD = false;
        while(r<s.length()){
            
            while(r<s.length() && (s.charAt(r)!='/' && s.charAt(r)!='*' &&  s.charAt(r)!='+' && s.charAt(r)!='-')){
                r++;
            }

            if(r==s.length()){
                break;
            }
            
            char c = s.charAt(r);
            //System.out.println("Call"+ c);
            // found operand
            String cur = s.substring(l,r).trim();
            int val = Integer.parseInt(cur);
            //System.out.println("val"+ val);
            if(isLastMD){
                String opration = q.removeLast();
                int left = Integer.parseInt(q.removeLast());
                if(opration.equals("*")){
                    val = left*val;
                } else {
                    val = left/val;
                }
                isLastMD = false;
            } 

            //System.out.println("call else");
            q.addLast(val+"");
            q.addLast(c+"");
            //System.out.println("size"+q.size());
            if(c=='*' || c=='/'){
                isLastMD = true;
            }
            r = r+1;
            l =r;
        }
        int lastVal = Integer.parseInt(s.substring(l,r).trim());
        if(isLastMD){
            String opration = q.removeLast();
            int left = Integer.parseInt(q.removeLast());
            if(opration.equals("*")){
                lastVal = left*lastVal;
            } else {
                lastVal = left/lastVal;
            }
            isLastMD = false;
        } 

        q.addLast(lastVal+"");
        //System.out.println(q);
        while(q.size()!=1){
            int left = Integer.parseInt(q.removeFirst());
            String op = q.removeFirst();
            int right = Integer.parseInt(q.removeFirst());
            if(op.equals("+")){
                left = left+right;
            } else {
                left = left-right;
            }
            q.addFirst(left+"");
        }
        //System.out.println(q);
        return Integer.parseInt(q.peekFirst());
        
    }
}