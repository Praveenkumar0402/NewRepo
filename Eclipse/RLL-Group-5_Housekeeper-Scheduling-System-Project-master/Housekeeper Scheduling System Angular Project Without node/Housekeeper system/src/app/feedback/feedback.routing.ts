import { Routes } from '@angular/router';

import { FeedbackComponent } from './feedback.component';

export const FeedbackRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'feedback',
        component: FeedbackComponent
    }]
}
];
