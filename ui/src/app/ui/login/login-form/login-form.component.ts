import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  login(userName: string, password: string) {
    console.log("Logged in: " + userName);
    document.cookie = "jsessionid: " + userName + "; expires=Thu, 12 Dec 2019 23:59:59 UTC; path=/";
  }

}
