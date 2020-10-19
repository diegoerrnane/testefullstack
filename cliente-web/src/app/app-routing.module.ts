import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './layout/home/home.component';
import {AuthenticationComponent} from './layout/authentication/authentication.component';
import {LoginComponent} from './account/login/login.component';
import {CreateAccountComponent} from './account/create-account/create-account.component';


const routes: Routes = [
    {
        path: '',
        component: AuthenticationComponent,
        children: [
            {path: '', redirectTo: 'login', pathMatch: 'full'},
            {path: 'login', component: LoginComponent},
            {path: 'create-account', component: CreateAccountComponent},
            {path: 'create-account/:email', component: CreateAccountComponent}
        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
