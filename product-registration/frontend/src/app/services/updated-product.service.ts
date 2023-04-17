import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../modules/Product';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root'
})
export class UpdatedProductService {
    private url = "http://localhost:8080";

  constructor(private http: HttpClient, private service: ServicesService) { }

  public updated(id:any, product: any) {
    const token = "Bearer "+this.service.retrive() || "";
    const headers = { 'Authorization': token }
    return this.http.put(`${this.url}/products/${id}`, product, { headers: headers });
  }
}