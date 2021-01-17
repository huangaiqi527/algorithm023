1、学习和熟悉递归的实现、特性以及思维要点。
Java 代码模板

public void recur(int level, int param) {  

   // terminator   

   if (level > MAX_LEVEL) {

      // process result

      return;

    }
 
 
   // process current logic

    process(level, param);
 
 
    // drill down

    recur( level: level + 1, newParam);
 
    // restore current status
 
   }


2、学习和了解分治、回溯的实现和特性。


private static int divide_conquer(Problem problem, ) {

    if (problem == NULL) {
	
    int res = process_last_result();
	
		return res;
		
	}
	
	subProblems = split_problem(problem)
	
    res0 = divide_conquer(subProblems[0])
	
	res1 = divide_conquer(subProblems[1])
	
    result = process_result(res0, res1);
	
    return result;
	
}
