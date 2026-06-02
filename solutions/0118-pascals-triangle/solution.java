class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int row=0;row<numRows;row++){
            List<Integer> temp=new ArrayList<>();
            long value=1;
            temp.add((int)value);
            for(int col=1;col<=row;col++){
                value=value*(row-col+1)/col;
                temp.add((int) value);
            }
            ans.add(temp);
        }
        return ans;
    }
}
