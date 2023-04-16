import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-created-product',
  templateUrl: './created-product.component.html',
  styleUrls: ['./created-product.component.scss']
})
export class CreatedProductComponent implements OnInit  {

  user: any = {}

  items!: MenuItem[];

  validationMessages = {
    name: [
      {
        type: 'required',
        message: 'Insira um valor'
      },
      {
        type: 'minlength',
        message: 'Valor mínimo para depósito de R$5,00.'
      },
      {
        type: 'maxlength',
        message: 'Valor máximo para depósito de R$1.000,00.'
      }
    ]
  }

  editForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(
      {
        name: new FormControl(
          "",
          Validators.compose([
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(1000)
          ])
        ),
        email: new FormControl(
          "",
          Validators.compose([
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(1000)
          ])
        )
      }
    ); 

    this.items = [          
        {
            label: 'Home',
            icon: 'pi pi-fw pi-home',
            routerLink: "/home"
        },
        {
          label: 'Logout',
          icon: 'pi pi-fw pi-power-off',
          routerLink: "/login"
        }
    ];
  }

  editValue(edit: any) {
  }

}
