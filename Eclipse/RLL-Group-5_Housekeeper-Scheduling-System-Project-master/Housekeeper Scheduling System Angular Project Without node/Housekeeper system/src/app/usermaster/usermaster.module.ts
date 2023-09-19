import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
// import {MatTableModule} from '@angular/material/table';
import {MatExpansionModule} from '@angular/material/expansion';
import { UserRoutes } from './usermaster.routing';
import { UsermasterComponent } from './usermaster.component'
import {MatTabsModule} from '@angular/material/tabs';

@NgModule({
  declarations: [UsermasterComponent],
  imports: [
    CommonModule,
    RouterModule,
    MatExpansionModule,
    MatTabsModule,
    RouterModule.forChild(UserRoutes),
    ReactiveFormsModule
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class UsermasterModule { }
