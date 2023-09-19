import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common.service';

@Component({
  selector: 'app-registerstudent',
  templateUrl: './registerstudent.component.html',
  styleUrls: ['./registerstudent.component.css']
})
export class RegisterstudentComponent implements OnInit {

  rollnumber : any = null;
  roomnumber : any= null;
  floor :any= null;
  name: any= null;
  password:any= null;
  complaints: any =[];


  constructor(public https: HttpService,
    public router: Router,
    public common: CommonService) { }

  ngOnInit(): void {
    this.getcomplaints();
  }

  getcomplaints(){
    try{
      this.https.commonGet("/api/cleanRequests").subscribe((res) => {
        console.log("res =====================", res  );
        this.complaints = JSON.parse(res);

        
        console.log("comp====================",this.complaints);
      
      })

    }catch(err){
      console.log("err====",err);
    }
  }


  createStudent = () => {
    try{
      console.log("create student ============",{
        rollnumber : this.rollnumber,
        roomnumber : this.roomnumber,
        floor : this.floor,
        name: this.name,
        password: this.password
      })


      this.https.commonPost({
        rollnumber : this.rollnumber,
        roomnumber : this.roomnumber,
        floor : this.floor,
        name: this.name,
        password: this.password
      }, "/api/addEmployee_registration").subscribe((res: string) => {
        console.log("res =====================", res);
        this.common.getPopup(
          null,
          "Student Register Succesfully",
          null,
          null,
          false,
          false
        ).then((resGetPopup) => { });
  
      })

    }catch(err){
      console.log("err==========",err);
    }
  }
}
