import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { FormGroup, FormControl, Validators } from '@angular/forms';

export interface PeriodicElement {
  position: number;
  category: string;
  companyname: string;
  address: string;
  installationdate:string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, category: 'Owner', companyname: 'evov iot solution' ,address:"pune",installationdate:"09/03/2021"},
  { position: 2, category: 'Distrubuter', companyname: 'evov iot solution',address:"pune",installationdate:"09/03/2021"},
  { position: 3, category: 'Distrubuter', companyname: 'evov iot solution',address:"pune",installationdate:"09/03/2021"},
  { position: 4, category: 'Owner', companyname: 'evov iot solution',address:"pune",installationdate:"09/03/2021"}
];

@Component({
  selector: 'app-clientmaster',
  templateUrl: './clientmaster.component.html',
  styleUrls: ['./clientmaster.component.css']
})
export class ClientmasterComponent implements OnInit {

  userForm: FormGroup;
  
  formstatus:String = '';
  clientcategorys = {1: "Owner",2:"Patner",3:"End User"};

  displayedColumns: string[] = ['position', 'category', 'companyname', 'address', 'installationdate', 'edit','delete'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  isshown: boolean = true; // hidden by default

  // loginForm: FormGroup;

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  data: string;
  iseditflag: boolean = false;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  constructor() {

  }

  ngOnInit() {
    this.createuserform();
  }

  toggleshow = () => {
    this.isshown = !this.isshown;
  }

  addusermaster = () => {
    console.log("SUCCESS", this.userForm.value)
    this.toggleshow();
    this.userForm.reset();
  }

  createuserform = () => {
    try {
      this.iseditflag = false;
      this.userForm = new FormGroup({
        usercategoryid: new FormControl(null, []),
        companyname: new FormControl(null,[]),
        countryid: new FormControl(null,[]),
        address:new FormControl(null,[]),
        stateid: new FormControl(null,[]),
        cityid: new FormControl(null,[]),
        pincode: new FormControl(null,[]),
        dateofactivated: new FormControl(null,[])
        
      })

    } catch (err) {
      console.log("Error =================", err);
    }
  }

  editusermasterform = (element) => {
    console.log(element)
    this.formstatus = "Create User";
    this.iseditflag = true;
    this.toggleshow();
    try{
      this.userForm = new FormGroup({
        firstname: new FormControl(element.firstname),
        lastname: new FormControl(element.lastname),
        useremail: new FormControl(element.useremail,
          Validators.pattern(
            "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$"
          )),
        usercontactno: new FormControl(element.usercontactno),
        companyname: new FormControl(element.companyname),
        useraddress: new FormControl(element.useraddress),
      
      })

    }catch(err){
      console.log(err);
    }
  }

  editusermaster = () => {
    try{
      console.log("edit User master Details => ",this.userForm.value);
      this.toggleshow();

    }catch(err){
      console.log(err);
    }

  }

  deleteusermaster = (usermasterid) => {
    console.log("Delete Id  => ",usermasterid);
  }

}
