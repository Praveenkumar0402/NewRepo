import { Routes } from '@angular/router';

import { RegisterstudentComponent } from './registerstudent.component';

export const RegisterStudentRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'registerstudent',
        component: RegisterstudentComponent
    }]
}
];
