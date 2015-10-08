package Stack;

/***
 * 顺序栈
 * @author Administrator
 *
 */
public class ArrayStack implements satck {

	private int current;
	private int capacity;
	private Object[] data;

	public ArrayStack() {
		this.current = -1;
		this.capacity = 10;
		data = new Object[this.capacity];

	}

	public ArrayStack(int i) {
		this.current = 0;
		this.capacity = i;
		data = new Object[this.capacity];
	}

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

	@Override
	public void push(Object data) {
		ensureCapacity(current);
		this.data[++current] = data;
	}

	@Override
	public Object pop() {
		Object temp = this.data[this.current--];
		return temp;
	}

	@Override
	public Object peek() {
		return this.data[this.current];
	}

	@Override
	public boolean clear() {
		current = -1;
		return true;
	}

	@Override
	public void Travels() {
		for (int j = current; j >= 0; j--) {
			System.out.println(this.data[j]);
		}
	}

	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if (current == -1)
			flag = true;

		return flag;
	}

	public static void main(String args[]) {
		ArrayStack testStack = new ArrayStack();
		testStack.push(1);
		testStack.push(2);
		System.out.println(testStack.isEmpty());
		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		testStack.push(6);
		testStack.Travels();
		System.out.println(testStack.pop());

		testStack.Travels();

		System.out.println(testStack.peek());

		System.out.println(testStack.clear());
		System.out.println(testStack.isEmpty());
	}

}
