import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { Error404Component } from "./error404.component";

const loginRoutes: Routes = [
    { path: '', component: Error404Component }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(loginRoutes)],
  exports: [RouterModule]
})
export class Error404RoutingModule { }