import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
    private url = "http://localhost:8080";

  constructor(
    private readonly http: HttpClient,
    private readonly servicesService: ServicesService
  ) {}

  public userLogged(): Observable<any> {
    return this.http.get<any>(`${this.url}/user/logged`);
  }
}