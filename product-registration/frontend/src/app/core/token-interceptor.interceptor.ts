import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { ServicesService } from '../services/services.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private service: ServicesService) { 
    console.log(this.service.retrive())
  }

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler, ): Observable<HttpEvent<any>> {
    const dupReq = request.clone({
      headers: request.headers.set('Authorization', `bearer ${this.service.retrive()}`)
    });
    return next.handle(dupReq);
  }
}