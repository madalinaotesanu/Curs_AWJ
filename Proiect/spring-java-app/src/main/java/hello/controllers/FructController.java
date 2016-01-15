package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class FructController {
  private List<Fruct> fructe = new ArrayList<Fruct>();

  FructController() {
    Fruct f1 = new Fruct(1, "portocala");
    Fruct f2 = new Fruct(2, "lamaie");
    Fruct f3 = new Fruct(3, "mar");
    Fruct f4 = new Fruct(4, "mar");

    fructe.add(f1);
    fructe.add(f2);
    fructe.add(f3);
    fructe.add(f4);
  }

  @RequestMapping(value="/fruct", method = RequestMethod.GET)
  public List<Fruct> index() {
    return this.fructe;
  }

  @RequestMapping(value="/fruct/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Fruct f : this.fructe) {
      if(f.getId() == id) {
        return new ResponseEntity<Fruct>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/fruct/{id}/{name}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id, @PathVariable("name") String name) {
    for(Fruct f : this.fructe) {
      if(f.getId() == id) {
        this.fructe.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
@RequestMapping(value="/fruct", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Fruct f) {
    this.fructe.add(f);
	return new ResponseEntity<List<Fruct>>(this.fructe, new HttpHeaders(), HttpStatus.OK);
  }
  
@RequestMapping(value="/fruct/{id}/{name}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id, @PathVariable("name") String name){
	  for(Fruct f : this.fructe) {
		  if(f.getId() == id) {
			  f.setName(name);
			  return new ResponseEntity<List<Fruct>>(this.fructe, new HttpHeaders(), HttpStatus.OK);
		  }
	  }
	  return new ResponseEntity<List<Fruct>>(this.fructe, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
	
} 
