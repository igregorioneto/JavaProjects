import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { CreatedProductRoutingModule } from './created-product.routing.module';
import { MenubarModule } from 'primeng/menubar';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    TableModule,
    ButtonModule,
    CreatedProductRoutingModule,
    MenubarModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CreatedProductModule { }