import { Injectable } from '@angular/core';
import { UserMetadata } from '../model/user-metadata';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ErrorDto } from '../dto/error.dto';

interface UserRequest {
  userName?: string;
  password: string;
  user?: UserMetadata;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private static readonly API_PATH: string = '/api/v1/auth';

  constructor(private http: HttpClient) { }

  currentUser(): Observable<UserMetadata> {
    return this.http.get<UserMetadata>(AuthenticationService.API_PATH);
  }

  login(userName: string, password: string) : Observable<UserMetadata> {
    let request: UserRequest = {
      "userName": userName,
      "password": password
    };
    return this.http.post<UserMetadata>(AuthenticationService.API_PATH, request);
  }

  register(user: UserMetadata, password: string) : Observable<ErrorDto> {
    let request: UserRequest = {
      "user": user,
      "password": password
    };
    return this.http.put<ErrorDto>(AuthenticationService.API_PATH, request);
  }

}
