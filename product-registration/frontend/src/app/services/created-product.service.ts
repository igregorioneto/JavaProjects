import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../modules/Product';

@Injectable({
  providedIn: 'root'
})
export class CreatedProductService {
    private url = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public create(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.url}/products`, product);
  }
}