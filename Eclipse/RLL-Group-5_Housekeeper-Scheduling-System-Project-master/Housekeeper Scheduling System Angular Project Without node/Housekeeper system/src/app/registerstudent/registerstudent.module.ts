import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterstudentComponent } from './registerstudent.component';
import { RegisterStudentRoutes } from './registerstudent.routing'
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';

@NgModule({
  declarations: [RegisterstudentComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forChild(RegisterStudentRoutes)
  ]
})
export class RegisterstudentModule { }
