package formpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import classpackage.courseClass;

public class courseForm
{
	public JFrame courseForm;
	public static boolean courseFormVisible = true;
	private JTextField txtCourseCode;
	private JTextField txtCourseName;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					courseForm window = new courseForm();
					window.courseForm.setVisible(true);
					courseFormVisible = false;
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public courseForm()
	{
		initialize();
	}
	
	private void initialize()
	{
		courseForm = new JFrame();
		courseForm.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent e)
			{
				courseFormVisible = true;
			}
		});
		courseForm.setTitle("Course Form");
		courseForm.setBounds(100, 100, 350, 250);
		courseForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		courseForm.getContentPane().setLayout(null);
		
		JLabel lblCourseCode = new JLabel("Course Code:");
		lblCourseCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseCode.setBounds(10, 11, 100, 20);
		courseForm.getContentPane().add(lblCourseCode);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseName.setBounds(10, 42, 100, 20);
		courseForm.getContentPane().add(lblCourseName);
		
		JLabel lblCoursePeriod = new JLabel("Course Period:");
		lblCoursePeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoursePeriod.setBounds(10, 73, 100, 20);
		courseForm.getContentPane().add(lblCoursePeriod);
		
		JLabel lblCourseCredit = new JLabel("Course Credit:");
		lblCourseCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseCredit.setBounds(10, 104, 100, 20);
		courseForm.getContentPane().add(lblCourseCredit);
		
		JLabel lblCourseQuota = new JLabel("Course Quota:");
		lblCourseQuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseQuota.setBounds(10, 135, 100, 20);
		courseForm.getContentPane().add(lblCourseQuota);
		
		txtCourseCode = new JTextField();
		txtCourseCode.setHorizontalAlignment(SwingConstants.CENTER);
		txtCourseCode.setColumns(10);
		txtCourseCode.setBounds(120, 11, 200, 20);
		courseForm.getContentPane().add(txtCourseCode);
		
		txtCourseName = new JTextField();
		txtCourseName.setHorizontalAlignment(SwingConstants.CENTER);
		txtCourseName.setColumns(10);
		txtCourseName.setBounds(120, 42, 200, 20);
		courseForm.getContentPane().add(txtCourseName);
		
		JSpinner txtCoursePeriod = new JSpinner();
		txtCoursePeriod.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		txtCoursePeriod.setBounds(120, 73, 200, 20);
		courseForm.getContentPane().add(txtCoursePeriod);
		
		JSpinner txtCourseCredit = new JSpinner();
		txtCourseCredit.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		txtCourseCredit.setBounds(120, 104, 200, 20);
		courseForm.getContentPane().add(txtCourseCredit);
		
		JSpinner txtCourseQuota = new JSpinner();
		txtCourseQuota.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		txtCourseQuota.setBounds(120, 135, 200, 20);
		courseForm.getContentPane().add(txtCourseQuota);
		
		JButton btnSave = new JButton("SAVE COURSE");
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				courseClass obj = new courseClass();
				
				obj.courseCode = txtCourseCode.getText().toString();
				obj.courseName = txtCourseName.getText().toString();
				obj.coursePeriod = txtCoursePeriod.getValue().toString();
				obj.courseCredit = txtCourseCredit.getValue().toString();
				obj.courseQuota = txtCourseQuota.getValue().toString();
				
				String result = courseClass.control(obj);
				JOptionPane.showMessageDialog(courseForm, result);
				
				if(result == "This course saved!")
				{
					txtCourseCode.setText(null);
					txtCourseName.setText(null);
					txtCoursePeriod.setValue(0);
					txtCourseCredit.setValue(0);
					txtCourseQuota.setValue(0);
				}
			}
		});
		btnSave.setBounds(120, 166, 200, 34);
		courseForm.getContentPane().add(btnSave);
	}
}
