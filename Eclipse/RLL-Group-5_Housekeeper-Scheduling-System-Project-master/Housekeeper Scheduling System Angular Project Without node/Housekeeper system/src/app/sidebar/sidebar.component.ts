import { Component, OnInit } from '@angular/core';
import PerfectScrollbar from 'perfect-scrollbar';

declare const $: any;

//Metadata
export interface RouteInfo {
    path: string;
    title: string;
    type: string;
    icontype: string;
    collapse?: string;
    children?: ChildrenItems[];
}

export interface ChildrenItems {
    path: string;
    title: string;
    ab: string;
    type?: string;
}
/*

*/
//Menu Items

let adminMenu = [
    {
        path: '/dashboard',
        title: 'Dashboard',
        type: 'link',
        icontype: ''
    },
    {
        path: '/allot',
        title: 'Allot',
        type: 'link',
        icontype: ''
    },
    {
        path: '/suggestions',
        title: 'Suggestions',
        type: 'link',
        icontype: ''
    },
    {
        path: '/registerstudent',
        title: 'Register Student',
        type: 'link',
        icontype: ''
    },
    {
        path: '/registerhousekeeper',
        title: 'Register Housekeeper',
        type: 'link',
        icontype: ''
    }
];

//suggestions

let usermenu = [
    {
        path: '/userdashboard',
        title: 'Dashboard',
        type: 'link',
        icontype: ''
    },
    {
        path: '/requests',
        title: 'Requests',
        type: 'link',
        icontype: ''
    },
    {
        path: '/feedback',
        title: 'Feedback',
        type: 'link',
        icontype: ''
    },
    {
        path: '/user',
        title: 'Profile',
        type: 'link',
        icontype: ''
    }
]





export const ROUTES: RouteInfo[] = [];
// for (let i = 0; i < adminMenu.length; i++) {
//             ROUTES.push(adminMenu[i]);
// }

let user = sessionStorage.getItem('flag');
console.log("usertype ==========", user);
if (user == "true") {
    console.log("exex if ===");
    for (let i = 0; i < adminMenu.length; i++) {
        ROUTES.push(adminMenu[i]);
    }

} else {
    console.log("exex else ===");
    for (let i = 0; i < usermenu.length; i++) {
        ROUTES.push(usermenu[i]);
    }
}



// let usertype = JSON.parse(localStorage.getItem("user")) == null ? "none" : JSON.parse(localStorage.getItem("user")).userType;

// if (usertype == "none") {

// } else if (usertype == "admin") {
//     for (let i = 0; i < adminMenu.length; i++) {
//         ROUTES.push(adminMenu[i]);
//     }
// } else if (usertype == "guard") {
//     for (let i = 0; i < guardMenu.length; i++) {
//         ROUTES.push(guardMenu[i]);
//     }
// }


@Component({
    selector: 'app-sidebar-cmp',
    templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
    public menuItems: any[];
    ps: any;
    isMobileMenu() {
        if ($(window).width() > 991) {
            return false;
        }
        return true;
    };

    ngOnInit() {
        this.menuItems = ROUTES.filter(menuItem => menuItem);
        if (window.matchMedia(`(min-width: 960px)`).matches && !this.isMac()) {
            const elemSidebar = <HTMLElement>document.querySelector('.sidebar .sidebar-wrapper');
            this.ps = new PerfectScrollbar(elemSidebar);
        }
    }
    updatePS(): void {
        if (window.matchMedia(`(min-width: 960px)`).matches && !this.isMac()) {
            this.ps.update();
        }
    }
    isMac(): boolean {
        let bool = false;
        if (navigator.platform.toUpperCase().indexOf('MAC') >= 0 || navigator.platform.toUpperCase().indexOf('IPAD') >= 0) {
            bool = true;
        }
        return bool;
    }
}
