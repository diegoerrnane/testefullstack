import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from "../../../environments/environment";

@Injectable()
export class CreateAccountService {

    private resourceUrl = environment.createaccountApiUrl

    constructor(private httpClient: HttpClient) {
    }

    searchCep(cep: string): Observable<any> {
        return this.httpClient.get(`https://viacep.com.br/ws/${cep}/json/`);
    }
}
