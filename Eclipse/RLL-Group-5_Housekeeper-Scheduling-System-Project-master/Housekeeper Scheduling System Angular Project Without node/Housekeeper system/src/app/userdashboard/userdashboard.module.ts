import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserdashboardComponent } from './userdashboard.component';
import { UserdashboardRoutes } from './userdashboard.routing'
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [UserdashboardComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(UserdashboardRoutes)
  ]
})
export class UserdashboardModule { }
