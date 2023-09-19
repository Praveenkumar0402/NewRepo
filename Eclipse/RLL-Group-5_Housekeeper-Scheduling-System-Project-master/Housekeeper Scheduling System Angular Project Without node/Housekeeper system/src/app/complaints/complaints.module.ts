import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComplaintsComponent } from './complaints.component';
import {ComplaintsRoutes } from './complaints.routing'
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [ComplaintsComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(ComplaintsRoutes)
  ]
})
export class ComplaintsModule { }
