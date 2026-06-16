class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            
            String binaryStr = Long.toBinaryString(numbers[i]);
            
            int len = binaryStr.length();
            int treelen = 1;
            
            while(treelen < len) {
                treelen = (treelen + 1) * 2 - 1;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < treelen - len; j++) {
                sb.append('0');
            }
            
            sb.append(binaryStr);
            
            String fullStr = sb.toString();
            
            if(isValid(fullStr, false)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    static boolean isValid(String str, boolean parentIsZero) {
        if(str.length() == 0) {
            return true;
        }
        
        int mid = str.length() / 2;
        char cur = str.charAt(mid);
        
        if(parentIsZero && cur == '1') {
            return false;
        }

        boolean next = (cur == '0');
        
        String left = str.substring(0, mid);
        String right = str.substring(mid + 1);
        
        return isValid(left, next) && isValid(right, next);
        
    }
}

// 0101010

// 5 : 101
// 6 : 110
// 9 : 001001
    