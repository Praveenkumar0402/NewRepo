import { Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';

export const PagesRoutes: Routes = [

    {
        path: '',
        children: [ {
            path: 'login',
            component: LoginComponent
        }]
    },
    {
        path: '',
        children: [ {
            path: 'adminlogin',
            component: AdminloginComponent
        }]
    }
];
