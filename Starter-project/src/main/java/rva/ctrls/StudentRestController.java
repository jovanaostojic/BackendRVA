package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Departman;
import rva.jpa.Student;
import rva.repository.DepartmanRepository;
import rva.repository.StudentRepository;

@CrossOrigin
@RestController
@Api(tags = {"Student CRUD operacije"})
public class StudentRestController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@GetMapping("student")
	@ApiOperation(value = "Vraca kolekciju svih studenata iz baze podataka")
	public Collection<Student> getStudenti() {
		return studentRepository.findAll();
	}
	
	@GetMapping("student/{id}")
	@ApiOperation(value = "Vraca studenta iz baze podataka cija je ID vrednost prosledjena kao PATH varijabla")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@GetMapping("studentDepartman/{id}")
	@ApiOperation(value = "Vraca studenta iz baze podataka cija je ID vrednost departmana prosledjena kao PATH varijabla")
	public Collection<Student> getStudentByDepartman(@PathVariable("id") Integer id){
		Departman d= departmanRepository.getOne(id);
		return studentRepository.findByDepartman(d);
	}
	
	@GetMapping("studentBrojIndeksa/{brojIndeksa}")
	@ApiOperation(value = "Vraca kolekciju svih studenata iz baze podataka koji u nazivu sadrze string proslednjen kao PATH varijabla")
	public Collection<Student> getStudentByBrojIndeksa(@PathVariable("brojIndeksa") String brojIndeksa){
		return studentRepository.findByBrojIndeksaContainingIgnoreCase(brojIndeksa);
	}
	
	@PostMapping("student")
	@ApiOperation(value = "Upisuje studenta u bazu podataka")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
		if (!studentRepository.existsById(student.getId())) {
			studentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("student")
	@ApiOperation(value = "Modifikuje postojeceg studenta u bazi podataka")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		if(!studentRepository.existsById(student.getId())) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		studentRepository.save(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@DeleteMapping("student/{id}")
	@ApiOperation(value = "Brise studenta iz baze podataka cija je ID vrednost prosledjena kao PATH varijabla")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id){
		if (!studentRepository.existsById(id)) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		studentRepository.deleteById(id);
		if(id==-100) {
			jdbcTemplate.execute("INSERT INTO student VALUES (-100, 'Test', 'Student', 'TS1/1', -100, -100);");
		}
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
}
