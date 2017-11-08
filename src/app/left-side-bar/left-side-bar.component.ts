import { Component, OnInit } from '@angular/core';
import { AreaConocimiento } from '../models/AreaConocimiento';
import { AreaConocimientoService } from '../services/area-conocimiento.service';

@Component({
  selector: 'app-left-side-bar',
  templateUrl: './left-side-bar.component.html',
  styleUrls: ['./left-side-bar.component.css']
})
export class LeftSideBarComponent implements OnInit {

	areasConocimiento: AreaConocimiento[];

  constructor(private areaSevice: AreaConocimientoService) { }

  getAreasConocimiento(){
  	return this.areaSevice
  				.getAreasConocimiento() 
  				.then(areasConocimiento => this.areasConocimiento = areasConocimiento);
  }

  ngOnInit():void { 
  	this.getAreasConocimiento();
  }

}
