import java.util.*;

class Solution {
    
    static int n;
    static int[][] dice;
    static int maxWin = -1;
    static List<Integer> bestComb = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        this.dice = dice;
        
        List<Integer> aComb = new ArrayList<>();
        comb(0, 0, aComb);
        
        int[] answer = new int[n / 2];
        for(int i = 0; i < n / 2; i++) {
            answer[i] = bestComb.get(i) + 1;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void comb(int depth, int cnt, List<Integer> aComb) {
        
        if(cnt == n / 2) {
            boolean[] isSelected = new boolean[n];
            for(int i = 0; i < aComb.size(); i++) {
                isSelected[aComb.get(i)] = true;
            }
            List<Integer> bComb = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(!isSelected[i]) {
                    bComb.add(i);
                }
            }
            // System.out.println("aComb size : " + aComb.size());
            // System.out.println("bComb size : " + bComb.size());
            
//             for(int i : aComb) {
//                 System.out.print(i + " ");
//             }
//             System.out.println();
            
//             for(int i : bComb) {
//                 System.out.print(i + " ");
//             }
//             System.out.println();
            
            
            List<Integer> aSum = new ArrayList<>();
            List<Integer> bSum = new ArrayList<>();
            
            makeSums(aComb, aSum, 0, 0);
            makeSums(bComb, bSum, 0, 0);
            
            Collections.sort(bSum);
            
            int currentWin = 0;
            for(int i : aSum) {
                currentWin += binarySearch(bSum, i);
            }
            if(currentWin > maxWin) {
                maxWin = currentWin;
                bestComb = new ArrayList<>(aComb);
            }
            return;
        }
        
        for(int i = depth; i < n; i++) {
            aComb.add(i);
            comb(i + 1, cnt + 1, aComb);
            aComb.remove(aComb.size() - 1);
        }
        
    }
    
    static void makeSums(List<Integer> comb, List<Integer> sums, int depth, int sum) {
        
        if(depth == n / 2) {
            sums.add(sum);
            return;
        }
        
        int idx = comb.get(depth);
        for(int i = 0; i < 6; i++) {
            makeSums(comb, sums, depth + 1, sum + dice[idx][i]);
        }
    }
    
    static int binarySearch(List<Integer> sum, int target) {
        int left = 0;
        int right = sum.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            if (sum.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
}

