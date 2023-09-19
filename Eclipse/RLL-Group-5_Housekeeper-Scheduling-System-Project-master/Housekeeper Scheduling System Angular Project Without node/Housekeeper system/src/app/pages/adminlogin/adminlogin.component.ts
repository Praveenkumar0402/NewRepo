import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common.service';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  loginForm: FormGroup;
  adminForm: FormGroup;

  constructor(public https: HttpService,
    public router: Router,
    public common: CommonService) { }

  ngOnInit(): void {
    this.createLoginForm();
    this.createadminForm();
  }

  loginUser = () => {
    try {
      console.log("Login Form Value =============", this.loginForm.value)
      if (
        this.loginForm.value.username &&
        this.loginForm.value.username != null
      ) {
        if (
          this.loginForm.value.password &&
          this.loginForm.value.password != null
        ) {
          let body = {
            name: this.loginForm.value.username
              ? this.loginForm.value.username.trim()
              : null,
            password: this.loginForm.value.password
              ? this.loginForm.value.password.trim()
              : null,
          };
          console.log("body => ", body)

          this.https.verifyadmin(body, "/api/adminlogins").subscribe((res: string) => {
            console.log("res =====================", res);
            if (res) {
              sessionStorage.setItem("flag", 'false');
              this.router.navigateByUrl("/dashboard");
            }

          })


        } else {
          this.common
            .getPopup(null, "Please Enter Password", null, null, true, false)
            .then((resGetPopup) => { });
        }
      } else {
        this.common
          .getPopup(null, "Please Enter Username", null, null, true, false)
          .then((resGetPopup) => { });
      }
    } catch (error) { }
  };

  createLoginForm = () => {
    try {
      this.loginForm = new FormGroup({
        username: new FormControl(''),
        password: new FormControl('')
      })

    } catch (err) {
      console.log("Error =================", err);
    }
  }

  createadminForm = () => {
    try {
      this.adminForm = new FormGroup({
        name: new FormControl(''),
        password: new FormControl(''),
        hostel: new FormControl('')
      });

    } catch (err) {
      console.log("Error =================", err);
    }
  }

  adminRegister() {
    console.log('admin ==', this.adminForm.value);
    // http://localhost:8080/api/addAdmin_registration
    //http://localhost:8080/api/adminlogins

    this.https.commonPost(this.adminForm.value, "/api/addAdmin_registration").subscribe((res: string) => {
      console.log("res =====================", res);
      this.common.getPopup(
        null,
        "Admin Created Succesfully",
        null,
        null,
        false,
        false
      ).then((resGetPopup) => { });

    })

    this.createadminForm();
  }

  userlogin() {
    this.router.navigateByUrl("/pages/login");
  }

  login = () => {
    try {
      console.log("Login Forms Value ===", this.loginForm.value);
      if (this.loginForm.value.username == "admin" && this.loginForm.value.password == "admin") {
        sessionStorage.setItem("flag", 'false');
        this.router.navigateByUrl("/dashboard");
      }
      else {
        this.loginForm.reset();
        this.router.navigateByUrl("pages/login")
      }

    } catch (err) {
      console.log("err============", err);
    }

  }


}
