
import java.util.*;

class problems{
    public static void main(String[] args) {
        problems p = new problems();
        //int[] nums = { 1, 2, 3, 4};
        //System.out.println(p.hasDuplicate(nums));

        //String s = "jar", t = "jam";
        //System.out.println(p.isAnagram(s,t));

        //int[] nums = {5,5};
        //int target = 10;
        //System.out.println(Arrays.toString(p.twoSum(nums, target)));

        //String[] strs = {"act","pots","tops","cat","stop","hat"};
        //System.out.println(p.groupAnagrams(strs));

        //int[] nums = {7,7};
        //int k = 1;
        //System.out.println(Arrays.toString(p.topKFrequent(nums, k)));

        //List<String> strs = Arrays.asList("neet", "code", "love", "you");        
        //String ans = p.encode(strs);
        //System.out.println(ans);
        //System.out.println(p.decode(ans));

        //String s = "Was it a car or a cat I saw?";
        //System.out.println(p.isPalindrome(s));

        //int[] numbers = {1,2,3,4};
        //int target = 3;
        //System.out.println(Arrays.toString(p.twoSum2(numbers, target)));

        String s = "([{}])";
        System.out.println(p.isValid(s));


    }

    public boolean hasDuplicate(int[] nums) {
        int temp = 0;
        int curr = nums[temp];
        
        for(int x = 0; x < nums.length; x++){
            
            for(int i = x+1; i < nums.length; i++){
                curr = nums[x];
                if(curr == nums[i]){
                    return true;
                }
                
            }
        }
        return false;    
    }

    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars2);
        if(chars.length != chars2.length){
            return false;
        }
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] != chars2[i]){
                return false;
            }
        }
        return true;

    }

    public int[] twoSum(int[] nums, int target) {
        int[]ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++){
                if(nums[i] + nums[j] == target && i != j){
                    ans[0] = j;
                    ans[1] = i;
                    
                }
            }
        }
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            //System.out.println(sortedS);
            
            if(!strMap.containsKey(sortedS)){
                
                strMap.put(sortedS, new ArrayList<>());
                //System.out.println(strMap);
                //ans.add(strMap.get(sortedS));
            }
            else{
                strMap.get(sortedS).add(str);
                //System.out.println(strMap);
            }
        
        }    
        
        return new ArrayList<>(strMap.values());
        
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> numsMap = new HashMap<>(); //num, freq
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry : numsMap.entrySet()){
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(minHeap.size()> k){
                minHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll()[1];
        }

        return ans;
    }

    public String encode(List<String> strs) {
        String Result = new String();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            int length = strs.get(i).length();
            stringBuilder.append(length);
            stringBuilder.append(":");
            stringBuilder.append(strs.get(i));

        }
        Result = stringBuilder.toString();
        return Result;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i=0;
        while(i < str.length()){
            int index = str.indexOf(':', i);
            int length = Integer.parseInt(str.substring(i, index));
            String temp = str.substring(index + 1, index + 1 + length);
            strs.add(temp);
            i = index + 1 + length;


        }
        
        
        
        return strs;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left<right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
                
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
            }
            left++;
            right--;
            
        }
        return true;
    
        
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left<right){
            int curSum = numbers[left] + numbers[right];
            if(curSum > target){
                right--;
            }
            else if(curSum < target){
                left++;
            }
            else{
                return new int[] {left + 1, right + 1};
            }


        }
        return new int[0];
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] stringArr = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < stringArr.length; i++) {
            if(map.containsKey(stringArr[i])){
                
                if(!stack.isEmpty() && stack.peek() == map.get(stringArr[i])){
                    stack.pop();
                }
                else{
                    return false;

                }
            }
            else{
                stack.push(stringArr[i]);
            }
        }    
        return stack.isEmpty();
    
    }
}
