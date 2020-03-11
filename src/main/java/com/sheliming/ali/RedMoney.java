package com.sheliming.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedMoney {
    /**
     *
     * @param money
     * @param count
     * @return
     */
    public List<Integer> getMoney (int money, int count)  {

        if(money<=0||count<=0) {
            throw new RuntimeException("红包金额和人数必须大于0");
        }
        if(money<count) {
            throw new RuntimeException("钱不够分");
        }
        if(money == count) {
            List<Integer> res = new ArrayList<Integer>(count);
            for(int i=0;i<count;i++){
                res.add(1);
            }
            return res;
        }

        List<Integer> res = new ArrayList<Integer>(count);

        //剩余人数
        int lastcount = count;
        Random random =new Random();
        for(int i=0;i<count-1;i++) {
            //取 1  到  当前剩余钱-剩余人数中的随机值
            int m = random.nextInt(money - lastcount) +1;

            res.add(m);
            money-=m;
            lastcount--;
        }

        //最后一个人拿走剩余
        res.add(money);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RedMoney().getMoney(110000,10));
    }
}
