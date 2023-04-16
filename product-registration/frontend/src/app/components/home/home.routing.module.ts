import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./home.component";
import { TableModule } from 'primeng/table';

const loginRoutes: Routes = [
    { path: '', component: HomeComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(loginRoutes),
  ],
  exports: [RouterModule],
})
export class HomeRoutingModule { }