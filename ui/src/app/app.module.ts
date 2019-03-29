import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PanelComponent } from './ui/base/panel/panel.component';
import { LoginFormComponent } from './ui/login/login-form/login-form.component';
import { RegisterFormComponent } from './ui/login/register-form/register-form.component';

@NgModule({
  declarations: [
    AppComponent,
    PanelComponent,
    LoginFormComponent,
    RegisterFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
