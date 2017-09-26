package profundizacion.software.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import profundizacion.software.model.AreaConocimiento;
import profundizacion.software.service.AreaConocimientoService;
import profundizacion.software.util.CustomErrorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api") 
public class AreaConocimientoController {
	
public static final Logger logger = LoggerFactory.getLogger(AreaConocimientoController.class);
	
	@Autowired
	AreaConocimientoService areaCService;
	
	/*
	 * --------------------------------------------------------------------
	 * 			TODO Retrieve all AreaConocimiento
	 * --------------------------------------------------------------------
	 * 
	 * */
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/areaconocimiento", method = RequestMethod.GET)
    public List findAll() { 	
		return areaCService.findAllAreasConocimiento(); 
    }
	
	
	/*
	 * --------------------------------------------------------------------
	 * 			TODO Retrieve Single AreaConocimiento
	 * --------------------------------------------------------------------
	 * 
	 * */
	
	@RequestMapping(value = "/areaconocimiento/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> getAreaConocimiento(@PathVariable("codigo") int codigo) {
	    	
	        logger.info("Fetching AreaConocimiento with id {}", codigo);
	        AreaConocimiento areaConocimiento = areaCService.findById(codigo);
	        
	        if (areaConocimiento == null) {
	            logger.error("AreaConocimiento with id {} not found.", codigo);
	            return new ResponseEntity(new CustomErrorType("Persona with id " 
	            		+ codigo + " not found"), HttpStatus.NOT_FOUND);
	        }
	        
	        return new ResponseEntity<AreaConocimiento>(areaConocimiento, HttpStatus.OK);
	    }
	
	/*
	 * ------------------------------------------------------------------------------
	 * 							TODO Create AreaConocimiento
	 * ------------------------------------------------------------------------------
	 * 
	 * */
	
	 @RequestMapping(value = "/areaconocimiento/", method = RequestMethod.POST)
	    public ResponseEntity<?> createPersona(@RequestBody AreaConocimiento areaC, UriComponentsBuilder ucBuilder) {
	        logger.info("Creating AreaConocimiento : {}", areaC);
	 
	        if (areaCService.ifAreaConocimientoExist(areaC)) {
	            logger.error("Unable to create. A AreaConocimiento with name {} already exist", areaC.getNombre());
	            return new ResponseEntity(new CustomErrorType("Unable to create. A AreaConocimiento with name " + 
	            		areaC.getNombre() + " already exist."),HttpStatus.CONFLICT);
	        }
	        areaCService.createAreaConocimiento(areaC);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/api/areaconocimiento/{codigo}").buildAndExpand(areaC.getCodigo()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	    }
	 
	 
	 /*
	  * --------------------------------------------------------
	  * 		TODO Update AreaConocimiento
	  * --------------------------------------------------------
	  * */
	 
	 @RequestMapping(value = "/areaconocimiento/{codigo}", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateAreaC(@PathVariable("codigo") int codigo, @RequestBody AreaConocimiento areaC) {
	        logger.info("Updating Persona with id {}", codigo);
	 
	        AreaConocimiento currentAreaC = areaCService.findById(codigo);
	 
	        if (currentAreaC == null) {
	            logger.error("Unable to update. AreaConocimiento with id {} not found.", codigo);
	            return new ResponseEntity(new CustomErrorType("Unable to upate. AreaConocimmiento with id " 
	            		+ codigo + " not found."), HttpStatus.NOT_FOUND);
	        }
	 
	        currentAreaC.setNombre(areaC.getNombre());
	        currentAreaC.setDescripcion(areaC.getDescripcion());
	 
	        areaCService.updateAreaConocimiento(currentAreaC);
	        return new ResponseEntity<AreaConocimiento>(currentAreaC, HttpStatus.OK);
	    }
	 
	 /*
	  * --------------------------------------------------------
	  * 		TODO Delete AreaConocimiento
	  * --------------------------------------------------------
	  * */
	 
	 
	 @RequestMapping(value = "/areaconocimiento/{codigo}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteAreaConocimiento(@PathVariable("codigo") int codigo) {
	        logger.info("Fetching & Deleting AreaConocimiento with id {}", codigo);
	 
	        AreaConocimiento currentAreac = areaCService.findById(codigo);
	        
	        if (currentAreac == null) {
	            logger.error("Unable to delete. AreaConocimiento with id {} not found.", codigo);
	            return new ResponseEntity(new CustomErrorType("Unable to delete. AreaConocimiento with id " 
	            		+ codigo + " not found."), HttpStatus.NOT_FOUND);
	        }
	        
	        areaCService.deleteAreaConocimientoById(codigo);
	        
	        return new ResponseEntity<AreaConocimiento>(currentAreac, HttpStatus.NO_CONTENT);
	    }
	 

}
