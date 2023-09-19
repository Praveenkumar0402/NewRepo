import { Routes } from '@angular/router';

import { UserdashboardComponent } from './userdashboard.component';

export const UserdashboardRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'userdashboard',
        component: UserdashboardComponent
    }]
}
];
