package Queue;

public class ArrayQueue implements queue {

	private Object[] datas;
	private int current;
	private int capacity;

	public ArrayQueue() {
		capacity = 10;
		current = -1;
		datas = new Object[capacity];
	}

	public void enSureCapacity() {
		if (current == capacity - 1) {
			capacity = capacity + 10;
			Object[] newdatas = new Object[capacity];
			for (int i = 0; i <= current; i++) {
				newdatas[i] = datas[i];
			}
		}
	}

	@Override
	public void add(Object data) {
		enSureCapacity();
		datas[++current] = data;

	}

	@Override
	public Object poll() {
		if (current == -1) {
			return null;
		}
		Object returnObject = datas[0];
		for (int i = 1; i <= current; i++) {
			datas[i - 1] = datas[i];
		}
		current--;
		return returnObject;
	}

	@Override
	public Object peek() {
		if (current == -1)
			return null;
		else
			return this.datas[0];
	}

	@Override
	public boolean isEmpty() {
		boolean flag=false;
		if(current==-1)
			flag=true;
		return flag;
	}

	@Override
	public void clear() {
		current=-1;
	}
	

	@Override
	public void Travels() {
		for (int i = 0; i <= current; i++) {
			System.out.println(datas[i]);
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String args[]) {
		queue testQueue = new ArrayQueue();
		testQueue.add(1);
		testQueue.add(2);
		testQueue.add(3);

		testQueue.Travels();

		System.out.println("------");
		System.out.println(testQueue.poll());
		System.out.println(testQueue.poll());
		System.out.println(testQueue.poll());
		System.out.println(testQueue.poll());
		System.out.println(testQueue.poll());
		System.out.println("------");
		testQueue.Travels();
	}

}
