import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Product } from 'src/app/modules/Product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  products!: Product[];

  items!: MenuItem[];

  ngOnInit() {
    this.items = [          
        {
            label: 'Created Product',
            icon: 'pi pi-fw pi-plus',
            routerLink: "/created-product"
        },
        {
          label: 'Logout',
          icon: 'pi pi-fw pi-power-off',
          routerLink: "/login"
      }
    ];
}

}
