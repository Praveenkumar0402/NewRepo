import { Routes } from '@angular/router';

import { ClientmasterComponent } from './clientmaster.component';

export const ClientmasterRoutes: Routes = [
    {
        path: '',
        children: [{
            path: 'clientmaster',
            component: ClientmasterComponent
        }]
    }
]