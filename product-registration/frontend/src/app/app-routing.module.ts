import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardGuard } from './guard/guard.guard';

const routes: Routes = [
  {
    path: 'error',
    loadChildren: () => 
      import('./components/error404/error.module').then(
        (m) => m.Error404Module
      ),
  },
  {
    path: 'login',
    loadChildren: () => 
      import('./components/login/login.module').then(
        (m) => m.LoginModule
      )
  },
  {
    path: 'home',
    loadChildren: () => 
      import('./components/home/home.module').then(
        (m) => m.HomeModule
      ),
      canActivate: [ GuardGuard ],
      pathMatch: 'full'
  },
  {
    path: 'created-product',
    loadChildren: () => 
      import('./components/created-product/created-product.module').then(
        (m) => m.CreatedProductModule
      ),
      canActivate: [ GuardGuard ],
  },
  {
    path: '**',
    redirectTo: 'error',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppRoutingModule { }
