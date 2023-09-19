import { Routes } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth/auth-layout.component';

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'pages/login',
    pathMatch: 'full',
  }, 
  {
    path: '',
    redirectTo: 'pages/adminlogin',
    pathMatch: 'full',
  },
  {
    path: '',
    component: AdminLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './dashboard/dashboard.module#DashboardModule'
      }, {
        path: '',
        loadChildren: './userpage/user.module#UserModule'
      },{
        path: '',
        loadChildren: './usermaster/usermaster.module#UsermasterModule'
      },{
        path: '',
        loadChildren: './allot/allot.module#AllotModule'
      },{
        path: '',
        loadChildren: './complaints/complaints.module#ComplaintsModule'
      },{
        path: '',
        loadChildren: './suggestions/suggestions.module#SuggestionsModule'
      },{
        path: '',
        loadChildren: './registerstudent/registerstudent.module#RegisterstudentModule'
      },{
        path: '',
        loadChildren: './registerhousekeeper/registerhousekeeper.module#RegisterhousekeeperModule'
      },{
        path: '',
        loadChildren: './userdashboard/userdashboard.module#UserdashboardModule'
      },{
        path: '',
        loadChildren: './requests/requests.module#RequestsModule'
      },{
        path: '',
        loadChildren: './feedback/feedback.module#FeedbackModule'
      }
      

    ]
  }, {
    path: '',
    component: AuthLayoutComponent,
    children: [{
      path: 'pages',
      loadChildren: './pages/pages.module#PagesModule'
    }]
  }
];
