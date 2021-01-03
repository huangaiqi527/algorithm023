1.Queue源代码分析
Queue是一种先进先出的线性数据结构，只允许从一端插入元素再另外一端删除元素。
插入的一端为队尾，删除的一端为对头。
Queue是一个接口，定义了6个操作来实现入队、出队、查询队头元素，同时继承了Collection接口。

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