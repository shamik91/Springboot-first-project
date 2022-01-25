package com.springboot.first;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	//Rest API
	//Spring MVC take care of converting Java object to Json object and vice versa with the help of MappingJackson2HttpMessageConvertor library
	
	@GetMapping("/student")
	//By default Spring provide json response if you want to change it from Json to XML you can write it as below
	//@GetMapping(value="/student",produces = MediaType.APPLICATION_XML_VALUE)
	public Student getStudent() {
		return new Student("Shamik","Burade");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Shamik","Burade"));
		students.add(new Student("Amit","Nagpure"));
		students.add(new Student("Abhilash","Nimbalkar"));
		students.add(new Student("Sagar","Chate"));
		students.add(new Student("Pankaj","Hindariya"));

		return students;
	}
		
	//with the @PathVariable we bind the request Url template path variable to method variable
	//http://localhost:8080/student/Shamik/Burade	
	@GetMapping("/student/{firstname}/{lastname}")
	public Student studentPathVariable( @PathVariable("firstname") String firstname1,
			@PathVariable("lastname") String lastname1) {
		return new Student(firstname1,lastname1);
		
	}
	
	
	//build RestAPI to handle query parameters with  @RequestParam 
	//http://localhost:8080/student/query?firstname=Shamik&lastname=Burade	
	@GetMapping("/student/query")
	public Student studentRequestParam( @RequestParam(name="firstname") String firstname1,
				@RequestParam(name="lastname") String lastname1) {
			return new Student(firstname1,lastname1);
			
	}
	
		
	
}
