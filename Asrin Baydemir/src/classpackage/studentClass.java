package classpackage;

import java.io.*;
import java.util.*;
import javax.swing.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import apppackage.filenameClass;

public class studentClass
{
	public String studentCode;
	public String studentName;
	public String studentSurname;
	public String studentSection;
	public String studentPeriod;
	public String studentCourse;
	
	private static boolean studentExist(JSONArray studentArray, String studentCode, String courseCode)
	{
		for (Object studentObject : studentArray)
		{
	        if (studentObject instanceof JSONObject)
	        {
	            JSONObject jsonObject = (JSONObject) studentObject;
	            
	            String existingstudentCode = (String) jsonObject.get("studentCode");
	            String existingcourseCode = (String) jsonObject.get("studentCourse");
	            
	            if ((existingstudentCode != null && existingstudentCode.equals(studentCode)) && (existingcourseCode != null && existingcourseCode.equals(courseCode)))
	            {
	                return true;
	            }
	        }
		}
	    
	    return false;
	}
	
	private static String addStudent(studentClass obj)
	{
        try
        {
        	JSONArray studentArray;
        	
            if (jsonClass.fileExists(filenameClass.fileNameStudents))
            {
            	studentArray = jsonClass.readFile(filenameClass.fileNameStudents);
                
                if (studentExist(studentArray, obj.studentCode, obj.studentCourse))
                {
                    return "This student code and course code already exists!";
                }
            }
            
            else
            {
            	studentArray = new JSONArray();
            }
            
            HashMap<String, String> studentObject = new HashMap<>();
            
            studentObject.put("studentCode", obj.studentCode);
            studentObject.put("studentName", obj.studentName);
            studentObject.put("studentSurname", obj.studentSurname);
            studentObject.put("studentSection", obj.studentSection);
            studentObject.put("studentPeriod", obj.studentPeriod);
            studentObject.put("studentCourse", obj.studentCourse);
            
            studentArray.add(studentObject);
            
            jsonClass.writeFile(filenameClass.fileNameStudents, studentArray);
            
        	return "This student and course saved!";
        }
        catch (IOException | ParseException e)
        {
        	e.printStackTrace();
        	
            return "An error occurred!";
        }
    }
	
	public static String control(studentClass obj)
	{
		if(obj.studentCode.isEmpty())
		{
			return "Do not leave the 'Student Code' field blank!";
		}
		
		else if (obj.studentName.isEmpty())
		{
			return "Do not leave the 'Student Name' field blank!";
		}
		
		else if (obj.studentSurname.isEmpty())
		{
			return "Do not leave the 'Student Surname' field blank!";
		}
		
		else if (obj.studentSection.isEmpty())
		{
			return "Do not leave the 'Student Section' field blank!";
		}
		
		else if (Integer.parseInt(obj.studentPeriod) == 0)
		{
			return "Do not leave the 'Student Period' field blank!";
		}
		
		else if (obj.studentCourse.isEmpty())
		{
			return "Do not leave the 'Student Course' field blank!";
		}
		
		else
		{
			return addStudent(obj);
		}
	}
	
	public static String fillComboBox(JComboBox<String> obj)
	{
		try
		{
			JSONArray courses = jsonClass.readFile(filenameClass.fileNameCourses);
			
			for (Object courseObject : courses)
			{
				if (courseObject instanceof JSONObject)
		        {
					JSONObject item = (JSONObject) courseObject;
			        String courseName = (String) item.get("courseName");
			        obj.addItem(courseName);
		        }
		    }
		}
		catch(Exception e)
		{
			return e.toString();
		}
		
		return "Successful";
	}
}
