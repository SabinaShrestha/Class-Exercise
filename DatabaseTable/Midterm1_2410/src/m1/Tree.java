package m1;

/** 
 * Tree that is defined by the name of its species, the 
 * corresponding identification code, and its age.
 * 
 * = = =   D O   N O T   C H A N G E   T H I S   C L A S S   = = = 
 *
 */
public class Tree {
	private String name;
	private String code; // 2-character identification code
	private int age;

	/**
	 * Initializes the fields name, code, and age based on
	 * the values provided as arguments.
	 * 
	 * @param name
	 * @param code
	 */
	public Tree(String name, String code, int age) {
		this.name = name;
		this.code = code;
		this.age = age;
	}
	
	/**
	 * Exposes the name of the tree.
	 * @return value of the field name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Exposes the identification code of the tree.
	 * @return value of the field code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Exposes the age of the tree.
	 * @return value of the field age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Returns a string that include the identification code followed by the 
	 * name and the age in parenthesis.
	 */
	@Override
	public String toString() {
		return code + " " + name + " (" + age + ")";
	}
}
