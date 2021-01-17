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
