import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CommonService } from "../services/common.service";
import { HttpService } from "../services/http.service";
import swal from 'sweetalert2';

@Component({
  selector: 'app-usermaster',
  templateUrl: './usermaster.component.html',
  styleUrls: ['./usermaster.component.css']

})
export class UsermasterComponent implements OnInit {
  userForm: FormGroup;
  panelOpenState = false;

  formstatus: String = '';
  getwaymasterform: FormGroup;
  id: string;

  isshown: boolean = true; // hidden by default


  data: string;
  iseditflag: boolean = false;
  dataSource: any;
  editUser: any;
  dataSource1: any;
  robotform: FormGroup;
  clientnamedisplay: any;
  dataSource2: any;


  constructor(public https: HttpService, public common: CommonService) {
    this.getUsers();
    this.getGetway();
    this.getRobots();
  }

  ngOnInit() {
    this.createuserform();
    this.createGetwayForm();
    this.createRobotForm();

  }

  toggleshow = () => {
    this.isshown = !this.isshown;
  }

  addusermaster = () => {
    try {
      console.log("SUCCESS", this.userForm.value)
      var userData = JSON.parse(localStorage.getItem('user')).data[0];
      console.log("session storage value => ", userData);

      let user = {
        "usermastername": this.userForm.value.firstname + ' ' + this.userForm.value.lastname,
        "emailid": this.userForm.value.useremail,
        "mobilenumber": this.userForm.value.usercontactno,
        "username": this.userForm.value.username,
        "password": this.userForm.value.userpassword,
        "usercategoryid": 2,
        "clientid": userData.usermasterid
      }
      this.https
        .commonAPICall(user, "/api/v1/usermaster/create")
        .subscribe((resUser) => {
          console.log(resUser);
          this.common.getPopup(
            null,
            "User Created Succesfully",
            null,
            null,
            false,
            false
          )
            .then((resGetPopup) => { });

        });
      this.getUsers();
      this.toggleshow();
      this.userForm.reset();

    } catch (errCreateUserMaster) {
      console.log("Log Error ===============", errCreateUserMaster)
    }
  }

  createuserform = () => {
    try {
      this.iseditflag = false;
      this.userForm = new FormGroup({
        firstname: new FormControl(null, [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(26),
          Validators.pattern("^[A-Za-z]+$"),
        ]),
        lastname: new FormControl(null, [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(26),
          Validators.pattern("^[A-Za-z]+$"),
        ]),

        useremail: new FormControl(null,
          Validators.pattern(
            "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$"
          )),
        usercontactno: new FormControl(null, [
          Validators.required,
          Validators.minLength(10),
          Validators.pattern("^((\\+91-?))?[0-9]{10}$"),
        ]),
        username: new FormControl(''),
        userpassword: new FormControl('')
      })

    } catch (err) {
      console.log("Error =================", err);
    }
  }

  editusermasterform = (element) => {
    console.log(element)
    this.editUser = element;
    this.formstatus = "Create User";
    this.iseditflag = true;
    this.toggleshow();
    try {
      this.userForm = new FormGroup({
        firstname: new FormControl(element.name),
        lastname: new FormControl(element.lastName),
        usercontactno: new FormControl(element.cno),
        useraddress: new FormControl(element.addr),
      })

    } catch (err) {
      console.log(err);
    }
  }

  editusermaster = () => {
    try {
      console.log("edit User master Details => ", this.userForm.value);
      let editUserMaster = {
        "_id": this.editUser._id,
        "userid": this.editUser.userid,
        "name": this.userForm.value.firstname,
        "lastName": this.userForm.value.lastname,
        "addr": this.userForm.value.useraddress,
        "cno": this.userForm.value.usercontactno
      }
      this.toggleshow();
      console.log("Edit User Master =>", editUserMaster);
      this.https
        .commonAPICall(editUserMaster, "/user/updateUser")
        .subscribe((resUser) => {
          console.log(resUser);
          this.common.getPopup(
            null,
            "User updated Succesfully",
            null,
            null,
            false,
            false
          )
            .then((resGetPopup) => { });

        });
      this.getUsers()
    } catch (err) {
      console.log(err);
    }

  }

  deleteusermaster = (usermasterid) => {
    console.log("Delete Id  => ", usermasterid);
    try {
      let user = {
        "usermasterid": usermasterid
      }
      const swalWithBootstrapButtons = swal.mixin({
        customClass: {
          confirmButton: 'btn btn-success',
          cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
      })
      swalWithBootstrapButtons.fire({
        title: 'Are you sure,you want delete it?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
      }).then((result) => {
        if (result.isConfirmed) {
          this.https
            .commonAPICall(user, "/api/v1/usermaster/delete")
            .subscribe((resUser) => {
              console.log(resUser);
            });
          this.getUsers()
        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire(
            'Cancelled',
            'Client is safe.',
            'error'
          )
        }
      })
    } catch (err) {
      console.log(err)
    }
  }

  getUsers = () => {
    var userData = JSON.parse(localStorage.getItem('user')).data[0];
    console.log("session storage value => ", userData);
    let data = {
      "usercategoryid": 2,
      "clientid": userData.clientid,
      "page": 1,
      "pagesize": 1000
    }

    this.https.commonAPICall(data, "/api/v1/usermaster/get").subscribe((resUsers) => {
      console.log("Users => ", resUsers);
      this.dataSource = resUsers.data;
      // this.dataSource = new MatTableDataSource(resSites);
      console.log("Data Source => ", this.dataSource);
    });
  }


  
  createGetwayForm = () => {
    try{
      this.id = 'G-' + Math.floor(Number(Math.random() * (10000 - 1) + 1));
      this.getwaymasterform = new FormGroup({
        getwaymasterid : new FormControl(this.id,[]),
        getwayname : new FormControl(null,[]),
        passcode : new FormControl(null,[]) 
      });
    }catch(err){
      console.log(err);
    }

  }

  createRobotForm = () => {
    try{
    
      this.robotform = new FormGroup({
        gatewayid : new FormControl(null,[]),
        robotname : new FormControl(null,[]),
        clientid : new FormControl(null,[]) ,
        clientname:new FormControl(null,[]) 
      });
    }catch(err){
      console.log(err);
    }

  }


  updateRobotForm = (clientid,clientname) => {
    try{
      console.log("info=======================",clientid,clientname)
      // this.id = 'G-' + Math.floor(Number(Math.random() * (10000 - 1) + 1));
      this.clientnamedisplay = clientname;
      this.robotform = new FormGroup({
        gatewayid : new FormControl(null,[]),
        robotname : new FormControl(null,[]),
        clientid : new FormControl(Number(clientid),[]) ,
        clientname: new FormControl(clientname)
      });
    }catch(err){
      console.log(err);
    }

  }

  addGetwayMaster(){
    try{

      console.log("Add getway master =======",this.getwaymasterform.value);
      var userData = JSON.parse(localStorage.getItem('user')).data[0];
      console.log("session storage value => ", userData);

      this.getwaymasterform.value.clientid =  userData.usermasterid;
      
      this.https
        .commonAPICall(this.getwaymasterform.value, "/api/v1/getwaymaster/create")
        .subscribe((resGetway) => {
          console.log(resGetway);
         // this.getGetway();
          if(resGetway.status){
            this.common.getPopup(
              null,
              "Getway Created Succesfully",
              null,
              null,
              false,
              false
            )
              .then((resGetPopup) => { });
          }else{
            this.common.getPopup(
              null,
              "Something wrong!",
              null,
              null,
              false,
              false
            )
              .then((resGetPopup) => { });
          }
         

        });
     // this.getUsers();

      this.getwaymasterform.reset();

    }catch(err){
      console.log("err==========================",err);
    }
  }

  addroboMaster(){
    try{

      // console.log("Add robo master =======",this.robotform.value);
      var userData = JSON.parse(localStorage.getItem('user')).data[0];
      console.log("session storage value => ", userData);

      this.getwaymasterform.value.adminid =  userData.usermasterid;
      

      console.log("robot master details ====================",this.robotform.value);

      let obj = {
        "clientid": this.robotform.value.clientid,
        "gatewayid": this.robotform.value.gatewayid,
        "robotname": this.robotform.value.robotname,
        "adminid": Number(userData.usermasterid),
        "clientname":this.robotform.value.clientname
      }

      this.https
        .commonAPICall(obj, "/api/v1/robotmaster/create")
        .subscribe((resGetRobot) => {
          console.log(resGetRobot);
         // this.getGetway();
          if(resGetRobot.status){
            this.common.getPopup(
              null,
              "Robot Created Succesfully",
              null,
              null,
              false,
              false
            )
              .then((resGetPopup) => { });
          }else{
            this.common.getPopup(
              null,
              "Something wrong!",
              null,
              null,
              false,
              false
            )
              .then((resGetPopup) => { });
          }
         

        });
    //  this.getUsers();

      this.robotform.reset();

    }catch(err){
      console.log("err==========================",err);
    }
  }

  getGetway = () => {
    var userData = JSON.parse(localStorage.getItem('user')).data[0];
    console.log("session storage value => ", userData);
    let data = {
      "getwaymasterid": null,
      "clientid": userData.clientid,
      "page": 1,
      "pagesize": 1000
    }

    this.https.commonAPICall(data, "/api/v1/getwaymaster/get").subscribe((resGetway) => {
      console.log("Gateway => ", resGetway);
      this.dataSource1 = resGetway.data;
      // this.dataSource = new MatTableDataSource(resSites);
      console.log("Data Source => ", this.dataSource1);
    });
  }

  getRobots = () => {
    var userData = JSON.parse(localStorage.getItem('user')).data[0];
    console.log("session storage value => ", userData);
    let data = {
      gatewayid : null,
      clientid :null,
      adminid:null,
      page: 1,
      pagesize: 1000
    }

    this.https.commonAPICall(data, "/api/v1/robotmaster/get").subscribe((resRobot) => {
      console.log("Robot res => ", resRobot);
      this.dataSource2 = resRobot.data;
      // this.dataSource = new MatTableDataSource(resSites);
      console.log("Data Source robot => ", this.dataSource2);
    });
  }
}
