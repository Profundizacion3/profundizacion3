import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { Error404Component } from './error404/error404.component';
import { InicioComponent} from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';




const appRoutes: Routes =[
		{path: '', component : AppComponent},
		//{path: 'pregunta', component : PreguntaComponent},
		//{path: 'admin', component: AdminComponent},
		//{path: 'evaluador', component: EvaluadorComponent},
		//{path: 'profesor', component: ProfesorComponent},
		//{path: 'estudiante', component: EstudianteComponent},
		//{path: 'fruta', component: FrutaComponent},
		{path: 'inicio', component: InicioComponent},
		//{path: 'contacto', component: ContactoComponent},
		//{path: 'contacto/:page', component: ContactoComponent},
		{path: '**', component: Error404Component},
		{path: 'error404', component: Error404Component },
		{path: 'login', component: LoginComponent }

 ];


export const appRoutingProviders: any[]=[];

/*
	Se le pasan las rutas al ModuleWithProviders mediante el metodo forRoot
*/

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);