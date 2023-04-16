import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CreatedProductComponent } from "./created-product.component";

const loginRoutes: Routes = [
    { path: '', component: CreatedProductComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(loginRoutes)],
  exports: [RouterModule]
})
export class CreatedProductRoutingModule { }