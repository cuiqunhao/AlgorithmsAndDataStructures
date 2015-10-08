package Linear;




/**
 * 合适于元素个数稳定，主要业务为数据存、取操作，不经常进行插入和删除操作
 * 
 * @author ArrayList in Java by Lyf
 * 
 * @since 2015-08-26
 * */
public class ArrayList implements List{
	private Object[] data = null;
	private int current;
	private int capacity;

	/**
	 * 构造函数，初始化线性表大小
	 * 
	 * @param initSize
	 *            线性表大小
	 * */
	public ArrayList(int initSize) {
		if (initSize < 0) {
			throw new RuntimeException("数组大小异常" + initSize);
		} else {
			this.data = new Object[initSize];
			this.current = 0;
			this.capacity = initSize;
		}
	}

	/**
	 * 默认构造函数，未指定线性表大小时，默认为10
	 * */
	public ArrayList() {
		this(10);
	}

	/**
	 * 确认线性表是否已经满了，如果满了自增10容量
	 * 
	 * @param current
	 *            当前位置
	 * */
	public void ensureCapacity(int current) {
		if (this.capacity == current) {// 已经满了
			this.capacity = this.capacity + 10;// 容量增加10
			Object[] newdata = new Object[capacity];
			for (int i = 0; i < current; i++) {
				newdata[i] = this.data[i];
			}
			this.data = newdata;
		}
	}

	/**
	 * 添加元素
	 * 
	 * @param element
	 *            添加元素值
	 * @return true
	 * */
	public boolean add(Object element) {
		boolean flag = false;
		this.ensureCapacity(this.current);
		this.data[current] = element;
		current++;
		flag = true;

		return flag;
	}

	/**
	 * 获取指定位置的元素值
	 * 
	 * @param i
	 *            指定获取位置
	 * @return 返回指定位置处的值
	 * */
	public Object get(int i) {
		if (i >= capacity) {
			throw new RuntimeException("数组越界");
		}
		if (i < 0) {
			throw new RuntimeException("非法取值");
		}
		return this.data[i];
	}

	/**
	 * 返回当前线性表大小
	 * 
	 * @return 线性表大小
	 * */
	public int getLength() {
		return this.current;
	}

	/**
	 * 验证线性表下标是否合法
	 * 
	 * @param index
	 *            指定线性表下标
	 * */
	private void isValidIndx(int index) {
		if (index < 0 || index > current) {
			throw new RuntimeException("数组下标异常");
		}
	}

	/**
	 * 设置指定下标对应元素
	 * 
	 * @param index
	 *            指定更改位置
	 * @param e
	 *            用来修改的值
	 * @return 如果指定位置合法则返回true，否则返回false
	 * */
	public boolean set(int index, Object e) {
		boolean flag = false;
		isValidIndx(index);
		this.data[index] = e;
		flag = true;
		return flag;
	}

	/**
	 * 删除指定位置的元素
	 * 
	 * @param index
	 *            下标位置
	 * */
	/*
	 * public boolean remove(int index) { boolean flag = false;
	 * isValidIndx(index); Object[] newdata = new Object[current - 1];
	 * 
	 * for (int i = 0, j = 0; i < current; i++) { if (index == i) { } else {
	 * newdata[j] = this.data[i]; j++; } } current--; this.data = newdata; flag
	 * = true; return flag; }
	 */

	/**
	 * 向前移动一位来填补删除的元素
	 * 
	 * @param index
	 *            被删除元素下标
	 * @return true 成功删除
	 * */
	public boolean remove(int index) {
		isValidIndx(index);
		boolean flag = false;
		current--;
		for (int i = 0; i < current; i++) {
			if (index <= i) {
				this.data[i] = this.data[i + 1];
			}
		}

		flag = true;
		return flag;
	}

	
	/**
	 * 插入一个元素，向后移动一位来让位
	 * 
	 * @param index 待插入元素的下标
	 * @param object 待插入元素值
	 * @return true 插入成功
	 * 
	 * */
	public boolean insert(int index, Object object) {
		boolean flag = false;
		isValidIndx(index);
		ensureCapacity(current);
		current++;
		for (int i = current-1; i >=0; i--) {
			if (index <= i) {
				this.data[i] = this.data[i - 1];
				if (index == i) {
					this.data[i]=object;
					break;
				}
			}
		}
		flag = true;
		return flag;

	}

	/**
	 * 判断线性表是否为空
	 * 
	 * @return true 线性表为空;false 线性表为非空
	 * */
	public boolean isEmpty() {
		boolean flag = false;

		if (current == 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 * 清空线性表
	 * 
	 * @return true 成功清空
	 * */
	public boolean clear(){
		boolean flag=false;
		current=0;
		flag=true;
		return flag;
	}
	/**
	 * 循环历遍线性表
	 * */
	public void Traversal() {
		for (int i = 0; i < current; i++) {
			System.out.println(this.data[i]);
		}
	}
	

}
