import { Component, OnInit } from '@angular/core';
import { Pregunta } from '../models/Pregunta';

import { ActivatedRoute, Params, Router } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import { PreguntaService } from '../services/pregunta.service';

 

@Component({
  selector: 'app-preguntas-area',
 // templateUrl: './preguntas-area.component.html',
 template: '',
  styleUrls: ['./preguntas-area.component.css']
})
export class PreguntasAreaComponent implements OnInit {

	preguntasArea: Pregunta[];

	private codArea:number;

	pregunta = new Pregunta();
	submitted = false;

  
  constructor(
  	private preguntaService: PreguntaService,
  	private route: ActivatedRoute,
    private location: Location,
    private _activateRoute: ActivatedRoute,
  	private _router: Router
  ) { }

  getPreguntas(){

  	this._activateRoute.params.forEach((params:Params) =>{
  			this.codArea = params['codArea']; 
  		});


  	console.log('Codigo area: '+this.codArea);

  	return this.preguntaService
  				.getPreguntasArea(this.codArea)
  				.then(preguntasArea => this.preguntasArea = preguntasArea);
  	
  }

  ngOnInit():void{
    this.getPreguntas();
    console.log("data: "+this.preguntasArea);

  }

  onSubmit():void{
  	this.submitted = true;
  	//this.preguntaService.updatePregunta(this.pregunta);

  }

  delete(): void{
  	//this.preguntaService.deletePregunta(this.pregunta.codigo).then(()=> this.goBack());
  }

  goBack(): void {
    this.location.back();
  }


}
