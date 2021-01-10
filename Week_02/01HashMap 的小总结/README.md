HashMap 的小总结

1、HashMap继承的类（接口）和子类有
    HashMap继承AbstractMap
	HashMap实现子类有LinkedHashMap, PrinterStateReasons
2、HashMap的内部元素的存储和扩容	
	
3、HashMap的构造方法
	HashMap()
	Constructs an empty HashMap with the default initial capacity (16) and the default load factor (0.75).
	HashMap(int initialCapacity)
	Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75).
	HashMap(int initialCapacity, float loadFactor)
	Constructs an empty HashMap with the specified initial capacity and load factor.
	HashMap(Map<? extends K,? extends V> m)
	Constructs a new HashMap with the same mappings as the specified Map.
3、HashMap的方法
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

4、HashMap的最佳遍历方式

5、HashMap的扩容

1.1入队操作
add(E e);
offer(E e);

用途：用于添加元素，只能查询定义队列时定义的元素类型和其子类否则会抛出ClassCastException；不允许插入null，否二会抛出NullPointerException、IllegalArgumentException。
区别：当超出容量限制时，add接口抛出IllegalStateException，offer则返回false。

1.2出队操作
E remove();
E poll();

用途：并从删除队列头中的元素，并返回该元素
区别： 队列为空时，remove抛出NoSuchElementException，poll则返回null。

1.2查询队头元素
E element();
E peek();

用途：返回队列头部元素，但不删除该元素
区别：如果队列为空，element抛出NoSuchElementException，peek则返回null。



2.PriorityQueue源代码分析
PriorityQueue为优先队列，入队时，根据入队元素的优先级，判断元素入队的位置，从而实现根据优先级进行出队操作。
优先级判断时是调用入队元素的compareTo方法，所以入队元素必须实现Comparable接口