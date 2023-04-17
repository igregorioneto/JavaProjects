import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { Product } from 'src/app/modules/Product';
import { CreatedProductService } from 'src/app/services/created-product.service';
import { FindByIdProductService } from 'src/app/services/find-by-id-product.service';
import { ServicesService } from 'src/app/services/services.service';
import { UpdatedProductService } from 'src/app/services/updated-product.service';

@Component({
  selector: 'app-created-product',
  templateUrl: './created-product.component.html',
  styleUrls: ['./created-product.component.scss']
})
export class CreatedProductComponent implements OnInit  {

  user: any = {}

  product!: Product | null;

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
    private readonly servicesService: ServicesService,
    private readonly createdProductService: CreatedProductService,
    private readonly router: Router,
    private activatedRoute: ActivatedRoute,
    private readonly findByIdProductService: FindByIdProductService,
    private readonly updatedProductService: UpdatedProductService,
  ) { }

  ngOnInit(): void {
    this.formCreatedEditedProduct();
    const productId = this.activatedRoute.snapshot.paramMap.get('id');
    if (productId === null) {
      this.product = null;
      this.editForm?.get("name")?.setValue("");
      this.editForm?.get("provider")?.setValue("");
      this.editForm?.get("amount")?.setValue(0);
    } else {
      this.findByIdProductService.findById(productId)
      .subscribe({
        next: (v) => {          
          this.product = v;
          
          this.editForm?.get("name")?.setValue(this.product?.name);
          this.editForm?.get("provider")?.setValue(this.product?.provider);
          this.editForm?.get("amount")?.setValue(this.product?.amount);

          this.items.splice(
            1,
            1,
            {
              label: 'Created Product',
              icon: 'pi pi-fw pi-plus',
              routerLink: "/created-product"
            },
            {
              label: 'Logout',
              icon: 'pi pi-fw pi-power-off',
              command:() => this.logout(),
              routerLink: "/login"
            }
          )
        },
      })
    }


    this.items = [       
        {
            label: 'Home',
            icon: 'pi pi-fw pi-home',
            routerLink: "/home"
        },
        {
          label: 'Logout',
          icon: 'pi pi-fw pi-power-off',
          command:() => this.logout(),
          routerLink: "/login"
        }
    ];
  }

  formCreatedEditedProduct(): void {
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
        provider: new FormControl(
          "",
          Validators.compose([
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(1000)
          ])
        ),
        amount: new FormControl(
          0,
          Validators.compose([
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(1000)
          ])
        )
      }
    ); 
  }

  async editValue(edit: any) {
    this.formCreatedEditedProduct();
    const productId = this.activatedRoute.snapshot.paramMap.get('id');

    if (productId === null) {
      await this.createdProductService.create(edit)
      .subscribe({
        next: (v) => {
          this.router.navigate(['/home']);
        },
      })

    } else {
      await this.updatedProductService.updated(productId, edit)
      .subscribe({
        next: (v) => {
          console.log(v)
          this.router.navigate(['/home']);
        },
      })
      
    }

    
  }

  logout(): void {
    this.servicesService.remove();
    this.router.navigate(['/login']);
  }

  close(): void {
    this.router.navigate(['/home']);
  }

}
