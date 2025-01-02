
import java.util.Arrays;

class problems{
    public static void main(String[] args) {
        problems p = new problems();
        int[] nums = { 1, 2, 3, 4};
        //System.out.println(p.hasDuplicate(nums));

        String s = "jar", t = "jam";
        System.out.println(p.isAnagram(s,t));
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
}
