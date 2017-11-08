import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
	private codArea:number;
 
  constructor( private _activateRoute: ActivatedRoute,
  	private _router: Router) { }

   getPreguntasArea(){

  	this._activateRoute.params.forEach((params:Params) =>{
  			this.codArea = params['codArea']; 
  	});
}
  ngOnInit():void {
  	this.getPreguntasArea();
  }

}
