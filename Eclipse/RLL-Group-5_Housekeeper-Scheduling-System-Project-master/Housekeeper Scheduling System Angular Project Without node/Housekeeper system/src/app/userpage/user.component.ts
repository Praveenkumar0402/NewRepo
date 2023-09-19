import { Component, NgModule, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CommonService } from "../services/common.service";
import { HttpService } from "../services/http.service";
import {Router} from '@angular/router'
@Component({
    selector: 'app-user-cmp',
    templateUrl: 'user.component.html'
})

export class UserComponent implements OnInit {
    hdata = [
        {"hname":"Gaensh Raut","room": "Room12","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"},
        {"hname":"Dipak Kalal","room": "Room13","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"},
        {"hname":"Balaji Swami","room": "Room14","date": new Date().toISOString(),"timere": "12:20AM","tin":"12:30AM","tout":"1:30Am"}
    
      ] 
      complaints: any =[];
    
      constructor(public https: HttpService, public common: CommonService) {
      
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
