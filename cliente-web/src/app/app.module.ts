import { AuthService } from './account/shared/auth.service';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './account/login/login.component';
import {CreateAccountComponent} from './account/create-account/create-account.component';
import {HomeComponent} from './layout/home/home.component';
import {AuthenticationComponent} from './layout/authentication/authentication.component';
import {CreateAccountService} from './account/shared/create-account.service';

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        CreateAccountComponent,
        HomeComponent,
        AuthenticationComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule
    ],
    providers: [
        CreateAccountService,
        AuthService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
