import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/modules/User';
import { LoginService } from 'src/app/services/login.service';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

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
    private readonly loginService: LoginService,
    private readonly servicesService: ServicesService,
    private readonly router: Router,
  ) { }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(
      {
        username: new FormControl(
          "",
          Validators.compose([
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(20)
          ])
        ),
        password: new FormControl(
          "",
          Validators.compose([
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(20)
          ])
        )
      }
    ); 
  }

  async logar(data: User) {
    await this.loginService.login(data)
    .subscribe({
      next: (v) => console.log(v),
    })
  }

}
