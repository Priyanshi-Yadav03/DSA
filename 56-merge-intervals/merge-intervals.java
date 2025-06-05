class Solution {
    public int[][] merge(int[][] intervals) {
        //step01: Sort The Interval
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//lambda expression
       // step02: store final result
        List<int[]> result= new ArrayList<>();//all slot free
        //traverse the interval one by one
        for(int [] interval: intervals){
            //this interval is not overlapping so just add it
            //result.get(result.size()-1)=>get the last slot 
           // [0] start time                    [1] - end time
           //fill result [[9,11][12,2]]
            if(result.size()==0 || result.get(result.size()-1)[1]<interval[0]){
                result.add(interval);

            }
            else{
                //if overlap so merge it
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],interval[1]);

            }

        }
        return result.toArray(new int[result.size()][]);//convert list into 2D array

        
    }
}