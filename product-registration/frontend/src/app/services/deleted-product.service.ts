import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../modules/Product';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root'
})
export class DeletedProductService {
    private url = "http://localhost:8080";

  constructor(private http: HttpClient, private service: ServicesService) { }

  public delete(id: any) {
    const token = "Bearer "+this.service.retrive() || "";
    const headers = { 'Authorization': token }
    return this.http.delete(`${this.url}/products/${id}`, { headers: headers });
  }
}