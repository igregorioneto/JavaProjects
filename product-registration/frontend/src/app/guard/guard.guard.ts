import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { ServicesService } from '../services/services.service';

@Injectable({
  providedIn: 'root'
})
export class GuardGuard implements CanActivate {
  constructor(
    private readonly servicesService: ServicesService,
    private readonly router: Router
    ) {}

  async canActivate() {
    let token = this.servicesService.retrive();
    if (token === '' || token === null || token === undefined) {
      this.router.navigateByUrl('login', { replaceUrl: true });
      return false;
    } else {      
      return true;
    }
    
  }
  
}