package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IGPEList<E extends Object> implements List<E>{

	public static int DEF_SIZE = 10;
	Object[] array;
	private int size=0;

	IGPEList(){

	}
	IGPEList(final int capacity){
		array = new Object[capacity];
	}
	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {

		return size==0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {

		return 
				Arrays.stream(array)
				.filter(el -> {
					return ((E)o).equals(el);
				})
				.findAny()
				.isPresent();



	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int idx=0;
			Object fst = array[idx];
			@Override
			public boolean hasNext() {
				return idx < size()-1;

			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				fst = array[idx++];
				return (E)fst;

			}
		};

	}

	@Override
	public Object[] toArray() {
		return Arrays.stream(array)
				.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		T[] array2 = (T[])toArray();
		return array2;
	}

	@Override
	public boolean add(E e) {
		if(size > array.length)
			resize(array.length*IGPEList.DEF_MULTIPLIER);
		array[size++] = e;
	}

	@Override
	public boolean remove(Object o) {
		final int idx = indexOf(o); 
		if( idx != -1){
			final int LIMIT = array.length/4;
			if(LIMIT > DEF_SIZE &&  size < LIMIT){
				resize(array.length/2);
			}
			
		}

	}

	private void resize(int i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


}
