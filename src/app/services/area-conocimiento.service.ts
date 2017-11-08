import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import 'rxjs/add/operator/toPromise';

import { AreaConocimiento } from '../models/AreaConocimiento'

@Injectable()
export class AreaConocimientoService {

	private header = new Headers({'Content-Type': 'application/json'}); 

	private areaUrl = 'http://localhost:8080/api/area-conocimiento';

  	constructor(private http: Http) { }

  	// Get all area-conocimiento

  	getAreasConocimiento(): Promise<AreaConocimiento[]>{
  		return this.http 
  					.get(this.areaUrl)
  					.toPromise()
  					.then(response => response.json() as AreaConocimiento[]) 
  					.catch(this.handleError);
  	}

  	getAreaConocimiento(codigo:number): Promise<AreaConocimiento[]>{
  		const url = `${this.areaUrl}/${codigo}`;

  		return this.http
  					.get(url).toPromise()
  					.then(response => response.json() as AreaConocimiento)
  					.catch(this.handleError);
  	}


  	create(areaConocimiento: AreaConocimiento): Promise<AreaConocimiento>{
  		return this.http
  				.post(this.areaUrl, JSON.stringify(areaConocimiento), {headers: this.header})
  				.toPromise()
  				.then(res => res.json() as AreaConocimiento)
  				.catch(this.handleError);
  	}

  	private handleError(error: any): Promise<any> {
	    console.error('Error', error); // for demo purposes only
	    return Promise.reject(error.message || error);
  }
}
