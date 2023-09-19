import { Routes } from '@angular/router';

import { SuggestionsComponent } from './suggestions.component';

export const SuggestionsRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: 'suggestions',
        component: SuggestionsComponent
    }]
}
];
