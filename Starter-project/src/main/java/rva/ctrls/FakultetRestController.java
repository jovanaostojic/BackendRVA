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
import rva.jpa.Fakultet;
import rva.repository.FakultetRepository;

@CrossOrigin
@RestController
@Api(tags = {"Fakultet CRUD operacije"})
public class FakultetRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FakultetRepository fakultetRepository;
	
	@GetMapping("fakultet")
	@ApiOperation(value = "Vraca kolekciju svih fakulteta iz baze podataka")
	public Collection<Fakultet> getFakulteti() {
		return fakultetRepository.findAll();
	}
	
	@GetMapping("fakultet/{id}")
	@ApiOperation(value = "Vraca fakultet iz baze podataka cija je ID vrednost prosledjena kao PATH varijabla")
	public Fakultet getFakultet(@PathVariable("id") Integer id) {
		return fakultetRepository.getOne(id);
	}
	
	@GetMapping("fakultetNaziv/{naziv}")
	@ApiOperation(value = "Vraca kolekciju svih fakulteta iz baze podataka koji u nazivu sadrze string proslednjen kao PATH varijabla")
	public Collection<Fakultet> getFakultetByNaziv(@PathVariable("naziv") String naziv){
		return fakultetRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("fakultet")
	@ApiOperation(value = "Upisuje fakultet u bazu podataka")
	public ResponseEntity<Fakultet> insertFakultet(@RequestBody Fakultet fakultet) {
		if (!fakultetRepository.existsById(fakultet.getId())) {
			fakultetRepository.save(fakultet);
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("fakultet")
	@ApiOperation(value = "Modifikuje postojeci fakultet u bazi podataka")
	public ResponseEntity<Fakultet> updateFakultet(@RequestBody Fakultet fakultet) {
		if(!fakultetRepository.existsById(fakultet.getId())) {
			return new ResponseEntity<Fakultet>(HttpStatus.NO_CONTENT);
		}
		fakultetRepository.save(fakultet);
		return new ResponseEntity<Fakultet>(HttpStatus.OK);
	}
	
	@DeleteMapping("fakultet/{id}")
	@ApiOperation(value = "Brise fakultet iz baze podataka cija je ID vrednost prosledjena kao PATH varijabla")
	public ResponseEntity<Fakultet> deleteFakultet(@PathVariable("id") Integer id){
		if (!fakultetRepository.existsById(id)) {
			return new ResponseEntity<Fakultet>(HttpStatus.NO_CONTENT);
		}
		fakultetRepository.deleteById(id);
		if(id==-100) {
			jdbcTemplate.execute("INSERT INTO fakultet VALUES (-100, 'TestFaks', 'TestSediste');");
		}
		return new ResponseEntity<Fakultet>(HttpStatus.OK);
	}
}
