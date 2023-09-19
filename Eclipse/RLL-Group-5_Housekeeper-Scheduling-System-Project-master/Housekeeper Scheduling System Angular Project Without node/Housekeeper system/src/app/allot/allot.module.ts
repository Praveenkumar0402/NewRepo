import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { AllotRoutes} from './allot.routing'
import { AllotComponent } from './allot.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [AllotComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(AllotRoutes),
    ReactiveFormsModule,
    FormsModule
  ]
})
export class AllotModule { }
