package daos;

import java.sql.*;
import core.BDSQLServer;
import core.MeuResultSet;
import dbos.Student;

/**
 * The Students class consists in a class that is the "bridge" between the Data Base and the project.
 * Its by using the class that the program uses the data from the DB in the project.
 * @author Enzo Furegatti Spinella (19168) and Nícolas Maisonnette Duarte (19192).
 * @since 2020.
 */
public class Students 
{
	/**
	 * The Method exists searches if the ra (which is the primary key of the table Students) is registered in the Data Base.
	 * It uses the sql "SELECT" command to search, and then, by using the resultado.first(), it knows if there is a result of the "SELECT". (If there is a student with
	 * that RA registered.
	 * @param ra Is the param used to the sql search, represents the primary key.
	 * @return retorno, that is true when there is a student registered with the param RA value, and that is false when there isn't.
	 * @throws Exception When the RA is invalid and when something wrong happens in the DB search.
	 */
	public static boolean exists (int ra) throws Exception
    {
		if (ra < 0)
			throw new Exception("Invalid RA!");
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Student " +
                  "WHERE ra = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, ra);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); 

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Student search error");
        }

        return retorno;
    }
	
	/**
	 * The method insert inserts in the DB the student given in the param, by using the "INSERT" command in SQL.
	 * @param student It's the student that will be added into the DB.
	 * @throws Exception When the Student is null or when something wrong happens in the DB insertion. 
	 */
	public static void insert (Student student) throws Exception
	{
		if(student==null)
			throw new Exception("Invalid Student!");
		
		try
		{
			String sql = "insert into Student values (?,?,?,?,?,?)";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, student.getRa());
			BDSQLServer.COMANDO.setString(2, student.getName());
			BDSQLServer.COMANDO.setInt(3, student.getCourseNumber());
			BDSQLServer.COMANDO.setString(4, student.getZipCode());
			BDSQLServer.COMANDO.setString(5, student.getComplement());
			BDSQLServer.COMANDO.setInt(6, student.getNumber());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Student Insertion Error");
		}
	}
	/**
	 * The method update is used to update some data in the DB, it do this by using the "UPDATE" command from sql.
	 * @param student Is the param that contains the student and it's alterations.
	 * @throws Exception When the student given is null, when the student given don't exists in the DB and when something goes wrong in the DB update.
	 */
	public static void update (Student student) throws Exception
	{
		if(student==null)
			throw new Exception("Invalid Student!");
		
		if(!Students.exists(student.getRa()))
			throw new Exception("Student not found!");
		
		try
		{
			String sql = "update Student set sname = ? , course = ? , zip = ? , complement = ? , number = ? where ra = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setString(1, student.getName());
			BDSQLServer.COMANDO.setInt(2, student.getCourseNumber());
			BDSQLServer.COMANDO.setString(3, student.getZipCode());
			BDSQLServer.COMANDO.setString(4, student.getComplement());
			BDSQLServer.COMANDO.setInt(5, student.getNumber());
			BDSQLServer.COMANDO.setInt(6, student.getRa());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Student Update Error");
		}
	}
	/**
	 * The method delete is used to delete some student in the DB, it do this by using the "DELETE" command from sql.
	 * @param ra Is the param that contains the ra from the student that will be deleted.
	 * @throws Exception When the RA is invalid, when the student isn't registered to be deleted and when something wrong happens in the DB deletion.
	 */
	public static void delete (int ra) throws Exception
	{
		if(ra < 0)
			throw new Exception ("Invalid RA!");
		if(!Students.exists(ra))
			throw new Exception("Student not found!");
		
		try
		{
			String sql = "delete from Student where ra = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, ra);
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Student Deletion Error");
		}
	}
	/**
	 * The method getStudent is used to search in sql, in special, to get a unique student from the ra given in the param.
	 * @param ra Is the RA from the student that is being searched.
	 * @return student, Its the student with all its attributes, if it exists.
	 * @throws Exception When the RA given is invalid, when the RA doesn't match with any of the registered students.
	 */
	public static Student getStudent(int ra) throws Exception 
	{
		if(ra < 0)
			throw new Exception ("Invalid RA!");
		Student student = null;
		
		try
		{
			String sql = "select * from Student where ra = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, ra);
			
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			
			if(!resultado.first())
				throw new Exception("RA Not Registered");
			
			student = new Student(ra, resultado.getString("sname"), resultado.getInt("course"), resultado.getString("zip"), resultado.getString("complement"), resultado.getInt("number"));
		}
		catch(SQLException ex)
		{
			throw new Exception("ERROR! Couldn't get the student");
		}
		
		return student;
	}
	/**
	 * The method getStudents is used to search in sql, in special, to get all the Students that are registered in the DB table.
	 * @return resultado, which contains all the registers from the table Students.
	 * @throws Exception When Something wrong happens in the DB search.
	 */
	public static MeuResultSet getStudents() throws Exception
	{
		MeuResultSet resultado = null;
		
		try
		{
			String sql = "select * from Student";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Error when accessing Students");
		}
		
		return resultado;
	}
}
