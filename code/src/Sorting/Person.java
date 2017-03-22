package Sorting;

public class Person implements IComparable{

	private String name;
	private Integer age;
	@Override
	public boolean compare(IComparable rhs) {
		if(name.length() > ((Person)rhs).name.length())
			return true;
		else
			if(name.length() < ((Person)rhs).name.length())
				return false;
		
		return (age > ((Person)rhs).age) ? true : false;
	}
	
	@Override
	public String toString() {
//		String s = name.length()+" ";
//		return s;
		StringBuilder sb = new StringBuilder();
		sb.append("[" + name);
		sb.append(" "+age+"]");
		return sb.toString();
	
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
