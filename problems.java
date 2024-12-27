class problems{
    public static void main(String[] args) {
        problems p = new problems();
        int[] nums = { 1, 2, 3, 4};
        System.out.println(p.hasDuplicate(nums));
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
}
