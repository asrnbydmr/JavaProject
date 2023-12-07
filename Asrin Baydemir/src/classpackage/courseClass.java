package classpackage;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import apppackage.filenameClass;

public class courseClass
{
	public String courseCode;
	public String courseName;
	public String coursePeriod;
	public String courseCredit;
	public String courseQuota;
	
	private static boolean courseExist(JSONArray courseArray, String courseCode)
	{
		for (Object courseObject : courseArray)
		{
	        if (courseObject instanceof JSONObject)
	        {
	            JSONObject jsonObject = (JSONObject) courseObject;
	            
	            String existingCode = (String) jsonObject.get("courseCode");
	            
	            if (existingCode != null && existingCode.equals(courseCode))
	            {
	                return true;
	            }
	        }
		}
	    
	    return false;
	}
	
	private static String addCourse(courseClass obj)
	{
        try
        {
        	JSONArray courseArray;
        	
            if (jsonClass.fileExists(filenameClass.fileNameCourses))
            {
                courseArray = jsonClass.readFile(filenameClass.fileNameCourses);
                
                if (courseExist(courseArray, obj.courseCode))
                {
                    return "This course code already exists!";
                }
            }
            
            else
            {
                courseArray = new JSONArray();
            }
            
            HashMap<String, String> courseObject = new HashMap<>();
            
            courseObject.put("courseCode", obj.courseCode);
            courseObject.put("courseName", obj.courseName);
            courseObject.put("coursePeriod", obj.coursePeriod);
            courseObject.put("courseCredit", obj.courseCredit);
            courseObject.put("courseQuota", obj.courseQuota);
            
            courseArray.add(courseObject);
            
            jsonClass.writeFile(filenameClass.fileNameCourses, courseArray);
            
        	return "This course saved!";
        }
        catch (IOException | ParseException e)
        {
        	e.printStackTrace();
        	
            return "An error occurred!";
        }
    }
	
	public static String control(courseClass obj)
	{
		if(obj.courseCode.isEmpty())
		{
			return "Do not leave the 'Course Code' field blank!";
		}
		
		else if (obj.courseName.isEmpty())
		{
			return "Do not leave the 'Course Name' field blank!";
		}
		
		else if (Integer.parseInt(obj.coursePeriod) == 0)
		{
			return "Do not leave the 'Course Period' field blank!";
		}
		
		else if (Integer.parseInt(obj.courseCredit) == 0)
		{
			return "Do not leave the 'Course Credit' field blank!";
		}
		
		else if (Integer.parseInt(obj.courseQuota) == 0)
		{
			return "Do not leave the 'Course Quota' field blank!";
		}
		
		else
		{
			return addCourse(obj);
		}
	}
}
