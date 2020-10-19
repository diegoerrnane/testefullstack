import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Credenciais } from './../../credenciais';
import { environment } from "../../../environments/environment";

@Injectable()
export class AuthService {

    constructor(public http: HttpClient){
    }

    authenticate(login: Credenciais) {
        return this.http.post('http://localhost:8080/login',
            login,
            {
                observe: 'response',
                responseType: 'text'
            });
    }
}

