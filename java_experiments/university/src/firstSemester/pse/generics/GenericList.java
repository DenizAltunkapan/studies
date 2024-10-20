package firstSemester.pse.generics;

import java.util.ArrayList;
import java.util.Arrays;
public class GenericList <T>{
	ArrayList<T> list;
	
	public GenericList(T k,T l) {
		this.list = new ArrayList<>(Arrays.asList(k,l));
	}
	
	public ArrayList<T> getList(){
		return list;
	}
}
