package HashSet;

import java.util.Arrays;

/*
 * My hashset implementation using linear probing
 */
public class MyHashSet<T> {
	int numberOfItems = 0;
	Object[] set = new Object[2]; 
	
	public void add(T item) {
		//enlarge array if loadfactor > 75%
		if (numberOfItems/set.length > 0.75){
			
			//copy array to oldArray
			Object[] oldArray = set;
			
			//create a new larger array
			set = new Object[oldArray.length*2];
			
			for (Object obj: oldArray){
				try{
					T tObj = (T) obj;
					add(tObj);	
				}
				catch (Exception e){
				}	
			}
		}
		
		//add the item
		int position = Math.abs(item.hashCode()% set.length);
		System.out.println("pos:"+position);
		add (item, position);
	}

	private void add(T item, int position) {
		
		
		if (set[position] == null){
			set[position] = item;
			numberOfItems++;
		}
		else add(item, position+1);
		
	}

	public boolean contains(T item){
		int position = Math.abs(item.hashCode()%set.length);
		return contains(item, position);
	}
	
	private boolean contains(T item, int position){	
		if (set[position] == null){
			return false;
		}
		try {
			T castedObject = (T) set[position];
			if (castedObject.equals(item)){
				return true;
			}
		}
		catch (Exception e){	
		}
		System.out.println(position++);
		return contains(item, (position)%set.length);
		
	}
	
	@Override
	public String toString() {
		return Arrays.toString(set);
	}
}
