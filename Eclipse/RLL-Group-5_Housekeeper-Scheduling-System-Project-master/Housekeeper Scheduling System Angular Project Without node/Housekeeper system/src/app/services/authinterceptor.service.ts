import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpInterceptor, HttpRequest, HttpEvent, HttpHandler, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class AuthinterceptorService {

  intercept(req: HttpRequest<any>,
            next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("Auth Interceptor file");
    //sessionStorage.removeItem('userInfo');
   // const userData = JSON.parse(localStorage.getItem('userInfo'));
    var userData = JSON.parse(localStorage.getItem('user')).data[0];
    // var userData = undefined;
    console.log( "session storage value => ",userData);

    if (userData === undefined) {
       //var d = JSON.parse(userData);
       //console.log(d);
      //const cloned = req.clone({ headers: req.headers.set("Authorization", d.token) });//d.id_token
      const cloned = req.clone ({
        headers: req.headers.set('Content-Type', 'application/json')
        .set('userid', userData.username)
        .set('secretuser', userData.cloudsecretuser)
        .set('Authorization', userData.token)

    });
      return next.handle(cloned).pipe(tap((event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            // if the token is valid
          }
         }, (err: any) => {
          // if the token has expired.
          if (err instanceof HttpErrorResponse) {
            if (err.status === 401) {
              localStorage.removeItem('user');
              this.router.navigate(['/login']);
              console.log('token expired');
            }
          }
      }));
  } else {
    const cloned = req.clone ({
      headers: req.headers.set('Content-Type', 'application/json')
      .set('userid', userData.username)
        .set('secretuser', userData.cloudsecretuser)
        .set('Authorization', userData.token)
      // .set('userid', "admin@101")
      //   .set('secretuser', "#Q^LP3@8le$df^8#")
      //   .set('Authorization', "294e9dddf5696c5ea3a1fb4e238d1212718861c05eb1ebb74cf80a363560cacfe9cdc83518bfa4f26d2641fe0c00f7d3af61a3acd6806ef16831f6b70dcfaea4caeca9aa9421383ee249e44bac332dbcb02cd49b43b56e3643c651c5e2c0cb8561d3ea60988d76168c05476056a7ebaa7b13201b29fef707016f1ba90c514076f34090df6989019932df276b10da0f92c50c2227d654ac383e45f570d076d72a1ee31fb4c30f610dec404845e0554d4cb3d1de7ae73447525d176e419ac95f36cdacbfa2b3bb1696f914783c3148ae39")

  });
    return next.handle(cloned).pipe(tap((event: HttpEvent<any>) => {
        if (event instanceof HttpResponse) {
          // if the token is valid
        }
       }, (err: any) => {
        // if the token has expired.
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401) {
            // localStorage.removeItem('userData');
            this.router.navigate(['/login']);
            console.log('token expired');
          }
        }
    }));

  }

}

  constructor(private router: Router) { }

}
