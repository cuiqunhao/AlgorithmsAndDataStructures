package Linear;

public interface List {//默认abstract和public

	/**
	 * 顺序添加
	 * @param object
	 * @return
	 */
	boolean add(Object object);
	
	/**
	 * 随机索引
	 * @param index
	 * @return
	 */
	Object get(int index);
	
	/**
	 * 获取长度
	 * @return
	 */
	int getLength();
	
	/**
	 * 设置索引位的值
	 * @param index
	 * @param object
	 * @return
	 */
	boolean set(int index, Object object);
	
	/**
	 * 删除指定元素
	 * @param index
	 * @return
	 */
	boolean remove(int index);
	
	/**
	 * 指定位置插入元素
	 * @param index
	 * @param object
	 * @return
	 */
	boolean insert(int index, Object object);
	
	/**
	 * 判空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 清空
	 * @return
	 */
	boolean clear();
	
	/**
	 * 顺序循环历遍
	 */
	void Traversal();
}
