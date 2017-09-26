package profundizacion.software.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import profundizacion.software.model.Pregunta;
import profundizacion.software.service.PreguntaService;
import profundizacion.software.util.CustomErrorType;

@RestController
@RequestMapping("api")
public class PreguntaController {
	
	public static final Logger logger = LoggerFactory.getLogger(PreguntaController.class); 
	
	@Autowired
	PreguntaService preguntaService;
	
	/*
	 * TODO Obtiene todas la preguntas
	 * 
	 * */
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/pregunta", method = RequestMethod.GET)
	public List findAll(){
		return preguntaService.findAllPreguntas();
	}
	
	/*
	 * 	TODO	Obtiene una pregunta por codigo			
	 *
	 * */
	
	@RequestMapping(value = "/pregunta/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> getPregunta(@PathVariable("codigo") long codigo ){
		
		logger.info("Fetching Pregunta with codigo {}",codigo);
		
		Pregunta pregunta = preguntaService.findById(codigo);
		
		if(pregunta == null){
			logger.error("Pregunta with codigo {} not found",codigo);
			return new ResponseEntity(new CustomErrorType("Pregunta wiht codigo"+
					codigo+" not found"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
	}
	
	/*
	 * TODO  crear una pregunta 
	 * */
	
	@RequestMapping(value = "/pregunta/", method = RequestMethod.POST)
	public ResponseEntity<?> createPregunta(@RequestBody Pregunta pregunta, UriComponentsBuilder ucBuilder){
		
		logger.info("Creating Pregunta {}:", pregunta);
		
		if(preguntaService.ifPregunaExist(pregunta)){
			
			logger.error("Unable to create. A Pregunta with enunciado already exist ", pregunta.getEnunciado());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Pregunta with enunciado "+ 
											pregunta.getEnunciado()+"already exist "),HttpStatus.CONFLICT);

		}
		
		preguntaService.createPregunta(pregunta);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/pregunta/{codigo}").buildAndExpand(pregunta.getCodigo()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	} 
	
	/*
	 * 
	 * TODO Actualizar una pregunta
	 * 
	 * */
	
	public ResponseEntity<?> updatePregunta(@PathVariable("codigo") long codigo, @RequestBody Pregunta pregunta){
		
		logger.info("Actualizando pregunta con codigo {}",codigo);
		
		Pregunta currentPregunta = preguntaService.findById(codigo);
		
		if (currentPregunta == null) {
			logger.error("Imposible actualizar. No se encontró la Pregunta {}", codigo);
			
			return new ResponseEntity(new CustomErrorType("Imposible actualizar. No se encontró la Pregunta {}"+ 
										codigo), HttpStatus.NOT_FOUND);
		}
		
		currentPregunta.setEnunciado(pregunta.getEnunciado());
		currentPregunta.setOpcion1(pregunta.getOpcion1());
		currentPregunta.setOpcion2(pregunta.getOpcion2());
		currentPregunta.setOpcion3(pregunta.getOpcion3());
		currentPregunta.setOpcion4(pregunta.getOpcion4());
		currentPregunta.setOpcion5(pregunta.getOpcion5());
		currentPregunta.setRespuesta(pregunta.getRespuesta());
		currentPregunta.setCodAreaConocimiento(pregunta.getCodAreaConocimiento());
		
		preguntaService.updatePregunta(currentPregunta);		
		
		return new ResponseEntity<Pregunta>(currentPregunta, HttpStatus.OK);
	}
	
	/*
	 * TODO Eliminar una pregunta
	 * 
	 * */
	
	 @RequestMapping(value = "/pregunta/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePregunta(@PathVariable("codigo") long codigo){
		
		logger.info("Deleting pregunta {}",codigo);
		
		Pregunta currentPregunta = preguntaService.findById(codigo);
		
		
		if(currentPregunta == null){
			logger.error("No se encontro la Pregunta {}",codigo);
			
			return new ResponseEntity(new CustomErrorType("No se encontro la Pregunta {}"+codigo),
										HttpStatus.NOT_FOUND);
		}
		
		preguntaService.deletePreguntaById(codigo);
		
		
		return new ResponseEntity<Pregunta>(currentPregunta, HttpStatus.NO_CONTENT);
	}

}
