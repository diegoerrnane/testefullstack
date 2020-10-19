import { Component, OnInit } from '@angular/core';
import { CreateAccountService } from '../shared/create-account.service';
import { Usuario } from "../../usuario";
import { AccountService } from "../shared/account.service";
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-create-account',
    templateUrl: './create-account.component.html',
    styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

    usuario: Usuario = new Usuario();
    private email;
    desabilitar = false;

    constructor(private createAccountService: CreateAccountService,
        private accountService: AccountService,
        private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.desabilitar;
            if (params['email']) {
                this.accountService.findByEmail(params['email']).subscribe(
                    usuario =>{
                        this.usuario = usuario;
                        this.usuario.senha = null;
                        this.desabilitar = true;
                    });
            }
        });
    }

    search() {
        this.createAccountService.searchCep(this.usuario.cep).subscribe(response => {
            this.converterJson(response);
        });
    }

    private converterJson(dados) {
        this.usuario.logradouro = dados.logradouro;
        this.usuario.bairro = dados.bairro;
        this.usuario.cidade = dados.localidade;
        this.usuario.uf = dados.uf;
    }

    async criarConta() {
        try {
            this.accountService.save(this.usuario);
        } catch (error) {
            console.log(error)
        }
    }

    async editar() {
        try {
            this.accountService.save(this.usuario);
        } catch (error) {
            console.log(error)
        }
    }

    getCpfCnpjMask(){}

    onSubmit() { }
}
