HashMap 的小总结

1、简介

Java为数据结构中的映射定义了一个接口java.util.Map，此接口主要有四个常用的实现类，分别是HashMap、Hashtable、LinkedHashMap和TreeMap，类继承关系如图《Map的类继承关系图.png》。

各个实现类的特点说明：

(1) HashMap：它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。 HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。

(2) Hashtable：Hashtable是遗留类，很多映射的常用功能与HashMap类似，不同的是它承自Dictionary类，并且是线程安全的，但并发性不如ConcurrentHashMap，因为ConcurrentHashMap引入了分段锁，需要线程安全的场合使用ConcurrentHashMap。

(3) LinkedHashMap：LinkedHashMap是HashMap的一个子类，保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的，也可以在构造时带参数，按照访问次序排序。

(4) TreeMap：TreeMap实现SortedMap接口，能够把它保存的记录根据键排序，默认是按键值的升序排序，也可以指定排序的比较器，当用Iterator遍历TreeMap时，得到的记录是排过序的。如果使用排序的映射，建议使用TreeMap。在使用TreeMap时，key必须实现Comparable接口或者在构造TreeMap传入自定义的Comparator，否则会在运行时抛出java.lang.ClassCastException类型的异常。

2. HashMap 内部的一些主要特点：

使用哈希表（散列表）来进行数据存储，并使用链地址法来解决冲突

当链表长度大于等于 8 时，将链表转换为红黑树来存储

每次进行二次幂的扩容，即扩容为原容量的两倍

3.HashMap字段：

Node[] table：存储数据的哈希表；初始长度 length = 16（DEFAULT_INITIAL_CAPACITY），扩容时容量为原先的两倍（n * 2）。

final float loadFactor：负载因子，默认loadFactor = 0.75（DEFAULT_LOAD_FACTO），确定数组长度与当前所能存储的键值对最大值的关系。

int threshold：所能容纳的 key-value 对极限 ；threshold = length * Load factor，当存在的键值对大于该值，则进行扩容。

int modCount：HashMap 结构修改次数，如每次put、remove 时自增 1。

int size：当前 key-value 个数。

4.HashMap方法：	
	
4.1.构造方法

	HashMap() 构造一个空的HashMap，其中 capacity=16， loadFactor=0.75。
	
	HashMap(int initialCapacity)  构造一个初始长度为initialCapacity的空HashMap，loadFactor=0.75。
	
	HashMap(int initialCapacity, float loadFactor) 构造一个初始长度为initialCapacity的空HashMap，并指定loadFactor的值。
	
	HashMap(Map<? extends K,? extends V> m) ，根据传入的Map子类初始构造一个HashMap，loadFactor=0.75。
	
	Constructs a new HashMap with the same mappings as the specified Map.
	
4.2、HashMap的方法清单

void	clear()
Removes all of the mappings from this map.

Object	clone()
Returns a shallow copy of this HashMap instance: the keys and values themselves are not cloned.
	
V	compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).

V	computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.

V	computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.

boolean	containsKey(Object key)
Returns true if this map contains a mapping for the specified key.

boolean	containsValue(Object value)
Returns true if this map maps one or more keys to the specified value.

Set<Map.Entry<K,V>>	entrySet()
Returns a Set view of the mappings contained in this map.

void	forEach(BiConsumer<? super K,? super V> action)
Performs the given action for each entry in this map until all entries have been processed or the action throws an exception.

V	get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

V	getOrDefault(Object key, V defaultValue)
Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

boolean	isEmpty()
Returns true if this map contains no key-value mappings.

Set<K>	keySet()
Returns a Set view of the keys contained in this map.
	
V	merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.

V	put(K key, V value)
Associates the specified value with the specified key in this map.

void	putAll(Map<? extends K,? extends V> m)
Copies all of the mappings from the specified map to this map.

V	putIfAbsent(K key, V value)
If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value.

V	remove(Object key)
Removes the mapping for the specified key from this map if present.

boolean	remove(Object key, Object value)
Removes the entry for the specified key only if it is currently mapped to the specified value.

V	replace(K key, V value)
Replaces the entry for the specified key only if it is currently mapped to some value.

boolean	replace(K key, V oldValue, V newValue)
Replaces the entry for the specified key only if currently mapped to the specified value.

void	replaceAll(BiFunction<? super K,? super V,? extends V> function)
Replaces each entry's value with the result of invoking the given function on that entry until all entries have been processed or the function throws an exception.

int	size()
Returns the number of key-value mappings in this map.

Collection<V>	values()
Returns a Collection view of the values contained in this map.

4.2 hash(Object key)

    取key的哈希值的低16位与高16位异或作为key的最hash值，代码如下：
    
    static final int hash(Object key) {
    
        int h;
	
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	
    }
    
4.3 put(K key, V value)

   put 方法直接调用了 putVal 方法，当链表中元素大于等于 8，这时有可能将链表改造为红黑树的数据结构。
   
   	if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
	
               treeifyBin(tab, hash);
	       
	       
后续再进一步完善
