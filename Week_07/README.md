1、学习字典树的数据结构、核心思想、基本性质

	字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

	核心思想：Trie 树的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

	字典树的基本性质：
	1）结点本身不存完整单词；
	2）从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
	3）每个结点的所有子结点路径代表的字符都不相同。
	
2、学习并查集

	应用场景：组团、配对问题； Group or not ?
	基本操作：
		• makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。
		• unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
		• find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
		
3、学习高级搜索

	初级搜索：
		1. 朴素搜索
		2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）
		3. 搜索方向：
			DFS: depth first search 深度优先搜索
			BFS: breadth first search 广度优先搜索
			
	双向搜索：双向BFS
		
	启发式搜索
		启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。
		
4、高级树、 AVL树和红黑树		

	二叉树 Binary Tree
	
		二叉树遍历：
			前序(Pre-order)：根-左-右
			中序(In-order)：左-根-右
			后序(Post-order)：左-右-根
			
	二叉搜索树 Binary Search Tree	
	
		二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：
			左子树上所有结点的值均小于它的根结点的值；
			右子树上所有结点的值均大于它的根结点的值；
			以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）
			中序遍历：升序排列
			
	AVL树
	
		发明者 G. M. Adelson-Velsky和 Evgenii Landis
		AVL树是平衡二叉搜索树
		BalanceFactor（平衡因子）：是它的左子树的高度减去它的右子树的高度（有时相反）。balance factor = {-1, 0, 1}
		通过旋转操作来进行平衡（四种）：左旋、右旋、左右旋、右左旋
		
	Red-black Tree
	
		红黑树是一种近似平衡的二叉搜索树（BinarySearch Tree）， 它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：
			• 每个结点要么是红色，要么是黑色
			• 根结点是黑色
			• 每个叶结点（NIL结点，空结点）是黑色的。
			• 不能有相邻接的两个红色结点
		关键性质：从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。
		对比：
			• AVL trees providefaster lookupsthan Red Black Trees because they aremore strictlybalanced.
			• Red Black Trees providefaster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
			• AVL trees store balancefactors or heights with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
			• Red Black Trees are used in most of thelanguage libraries likemap, multimap, multisetin C++whereas AVL trees are used in databases where faster retrievals are required.



代码模板

//Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
	        Trie node = searchPrefix(prefix);
	        return node != null;
	}
	private Trie searchPrefix(String word) {
	        Trie node = this;
	        char[] words = word.toCharArray();
	        for (int i = 0;i < words.length;i++) {
	            node = node.next[words[i] - 'a'];
	            if (node == null) return null;
	        }
	        return node;
	    }
	}
