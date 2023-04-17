import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../modules/Product';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root'
})
export class FindAllProductService {
    private url = "http://localhost:8080";
    

  constructor(private http: HttpClient, private service: ServicesService) {}

  public findAll() {
    const token = "Bearer "+this.service.retrive() || "";
    const headers = { 'Authorization': token }
    return this.http.get(`${this.url}/products`, { headers: headers });
  }
}