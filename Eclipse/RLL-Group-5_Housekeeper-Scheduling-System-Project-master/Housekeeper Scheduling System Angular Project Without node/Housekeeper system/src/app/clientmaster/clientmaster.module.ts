import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { ClientmasterComponent } from './clientmaster.component';
import { ClientmasterRoutes } from './clientmaster.routing';

@NgModule({
  imports: [
    CommonModule,
    FormsModule, ReactiveFormsModule,
    MaterialModule,
    RouterModule.forChild(ClientmasterRoutes)
  ],
  declarations: [ClientmasterComponent]
})
export class ClientmasterModule { }
