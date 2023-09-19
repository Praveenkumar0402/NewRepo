import { Component, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpService } from "../../services/http.service";
import { CommonService } from "../../services/common.service";
import { Router } from '@angular/router';
declare var $: any;

@Component({
    selector: 'app-login-cmp',
    templateUrl: './login.component.html'
})

export class LoginComponent implements OnInit, OnDestroy {
    test: Date = new Date();
    private toggleButton: any;
    private sidebarVisible: boolean;
    private nativeElement: Node;
    loginForm: FormGroup;
    user: any;
    arrToStr: string;
    menus: any;



    constructor(private element: ElementRef,
        public https: HttpService,
        public router: Router,
        public common: CommonService) {
        this.nativeElement = element.nativeElement;
        this.sidebarVisible = false;
    }

    ngOnInit() {
        var navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
        const body = document.getElementsByTagName('body')[0];
        body.classList.add('login-page');
        body.classList.add('off-canvas-sidebar');
        const card = document.getElementsByClassName('card')[0];
        setTimeout(function () {
            // after 1000 ms we add the class animated to the login/register card
            card.classList.remove('card-hidden');
        }, 700);
        this.createLoginForm();
    }

    login = () => {
        try {
            console.log("Login Forms Value ===", this.loginForm.value);
            if (this.loginForm.value.username=="admin" && this.loginForm.value.password=="admin")
            {
                sessionStorage.setItem("flag", 'true');
                this.router.navigateByUrl("/userdashboard");
            }
            else 
            {
                this.loginForm.reset();
                this.router.navigateByUrl("pages/login")
            }

        } catch (err) {
            console.log("err============", err);
        }

    }

    loginUser = () => {
        try {
            console.log("Login Form Value =============",this.loginForm.value)
            if (
                this.loginForm.value.username &&
                this.loginForm.value.username != null
            ) {
                if (
                    this.loginForm.value.password &&
                    this.loginForm.value.password != null
                ) {
                    let body = {
                        rollnumber: this.loginForm.value.username
                            ? this.loginForm.value.username.trim()
                            : null,
                        password: this.loginForm.value.password
                            ? this.loginForm.value.password.trim()
                            : null,
                    };
                    console.log("body => ",body)

                    this.https.verifyadmin(body, "/api/Student_Login").subscribe((res: string) => {
                        console.log("res =====================", res);
                        sessionStorage.setItem("flag", 'true');
                        this.router.navigateByUrl("/userdashboard");
            
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

    sidebarToggle() {
        var toggleButton = this.toggleButton;
        var body = document.getElementsByTagName('body')[0];
        var sidebar = document.getElementsByClassName('navbar-collapse')[0];
        if (this.sidebarVisible == false) {
            setTimeout(function () {
                toggleButton.classList.add('toggled');
            }, 500);
            body.classList.add('nav-open');
            this.sidebarVisible = true;
        } else {
            this.toggleButton.classList.remove('toggled');
            this.sidebarVisible = false;
            body.classList.remove('nav-open');
        }
    }
    ngOnDestroy() {
        const body = document.getElementsByTagName('body')[0];
        body.classList.remove('login-page');
        body.classList.remove('off-canvas-sidebar');
    }


    adminlogin(){
        this.router.navigateByUrl("/pages/adminlogin");
    }
}
