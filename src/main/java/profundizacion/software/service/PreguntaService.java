package profundizacion.software.service;

import java.util.List;
import profundizacion.software.model.Pregunta;

public interface PreguntaService {
	
	Pregunta findById(long codigo);
	
	Pregunta findByEnunciado(String enuncuiado);
	
	Pregunta createPregunta (Pregunta pregunta);
	
	Pregunta updatePregunta (Pregunta pregunta);
	
	void deletePreguntaById (long codigo);
	
	List<Pregunta> findAllPreguntas();
	
	boolean ifPregunaExist(Pregunta pregunta); 
	
	
	

}
