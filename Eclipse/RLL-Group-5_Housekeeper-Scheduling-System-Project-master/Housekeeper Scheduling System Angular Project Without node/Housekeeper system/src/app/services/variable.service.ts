import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class VariableService {
  //  developer created array for the icons
  menuicon: any = [
    { path: "usermaster", icon: "mdi mdi-account-box" },
    { path: "customermaster", icon: "mdi mdi-account-location" },
    { path: "rawmaterialmaster", icon: "mdi mdi-archive" },
    { path: "productmaster", icon: "mdi mdi-account-card-details" },
    { path: "purchasemaster", icon: "mdi mdi-basket" },
    { path: "salemaster", icon: "mdi mdi-sale" },
    { path: "stockmaster", icon: "mdi mdi-material-ui" },
    { path: "expensemaster", icon: "mdi mdi-cash-100" },
    { path: "drivermaster", icon: "mdi mdi-steering" },
    { path: "transportmaster", icon: "mdi mdi-highway" },
    { path: "dashboard", icon: "mdi mdi-view-dashboard" },
    { path: "vehiclemaster", icon: "mdi mdi-car" },
    { path: "activitymaster", icon: "mdi mdi-odnoklassniki" },
    { path: "reportmaster", icon: "mdi mdi-file-send" },
    { path: "changepassword", icon: "mdi mdi-account-key" },
    { path: "profile", icon: "mdi mdi-account" },
    { path: "notificationmaster", icon: "mdi mdi-bell-ring-outline" },
    { path: "productionmaster", icon: "mdi mdi-contacts" },
  ];

  constructor() {}
  //getting items from local storage & store it in a variable
  user = JSON.parse(localStorage.getItem("user"));
}
