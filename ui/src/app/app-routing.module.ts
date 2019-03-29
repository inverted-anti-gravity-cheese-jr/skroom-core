import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './ui/login/login-form/login-form.component';
import { RegisterFormComponent } from './ui/login/register-form/register-form.component';

const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full"},
  { path: "login", component: LoginFormComponent},
  { path: "register", component: RegisterFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
