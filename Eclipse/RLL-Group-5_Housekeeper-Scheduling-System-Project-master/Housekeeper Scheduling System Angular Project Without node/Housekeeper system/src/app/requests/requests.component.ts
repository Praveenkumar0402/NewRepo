import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common.service';
@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  date : any = null;
  time : any= null;
  complaints: any = [];

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


  createfeedback = () => {
    try{
      console.log("create student ============",{
        date: this.date,
        time : this.time
      })

      this.https.commonPost({
        date: this.date,
        time : this.time
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
