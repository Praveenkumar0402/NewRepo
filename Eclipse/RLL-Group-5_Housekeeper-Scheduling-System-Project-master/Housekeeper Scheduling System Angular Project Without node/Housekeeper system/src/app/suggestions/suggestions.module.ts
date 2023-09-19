import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuggestionsComponent } from './suggestions.component';
import { SuggestionsRoutes} from './suggestions.routing'
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [SuggestionsComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(SuggestionsRoutes)
  ]
})
export class SuggestionsModule { }
