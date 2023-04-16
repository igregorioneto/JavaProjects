import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../modules/User';

@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
    private url = "http://localhost:8080";
  
    constructor(private readonly http: HttpClient) { }
  
    login(data: any): Observable<any> {
      return this.http.post(`${this.url}/login`, data, {responseType: 'text'});
    }
  }