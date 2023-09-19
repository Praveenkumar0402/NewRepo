import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RequestsComponent} from './requests.component';
import { RequestsRoutes} from './requests.routing'
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [RequestsComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(RequestsRoutes)
  ]
})
export class RequestsModule { }
