package Linear;




/**
 * ������Ԫ�ظ����ȶ�����Ҫҵ��Ϊ���ݴ桢ȡ���������������в����ɾ������
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
	 * ���캯������ʼ�����Ա��С
	 * 
	 * @param initSize
	 *            ���Ա��С
	 * */
	public ArrayList(int initSize) {
		if (initSize < 0) {
			throw new RuntimeException("�����С�쳣" + initSize);
		} else {
			this.data = new Object[initSize];
			this.current = 0;
			this.capacity = initSize;
		}
	}

	/**
	 * Ĭ�Ϲ��캯����δָ�����Ա��Сʱ��Ĭ��Ϊ10
	 * */
	public ArrayList() {
		this(10);
	}

	/**
	 * ȷ�����Ա��Ƿ��Ѿ����ˣ������������10����
	 * 
	 * @param current
	 *            ��ǰλ��
	 * */
	public void ensureCapacity(int current) {
		if (this.capacity == current) {// �Ѿ�����
			this.capacity = this.capacity + 10;// ��������10
			Object[] newdata = new Object[capacity];
			for (int i = 0; i < current; i++) {
				newdata[i] = this.data[i];
			}
			this.data = newdata;
		}
	}

	/**
	 * ���Ԫ��
	 * 
	 * @param element
	 *            ���Ԫ��ֵ
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
	 * ��ȡָ��λ�õ�Ԫ��ֵ
	 * 
	 * @param i
	 *            ָ����ȡλ��
	 * @return ����ָ��λ�ô���ֵ
	 * */
	public Object get(int i) {
		if (i >= capacity) {
			throw new RuntimeException("����Խ��");
		}
		if (i < 0) {
			throw new RuntimeException("�Ƿ�ȡֵ");
		}
		return this.data[i];
	}

	/**
	 * ���ص�ǰ���Ա��С
	 * 
	 * @return ���Ա��С
	 * */
	public int getLength() {
		return this.current;
	}

	/**
	 * ��֤���Ա��±��Ƿ�Ϸ�
	 * 
	 * @param index
	 *            ָ�����Ա��±�
	 * */
	private void isValidIndx(int index) {
		if (index < 0 || index > current) {
			throw new RuntimeException("�����±��쳣");
		}
	}

	/**
	 * ����ָ���±��ӦԪ��
	 * 
	 * @param index
	 *            ָ������λ��
	 * @param e
	 *            �����޸ĵ�ֵ
	 * @return ���ָ��λ�úϷ��򷵻�true�����򷵻�false
	 * */
	public boolean set(int index, Object e) {
		boolean flag = false;
		isValidIndx(index);
		this.data[index] = e;
		flag = true;
		return flag;
	}

	/**
	 * ɾ��ָ��λ�õ�Ԫ��
	 * 
	 * @param index
	 *            �±�λ��
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
	 * ��ǰ�ƶ�һλ���ɾ����Ԫ��
	 * 
	 * @param index
	 *            ��ɾ��Ԫ���±�
	 * @return true �ɹ�ɾ��
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
	 * ����һ��Ԫ�أ�����ƶ�һλ����λ
	 * 
	 * @param index ������Ԫ�ص��±�
	 * @param object ������Ԫ��ֵ
	 * @return true ����ɹ�
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
	 * �ж����Ա��Ƿ�Ϊ��
	 * 
	 * @return true ���Ա�Ϊ��;false ���Ա�Ϊ�ǿ�
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
	 * ������Ա�
	 * 
	 * @return true �ɹ����
	 * */
	public boolean clear(){
		boolean flag=false;
		current=0;
		flag=true;
		return flag;
	}
	/**
	 * ѭ���������Ա�
	 * */
	public void Traversal() {
		for (int i = 0; i < current; i++) {
			System.out.println(this.data[i]);
		}
	}
	

}
