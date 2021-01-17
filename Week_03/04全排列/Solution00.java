public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(null == nums) {
    		return result;
    	}

    	List<String[]> list = permute(0, nums);
    	for(String[] s : list) {
    		List<Integer> l= new ArrayList<Integer>();
    		for(String val : s) {
    			l.add(Integer.valueOf(val));
    		}
    		result.add(l);
    	}
    	
    	return result;
    }
    
    public List<String[]> permute(int crrentIndex, int[] nums) {
    	List<String[]> result = new ArrayList<String[]>();
    	if(crrentIndex >= nums.length -1) {
    		String[] s ;
    		for(int i = 0; i < nums.length; i++) {
    			s = new String[nums.length];
    			s[i] = String.valueOf(nums[crrentIndex]);
    			result.add(s);
    		}
    		return result;
    	}
    	
    	result = permute(crrentIndex + 1, nums);
    	List<String[]> list = new ArrayList<String[]>();
    	for(String[] s : result){
    		for(int i =0 ; i< s.length; i++) {
    			if(s[i] == null) {
    				String[] ns = Arrays.copyOf(s, s.length);
    				ns[i] = String.valueOf(nums[crrentIndex]);
    				list.add(ns);
    			}
    		}
    	}
    	
    	return list;

    }