import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeedbackComponent } from './feedback.component';
import { FeedbackRoutes } from './feedback.routing'
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [FeedbackComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(FeedbackRoutes)
  ]
})
export class FeedbackModule { }
