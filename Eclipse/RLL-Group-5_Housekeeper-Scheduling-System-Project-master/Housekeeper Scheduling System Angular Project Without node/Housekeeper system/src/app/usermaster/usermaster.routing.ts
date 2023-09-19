import { Routes } from '@angular/router';

import { UsermasterComponent } from './usermaster.component';

export const UserRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'usermaster',
        component: UsermasterComponent
    }]
}
];
