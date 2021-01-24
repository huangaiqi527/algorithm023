class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(null == bills || bills.length == 0){
            return true;
        }
        int five = 0;//当前拥有的五块张数
        int ten = 0;//当前拥有的十块张数
        for(int bill : bills){
            if(bill == 5){//收到五块不用找零
                five++;
            }else if(bill == 10){//收到10块找零5块
                five--;
                ten++;
            }else{//收到20块如果手上有10块的现金则找零十块和五块一张，否则找零三张5块
                if(ten > 0){
                    ten--;
                    five--;
                }else{
                    five -= 3;
                }
            }
            if(five < 0 || ten < 0){//当前拥有的5块或十块是负数则找零失败
                return false;
            }
        }
        return true;
    }
}