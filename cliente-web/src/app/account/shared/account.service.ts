import { Usuario } from '../../usuario';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { environment } from "../../../environments/environment";

@Injectable({
    providedIn: 'root'
})
export class AccountService {

    constructor(
        private httpClient: HttpClient,
        private router: Router) {}

    async login(user: any) {
        const result = await this.httpClient.post<any>('http://localhost:8080/login', user).toPromise();
    }

    async save(account: any) {
        try {
            if(account.id == null){
                const result = await this.httpClient.post<any>(`${environment.api}${environment.createaccountApiUrl}/incluir`, account).toPromise();
                this.router.navigate(['/login']);
                return result;
            } else {
                return this.httpClient.put(`${environment.api}${environment.createaccountApiUrl}/editar`, account).toPromise();
            }

        }catch (error) {
            console.error(error);
        }
        
    }
    findByEmail(email: any): Observable<Usuario> {
        return this.httpClient.get<Usuario>(` ${environment.api}${environment.createaccountApiUrl}/${email}`);
    }
}
