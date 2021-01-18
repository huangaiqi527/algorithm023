class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getCombine(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    
    public void getCombine(int n, int k, int start, List<Integer> list, List<List<Integer>> result) {
        if(k == 0) {//尚需要添加的元素个数为0，则说明该组合以满足要求
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n - k + 1;i++) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(i);
            getCombine(n, k - 1, i+1, newList, result);
        }
    }

}