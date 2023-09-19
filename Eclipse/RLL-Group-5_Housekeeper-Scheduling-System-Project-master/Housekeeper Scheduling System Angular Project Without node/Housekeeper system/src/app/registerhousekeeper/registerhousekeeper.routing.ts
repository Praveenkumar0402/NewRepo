import { Routes } from '@angular/router';

import { RegisterhousekeeperComponent } from './registerhousekeeper.component';

export const RegisterHousekeeperRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'registerhousekeeper',
        component: RegisterhousekeeperComponent
    }]
}
];
