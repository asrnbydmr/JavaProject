package apppackage;

import classpackage.jsonClass;

public class settingsClass
{
	private static boolean studentFormEnabled = false;
	
	public static boolean openStudentForm()
	{
		if (jsonClass.fileExists(apppackage.filenameClass.fileNameCourses))
		{
			studentFormEnabled = true;
		}
		else
		{
			studentFormEnabled = false;
		}
		
		return studentFormEnabled;
	}
}