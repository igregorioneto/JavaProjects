import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { HomeService } from '../services/home.service';
import { ServicesService } from '../services/services.service';

@Injectable({
  providedIn: 'root'
})
export class GuardGuard implements CanActivate {
  constructor(
    private readonly servicesService: ServicesService,
    private readonly homeService: HomeService,
    private readonly router: Router
    ) {}

  async canActivate() {
    let token = this.servicesService.retrive();
    if (token === '' || token === null || token === undefined) {
      this.router.navigateByUrl('login', { replaceUrl: true });
      return false;
    } else {
      await this.homeService.userLogged()
      .subscribe(
        async data => {
         this.router.navigateByUrl('home', { replaceUrl: true })
        });
      
      return true;
    }
    
  }
  
}