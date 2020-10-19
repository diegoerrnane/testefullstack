import { Usuario } from './../../usuario';
import { AuthService } from './../shared/auth.service';
import { Credenciais } from './../../credenciais';
import { CreateAccountComponent } from './../create-account/create-account.component';
import {Component, OnInit} from '@angular/core';
import {AccountService} from '../shared/account.service';
import {Router} from '@angular/router';
import { identifierModuleUrl } from '@angular/compiler';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    usuario: Usuario = new Usuario();
    login: Credenciais = new Credenciais();


    constructor(
        private accountService: AccountService,
        private router: Router,
        private auth: AuthService
    ) {
    }

    ngOnInit() {
        
    }

    async onSubmit() {
        try {
            this.auth.authenticate(this.login).subscribe(response =>{
                console.log(response.headers.get('Authorization'));
                this.router.navigate(['create-account',this.login.email]);
            })
        } catch (error) {
            console.error(error);
        }
    }
}
