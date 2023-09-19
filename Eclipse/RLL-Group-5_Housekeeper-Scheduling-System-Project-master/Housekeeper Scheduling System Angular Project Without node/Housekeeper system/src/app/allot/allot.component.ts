import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../services/common.service';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-allot',
  templateUrl: './allot.component.html',
  styleUrls: ['./allot.component.css']
})
export class AllotComponent implements OnInit {
  requestid :any ;
  roomnumber :any;
  timerequested : any;
  housekeeper :any;


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


  createallot = () => {
    try{
      console.log("Allot ===================",{
        requestid : this.requestid,
        roomnumber : this.roomnumber,
        timerequested : this.timerequested,
        housekeeper : this.housekeeper
      });

    }catch(err){
      console.log("err========================",err);
    }
  }

}
