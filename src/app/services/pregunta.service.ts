import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import 'rxjs/add/operator/toPromise';
import { Pregunta } from '../models/Pregunta';


@Injectable()
export class PreguntaService {

	private header = new Headers({'Content-Type': 'application/json'}); 
	private urlPregunta = 'http://localhost:8080/api/pregunta';
  private urlPreguntasArea = 'http://localhost:8080/api/preguntas-area';


  constructor(private http: Http) { } 

  getPreguntas(): Promise<Pregunta[]>{
  	return this.http
  				.get(this.urlPregunta)
  				.toPromise()
  				.then(response => response.json() as Pregunta[])
  				.catch(this.handleError);
  }

  getPregunta(codigo:number): Promise<Pregunta[]>{
  	const url = `${this.urlPregunta}/${codigo}`;
  	
  	return this.http
	  			.get(url)
	  			.toPromise()
	  			.then(response => response.json() as Pregunta)
	  			.catch(this.handleError);
  }

  getPreguntasArea(codArea:number): Promise<Pregunta[]>{
    const urlArea = `${this.urlPreguntasArea}/${codArea}`;
  	//const url = `${urlArea}/${codArea}`;
    console.log("URL Preguntas-Area: "+ urlArea);
  	return this.http
  				.get(urlArea)
  				.toPromise()
  				.then(response => response.json() as Pregunta[])
  				.catch(this.handleError);


  }

  createPregunta(pregunta: Pregunta): Promise<Pregunta>{
  	return this.http
  				.post(this.urlPregunta, JSON.stringify(pregunta), {headers: this.header})
  				.toPromise()
  				.then(response => response.json() as Pregunta[])
  				.catch(this.handleError);

  }

  updatePregunta(pregunta: Pregunta): Promise<Pregunta> {
    const url = `${this.urlPregunta}/${pregunta.codigo}`;

    return this.http
                .put(url, JSON.stringify(pregunta),{headers: this.header} )
                .toPromise()
                .then(() => pregunta)
                .catch(this.handleError);
  }

  deletePregunta(codigo:number): Promise<void>{
    const url = `${this.urlPregunta}/${codigo}`;

    return this.http
                .delete(url, {headers: this.header})
                .toPromise()
                .then(()=> null)
                .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
	    console.error('Error', error); // for demo purposes only
	    return Promise.reject(error.message || error);
  }
}
