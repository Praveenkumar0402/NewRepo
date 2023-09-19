import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../services/common.service';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-suggestions',
  templateUrl: './suggestions.component.html',
  styleUrls: ['./suggestions.component.css']
})
export class SuggestionsComponent implements OnInit {

  
  hdata = [
    {"hname":"Gaensh Raut","room": "Room12","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"},
    {"hname":"Dipak Kalal","room": "Room13","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"},
    {"hname":"Balaji Swami","room": "Room14","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"}

  ]
  

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

}
