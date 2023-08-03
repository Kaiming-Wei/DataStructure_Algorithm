class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] map = { {""},
                            {""},
                            {"a","b","c"},
                            {"d","e","f"},
                            {"g","h","i"},
                            {"j","k","l"},
                            {"m","n","o"},
                            {"p","q","r","s"},
                            {"t","u","v"},
                            {"w","x","y","z"}};
        List<String> list = new ArrayList<String>();
        int[] nums = new int[digits.length()];
        for(int i = 0; i <= nums.length-1; i++){
            nums[i] = (int)digits.charAt(i)-48;
        }
        String str = "";
        process(map, nums, list, 0, str);
        return list;
    }
    public void process(String[][] map, int[] nums, List<String> list, int d, String str){
        if(nums.length == 0){
            return;
        }
        if(str.length() == nums.length){
            list.add(str);
            return;
        }
        for(int i = 0; i < map[nums[d]].length; i++){
            str += map[nums[d]][i];
            process(map,nums,list,d+1,str);
            str = str.substring(0, str.length()-1);
        }
    }
}
