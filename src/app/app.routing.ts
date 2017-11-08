import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { Error404Component } from './error404/error404.component';
import { InicioComponent} from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { PreguntasAreaComponent } from './preguntas-area/preguntas-area.component';




const appRoutes: Routes =[ 
		{path: '', component : AppComponent},
		{path: 'inicio', component: InicioComponent},
		{path: 'preguntas-area/:codArea', component: PreguntasAreaComponent},
		{path: '**', component: Error404Component},
		{path: 'error404', component: Error404Component },
		{path: 'login', component: LoginComponent }

 ];


export const appRoutingProviders: any[]=[];

/*
	Se le pasan las rutas al ModuleWithProviders mediante el metodo forRoot
*/

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);