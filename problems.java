
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

        int[] nums = {7,7};
        int k = 1;
        System.out.println(Arrays.toString(p.topKFrequent(nums, k)));        

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
}
