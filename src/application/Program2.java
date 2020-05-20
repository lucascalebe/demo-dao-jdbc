package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== test 1: department insert ====");
		Department department = new Department(6, "Test");
		departmentDao.insert(department);
		System.out.println("Inserted! New id: " + department.getId());
		
		System.out.println("==== test 2: department update ====");
		department = departmentDao.findById(6);
		department.setName("Walls");
		departmentDao.update(department);
		System.out.println("UPDATED!");
		
		System.out.println("==== test 3: department deleteById ====");
		System.out.print("Enter the id to be deleted: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("DONE! ID" + id + " was deleted sucsessfully");
		
		System.out.println("==== test 4: department findById ====");
		System.out.println(departmentDao.findById(3));
		
		System.out.println("==== test 5: department findAll ====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		 
		sc.close();
	}

}
