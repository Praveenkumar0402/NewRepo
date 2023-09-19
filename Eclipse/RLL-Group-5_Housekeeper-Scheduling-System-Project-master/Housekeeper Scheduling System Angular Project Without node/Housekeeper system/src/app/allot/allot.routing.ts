import { Routes } from '@angular/router';

import { AllotComponent } from './allot.component';

export const AllotRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'allot',
        component: AllotComponent
    }]
}
];
