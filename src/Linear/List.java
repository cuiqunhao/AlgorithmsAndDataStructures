package Linear;

public interface List {//Ĭ��abstract��public

	/**
	 * ˳�����
	 * @param object
	 * @return
	 */
	boolean add(Object object);
	
	/**
	 * �������
	 * @param index
	 * @return
	 */
	Object get(int index);
	
	/**
	 * ��ȡ����
	 * @return
	 */
	int getLength();
	
	/**
	 * ��������λ��ֵ
	 * @param index
	 * @param object
	 * @return
	 */
	boolean set(int index, Object object);
	
	/**
	 * ɾ��ָ��Ԫ��
	 * @param index
	 * @return
	 */
	boolean remove(int index);
	
	/**
	 * ָ��λ�ò���Ԫ��
	 * @param index
	 * @param object
	 * @return
	 */
	boolean insert(int index, Object object);
	
	/**
	 * �п�
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * ���
	 * @return
	 */
	boolean clear();
	
	/**
	 * ˳��ѭ������
	 */
	void Traversal();
}
