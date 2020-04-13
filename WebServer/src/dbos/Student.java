package dbos;

/**
 * The Student Class consists in a class which presents the attributes, getters and setters of an item of a table in SQL server called Students. 
 * It is used for better access between the Data Base we're using and our project.
 * @author Enzo Furegatti Spinella (19168) and N�colas Maisonnette Duarte (19192)
 * @since 2020
 */
public class Student 
{
	/**
	 * The attribute that represents the RA of a Student (It's like a code from UNICAMP)
	 */
	protected int ra;
	/**
	 * The attribute that represents the Name of a Student.
	 */
	protected String name;
	/**
	 * The attribute that represents the Number of the Course in UNICAMP that the Students is currently doing.
	 */
	protected int courseNumber;
	/**
	 * The attribute that represents the Zip Code of the Student (In our application it is very important, because thanks to it, we can use our API which search the address on the Internet)
	 */
	protected String zipCode;
	/**
	 * The attribute that represents the Complement of the Student's address, anything that complements the address, like the Apartment Number of the student.
	 */
	protected String complement;
	/**
	 * The attribute that represents the Number of the Student's home in the street he/she lives.
	 */
	protected int number;
	
	/**
	 * This method is the class constructor, it gives to the attributes a value specified in the params.
	 * @param ra Represents the RA attribute
	 * @param name Represents the name attribute
	 * @param courseN Represents the courseNumber attribute
	 * @param zipCode Represents the zipCode attribute
	 * @param complement Represents the complement attribute
	 * @param number Represents the number attribute
	 * 
	 * @throws Exception When any of the method used founds an error.
	 */
	public Student (int ra, String name, int courseN, String zipCode, String complement, int number) throws Exception
	{
		this.setRa(ra);
		this.setName(name);
		this.setCourseNumber(courseN);
		this.setZipCode(zipCode);
		this.setComplement(complement);
		this.setNumber(number);
	}
	/**
	 * This method verify if the RA is valid and if so, gives the value from the param to the attribute
	 * @param ra Represents the RA attribute
	 * @throws Exception When the RA is invalid.
	 */
	public void setRa(int ra) throws Exception
	{
		if (ra < 0)
			throw new Exception ("Invalid RA!");
		
		this.ra = ra;
	}
	/**
	 * This Method is used when the developer wants to know the RA value, but by this method, it can't be changed.
	 * @return The RA's value, which in the class is Private
	 */
	public int getRa()
	{
		return this.ra;
	}
	/**
	 * This method verify if the Name is valid and if so, gives the valor from the param to the attribute
	 * @param name Represents the name attribute
	 * @throws Exception When the Name is invalid.
	 */
	public void setName(String name) throws Exception
	{
		if (name.equals("") || name==null)
			throw new Exception ("Invalid Name!");
		
		this.name = name;
	}
	/**
	 * This Method is used when the developer wants to know the Name value, but by this method, it can't be changed.
	 * @return The Name's value, which in the class is Private
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * This method verify if the Course Number is valid and if so, gives the valor from the param to the attribute
	 * @param courseNumber Represents the Course Number attribute
	 * @throws Exception When the Course Number is invalid.
	 */
	public void setCourseNumber(int courseNumber) throws Exception
	{
		if (courseNumber < 0)
			throw new Exception ("Invalid Course Number!");
		
		this.courseNumber = courseNumber;
	}
	/**
	 * This Method is used when the developer wants to know the Course Number value, but by this method, it can't be changed.
	 * @return The Course Number's value, which in the class is Private
	 */
	public int getCourseNumber()
	{
		return this.courseNumber;
	}
	
	/**
	 * This method verify if the ZipCode is valid and if so, gives the valor from the param to the attribute
	 * @param zipCode Represents the ZipCode attribute
	 * @throws Exception When the ZipCode is invalid.
	 */
	public void setZipCode(String zipCode) throws Exception
	{
		if (zipCode.equals("") || zipCode==null)
			throw new Exception ("Invalid Zip Code!");
		
		this.zipCode = zipCode;
	}
	/**
	 * This Method is used when the developer wants to know the ZipCode value, but by this method, it can't be changed.
	 * @return The ZipCode's value, which in the class is Private
	 */
	public String getZipCode()
	{
		return this.zipCode;
	}
	
	/**
	 * This method verify if the Complement is valid and if so, gives the valor from the param to the attribute
	 * @param complement Represents the Complement attribute
	 * @throws Exception When the Complement is invalid.
	 */
	public void setComplement(String complement) throws Exception
	{
		if (complement.equals("") || complement==null)
			throw new Exception ("Invalid Complement!");
		
		this.complement = complement;
	}
	/**
	 * This Method is used when the developer wants to know the Complement value, but by this method, it can't be changed.
	 * @return The Complement's value, which in the class is Private
	 */
	public String getComplement()
	{
		return this.complement;
	}
	
	/**
	 * This method verify if the Number is valid and if so, gives the valor from the param to the attribute
	 * @param number Represents the Number attribute
	 * @throws Exception When the Number is invalid.
	 */
	public void setNumber(int number) throws Exception
	{
		if (number < 0)
			throw new Exception ("Invalid Number!");
		
		this.number = number;
	}
	/**
	 * This Method is used when the developer wants to know the Number value, but by this method, it can't be changed.
	 * @return The Number's value, which in the class is Private
	 */
	public int getNumber()
	{
		return this.number;
	}
	
	/**
	 * This method make a printable object containing all the attributes and its values. It is used to print all the informations about this student to search for error mainly.
	 * @return ret, A String made in a formatted way that shows the values of the attributes.
	 */
	public String toString()
	{
		String ret = "";
		
		ret += "Aluno: \n";
		ret += "\tRA: "+this.ra+"\n";
		ret += "\tName: "+this.name+"\n";
		ret += "\tCourse Number: "+this.courseNumber+"\n";
		ret += "\tZip Code: "+this.zipCode+"\n";
		ret += "\tComplement: "+this.complement+"\n";
		ret += "\tNumber: "+this.number+"\n";
		
		return ret;
	}
	/**
	 * This Method is used to Compare two Objects and see if they are equal or not, it represents the Object way of doing "==" in JAVA.
	 * @return true, If they are equal.
	 * @return false, If they are not equal.
	 */
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		if(obj==this)
			return true;
		if(this.getClass()!=obj.getClass())
			return false;
		
		Student aluno = (Student)obj;
		
		if(this.ra != aluno.ra)
			return false;
		return true;
	}
	/**
	 * This method make a code that is unique for each different object existent, its the code that identifies the Object in a hashList.
	 * @return ret, A Integer that contains the hash code of the object.
	 */
	public int hashCode()
	{
		int ret = 9;
		
		ret += ret*13 + new Integer(this.ra).hashCode();
		ret += ret*13 + this.name.hashCode();
		ret += ret*13 + new Integer(this.courseNumber).hashCode();
		ret += ret*13 + this.zipCode.hashCode();
		ret += ret*13 + this.complement.hashCode();
		ret += ret*13 + new Integer(this.number).hashCode();
		
		return ret;
	}
	/**
	 * This method is the Constructor of Copies, It is like the constructor itself, but it's used to create an student with the same values of the one that is in the param.
	 * @param model It's the Student that will have their data copied into the one that called this method.
	 * @throws Exception When the model given is null (wasn't initialized).
	 */
	public Student(Student model) throws Exception
	{
		if(model==null)
			throw new Exception ("Invalid Model!");
		
		this.ra = model.ra;
		this.name = model.name;
		this.courseNumber = model.courseNumber;
		this.zipCode = model.zipCode;
		this.complement = model.complement;
		this.number = model.number;
	}
	/**
	 * This method works together with the Constructor of Copies to make a deep copy of an Student, It's a clone itself.
	 * @return The student cloned as an Object's Instance.
	 */
	public Object clone()
	{
		Student student = null;
		
		try
		{
			student = new Student(this);
		}
		catch(Exception ignored) {}
		
		return student;
	}

}
