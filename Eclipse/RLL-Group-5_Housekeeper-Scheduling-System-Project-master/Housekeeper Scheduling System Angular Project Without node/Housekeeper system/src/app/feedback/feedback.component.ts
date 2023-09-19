import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common.service';


@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  rollnumber :any = null;
  request_id:any = null;
  rating:any = null;
  timeIn:any = null;
  timeOut:any = null;
  complaints:any = null;

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
  
  
    createFeedback = () => {
      try{
        console.log("create feedback ============",{
          rollnumber : this.rollnumber,
          request_id:this.request_id,
          rating: this.rating,
          timeIn:this.timeIn,
          timeOut:this.timeOut
        })
  
        this.https.commonPost({
          rollnumber : this.rollnumber,
          request_id:this.request_id,
          rating: this.rating,
          timeIn:this.timeIn,
          timeOut:this.timeOut
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
