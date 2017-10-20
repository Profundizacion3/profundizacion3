import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule} from '@angular/http';
import { LeftSideBarComponent } from './left-side-bar/left-side-bar.component';
import { RightSideBarComponent } from './right-side-bar/right-side-bar.component';
import { TopNavComponent } from './top-nav/top-nav.component';
import { Error404Component } from './error404/error404.component';
import { InicioComponent } from './inicio/inicio.component';

import { routing, appRoutingProviders } from './app.routing';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    LeftSideBarComponent,
    RightSideBarComponent,
    TopNavComponent,
    Error404Component,
    InicioComponent,
    LoginComponent
    
   
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
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
