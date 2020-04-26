package com.weizz5.code.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 1：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author weizz5
 * @date 2020/04/08
 */
public class MovingCount {


    private static List<String> mov1List = new ArrayList<>();

    private static List<String> mov2List = new ArrayList<>();
    public static void main(String[] args) {

        MovingCount movingCount = new MovingCount();

//        System.out.println(movingCount.movingCount(2,3,1));
//        System.out.println(movingCount.movingCount(3,1,0));
        System.out.println(movingCount.movingCount(38,15,9));
//        System.out.println(JSON.toJSONString(new boolean[2][3]));

        System.out.println(movingCount.movingCount1(38,15,9));

        mov1List.removeAll(mov2List);
        System.out.println(JSON.toJSONString(mov1List));
    }

    public int movingCount(int m, int n, int k) {
        return movingCountMySelf(m,n,k);
//        return movingCount1(m,n,k);
    }


    int m, n, k;
    boolean[][] visited;
    public int movingCount1(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
//        mov1List.add(i+"_"+j);
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public int dfs1(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k > si + sj || visited[i][j]) {
            return 0;
        } else {
            visited[i][j] = true;
            return 1 + dfs1(i + 1, j, (i + 1) % 10 > 0 ? si + 1 : si - 8, sj) + dfs1(i, j + 1, si, (j + 1) % 10 > 0 ? sj + 1 : sj - 8);

        }
    }


    public int movingCountMySelf(int m, int n, int k) {

        if(0 == k || (0==m && 0==n)){
            return 1;
        }

        int sum1 = 0,sum2;

        int count = 0;

        Set<String> indexSet = new HashSet<>();

        for(int i=0;(sum1 = getCountSum(i)) <= k && i<m; i++){
//            sum1 = getCountSum(i);

            sum2 = 0;
            for(int j=0; j<n && (sum2 =sum1+ getCountSum(j) ) <=k && !indexSet.contains(i+"_"+j); j++){
                System.out.println("i:"+i+",j:"+j+",k:"+k+",sum:"+sum2);
                indexSet.add(i+"_"+j);
                count++;
//                sum2 =sum1+ getCountSum(j);
//                String indexStr = i+"_"+j;
//                if(sum2 <=k && !indexSet.contains(indexStr)){
//                    System.out.println("i:"+i+",j:"+j+",k:"+k+",sum:"+sum2);
//                    indexSet.add(indexStr);
//                    count++;
//                }else{
//                    break;
//                }

            }
        }
        sum1 = 0;
        for(int i=0; (sum1 = getCountSum(i)) <= k && i<n; i++){

            sum2 = 0;
            for(int j=0; j<m && (sum2 =sum1+ getCountSum(j) ) <=k && !indexSet.contains(i+"_"+j); j++){

//                String indexStr = ;
                System.out.println("index2 i:"+i+",j:"+j+",k:"+k+",sum:"+sum2);
                indexSet.add(i+"_"+j);
                count++;

            }
        }

        mov2List.addAll(indexSet);
        return count;
    }

    public int getCountSum(int value){
        if(0== value){
            return 0;
        }

        int sum = value%10;

        while (value / 10 >0){
            value = value/10;
            sum += value%10;
        }
        return sum;

    }
}
