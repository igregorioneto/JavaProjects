import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { Product } from 'src/app/modules/Product';
import { DeletedProductService } from 'src/app/services/deleted-product.service';
import { FindAllProductService } from 'src/app/services/find-all-product.service';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  products!: any;

  items!: MenuItem[];

  constructor(
    private readonly servicesService: ServicesService,
    private readonly findAllProductService: FindAllProductService,
    private readonly deletedProductService: DeletedProductService,
    private readonly router: Router,
  ){}

  ngOnInit() {
    this.loadingDados();
    this.items = [          
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
    ];
  }

  loadingDados() {
    this.findAllProductService.findAll().subscribe({
      next: (v) => {
        this.products = v;
      },
    });
  }

  logout(): void {
    this.servicesService.remove();
    this.router.navigate(['/login']);
  }

  deleteUser(id: any) {
    this.deletedProductService.delete(id).subscribe({
      next: (v) => {
        this.loadingDados()
      },
    })
  }

  updateUser(id: any) {
    this.router.navigate(['/created-product/' + id]);
  }


}
