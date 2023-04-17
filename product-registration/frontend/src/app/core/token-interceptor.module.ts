import { Injectable, NgModule } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { ServicesService } from '../services/services.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private readonly servicesService: ServicesService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    let token = this.servicesService.retrive();
    let header = token !== null ? 'Bearer ' + token : '';

    const authReq = request.clone({
      headers: request.headers.set('Authorization', (header) ? header : '' )
    });
    
    return next.handle(authReq);
  }
}


@NgModule({
  providers: [{
     provide: HTTP_INTERCEPTORS,
     useClass: TokenInterceptor,
     multi: true,
  }]
})

export class Interceptor { }