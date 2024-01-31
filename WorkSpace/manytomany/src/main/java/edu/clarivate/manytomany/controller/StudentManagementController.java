package edu.clarivate.manytomany.controller;

import java.util.Arrays;
import java.util.List;

import edu.clarivate.manytomany.dao.StudentDao;
import edu.clarivate.manytomany.dao.SubjectDao;
import edu.clarivate.manytomany.entity.Student;
import edu.clarivate.manytomany.entity.Subject;

public class StudentManagementController {
	public static void main(String[] args) {
		List<Subject> subjects = readSubjectInfo();
		List<Student> students = readStudentInfo(subjects);

		// Save Subject
		SubjectDao subjectDao = new SubjectDao();
		for (Subject subject : subjects) {
			subjectDao.saveSubject(subject);
		}

		// Save Student Info

		StudentDao studentDao = new StudentDao();
		for (Student student : students) {
			studentDao.saveStudent(student);
		}

	}

	public static List<Subject> readSubjectInfo() {
		// Subject 1
		Subject subject1 = new Subject();
		subject1.setId(101);
		subject1.setName("English");
		subject1.setNumberOfClass(200);
		// Subject 2
		Subject subject2 = new Subject();
		subject2.setId(102);
		subject2.setName("Math");
		subject2.setNumberOfClass(300);
		// Subject 3
		Subject subject3 = new Subject();
		subject3.setId(103);
		subject3.setName("Science");
		subject3.setNumberOfClass(300);

		// Subject 4
		Subject subject4 = new Subject();
		subject4.setId(104);
		subject4.setName("Social");
		subject4.setNumberOfClass(300);

		return Arrays.asList(subject1, subject2, subject3, subject4);
	}

	public static List<Student> readStudentInfo(List<Subject> subjects) {
		// Student 1
		Student student1 = new Student();
		student1.setId(10001);
		student1.setName("Ravi");
		student1.setEmail("ravi@abc.in");
		student1.setAge(16);
		student1.setMarks(45);
		student1.setSubjects(subjects);

		// Student 2

		Student student2 = new Student();
		student2.setId(10002);
		student2.setName("Prithi");
		student2.setEmail("prithi@abc.in");
		student2.setAge(16);
		student2.setMarks(92);
		student2.setSubjects(subjects);

		return Arrays.asList(student1, student2);
	}
}
