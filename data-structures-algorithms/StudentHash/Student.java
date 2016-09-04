public class Student
{
	private long id;
	private String name;

	public Student(long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public boolean equals(Object other)
	{
		if(other == null)
		{
			return false;
		}

		if(this.getClass() != other.getClass())
		{
			return false;
		}
		
		if(this.id != ((Student)other).id)
		{
			return false;
		}

		if(this.name.equals(((Student)other).name))
		{
			return false;
		}
		return true;
	}
	
	public String toString()
	{
		return "{ id: " + id + ", name: " + name + " }";
	}

	public int hashCode()
	{
		return Long.valueOf(id).hashCode();
	}
}
