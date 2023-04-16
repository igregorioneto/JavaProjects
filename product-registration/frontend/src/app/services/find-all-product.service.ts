import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../modules/Product';

@Injectable({
  providedIn: 'root'
})
export class FindAllProductService {
    private url = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.url}/products`);
  }
}