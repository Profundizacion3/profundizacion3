import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule} from '@angular/http';

/*  Routing    */

import { routing, appRoutingProviders } from './app.routing';

/*
  Components
*/
import { AppComponent } from './app.component';
import { LeftSideBarComponent } from './left-side-bar/left-side-bar.component';
import { RightSideBarComponent } from './right-side-bar/right-side-bar.component';
import { TopNavComponent } from './top-nav/top-nav.component';
import { Error404Component } from './error404/error404.component';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { PreguntasAreaComponent } from './preguntas-area/preguntas-area.component';


/*
  Adding Services
*/
import { AreaConocimientoService } from './services/area-conocimiento.service';
import { PreguntaService } from './services/pregunta.service';


@NgModule({
  declarations: [
    AppComponent,
    LeftSideBarComponent,
    RightSideBarComponent,
    TopNavComponent,
    Error404Component,
    InicioComponent,
    LoginComponent,
    PreguntasAreaComponent 
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    routing
  ],
  providers: [
    appRoutingProviders,
    AreaConocimientoService,
    PreguntaService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
