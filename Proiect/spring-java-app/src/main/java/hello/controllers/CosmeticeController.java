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
public class CosmeticeController {
  private List<Cosmetice> cosmetice = new ArrayList<Cosmetice>();

  CosmeticeController() {
    Cosmetice c1 = new Cosmetice(1, "rimel");
    Cosmetice c2 = new Cosmetice(2, "ruj");
    Cosmetice c3 = new Cosmetice(3, "fond de ten");
    Cosmetice c4 = new Cosmetice(4, "creion de sprancene");

    cosmetice.add(c1);
    cosmetice.add(c2);
    cosmetice.add(c3);
    cosmetice.add(c4);
  }

  @RequestMapping(value="/cosmetice", method = RequestMethod.GET)
  public List<Cosmetice> index() {
    return this.cosmetice;
  }

  @RequestMapping(value="/cosmetice/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Cosmetice c : this.cosmetice) {
      if(c.getId() == id) {
        return new ResponseEntity<Cosmetice>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/cosmetice/{id}/{name}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id, @PathVariable("name") String name) {
    for(Cosmetice c : this.cosmetice) {
      if(c.getId() == id) {
        this.cosmetice.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
@RequestMapping(value="/cosmetice", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Cosmetice c) {
    this.cosmetice.add(c);
	return new ResponseEntity<List<Cosmetice>>(this.cosmetice, new HttpHeaders(), HttpStatus.OK);
  }
  
@RequestMapping(value="/cosmetice/{id}/{name}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id, @PathVariable("name") String name){
	  for(Cosmetice c : this.cosmetice) {
		  if(c.getId() == id) {
			  c.setName(name);
			  return new ResponseEntity<List<Cosmetice>>(this.cosmetice, new HttpHeaders(), HttpStatus.OK);
		  }
	  }
	  return new ResponseEntity<List<Cosmetice>>(this.cosmetice, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
	
} 
