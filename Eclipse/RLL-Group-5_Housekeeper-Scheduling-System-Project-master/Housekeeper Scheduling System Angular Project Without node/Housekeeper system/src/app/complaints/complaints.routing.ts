import { Routes } from '@angular/router';

import { ComplaintsComponent } from './complaints.component';

export const ComplaintsRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'complaints',
        component: ComplaintsComponent
    }]
}
];
