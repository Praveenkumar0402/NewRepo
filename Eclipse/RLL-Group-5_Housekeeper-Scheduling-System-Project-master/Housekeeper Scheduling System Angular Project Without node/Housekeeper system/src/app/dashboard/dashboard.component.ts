import { Component, OnInit } from '@angular/core';
import { CommonService } from "../services/common.service";
import { HttpService } from "../services/http.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {

  hdata = [
    {"hname":"Gaensh Raut","room": "Room12","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"},
    {"hname":"Dipak Kalal","room": "Room13","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"},
    {"hname":"Balaji Swami","room": "Room14","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"}

  ] 
  complaints: any =[];

  constructor(public https: HttpService, public common: CommonService) {
    if (sessionStorage.getItem('flag') == "false") {
      window.location.reload(true);
      sessionStorage.setItem('flag', 'true');
    }
  }
  

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


  }
