import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterhousekeeperComponent } from './registerhousekeeper.component';
import { RouterModule } from '@angular/router';
import { RegisterHousekeeperRoutes } from './registerhousekeeper.routing';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
@NgModule({
  declarations: [RegisterhousekeeperComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(RegisterHousekeeperRoutes),
    ReactiveFormsModule,FormsModule
  ]
})
export class RegisterhousekeeperModule { }
