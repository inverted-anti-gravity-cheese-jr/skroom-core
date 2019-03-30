import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  login(userName: string, password: string) {
    this.authenticationService.login(userName, password).subscribe((data) => {
      console.log("Logged as: " + data.userName);
      console.log(data);
    });
  }

}
