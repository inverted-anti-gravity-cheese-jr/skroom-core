import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  register(userName: string, email: string, password: string, secQuestion: string, secAnswer: string) {
    console.log({
      'userName': userName,
      'email': email,
      'pass': password,
      'question': secQuestion,
      'answer': secAnswer
    });
    document.cookie = "jsessionid: " + userName + "; expires=Thu, 12 Dec 2019 23:59:59 UTC; path=/";
  }

}
