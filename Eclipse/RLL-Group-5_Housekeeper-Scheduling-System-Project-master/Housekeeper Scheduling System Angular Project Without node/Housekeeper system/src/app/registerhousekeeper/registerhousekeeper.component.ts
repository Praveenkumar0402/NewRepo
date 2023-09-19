import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/services/common.service';

@Component({
  selector: 'app-registerhousekeeper',
  templateUrl: './registerhousekeeper.component.html',
  styleUrls: ['./registerhousekeeper.component.css']
})
export class RegisterhousekeeperComponent implements OnInit {
 
  housekeepername : any = null;
  floor :any = null;
  hostelName :any = null
  complaints: any = [];
  

  constructor(public https: HttpService,
    public router: Router,
    public common: CommonService) { }

  ngOnInit(): void {
    this.getcomplaints();
  }

  createHousekeeper = () => {
    try{  
      console.log("Register house keeper => ",{
        NamedNodeMap : this.housekeepername,
        floor :this.floor,
        hostelName : this.hostelName,
        complaints: 0
      });
      //http://localhost:8080/api/employees
      // "name": "test",
      // "hostelName": "test",
      // "floor": 1,
      // "complaints": 0

      this.https.commonPost({
        name : this.housekeepername,
        floor :this.floor,
        hostelName : this.hostelName,
        complaints: 0
      }, "/api/employees").subscribe((res: string) => {
        console.log("res =====================", res);
        this.common.getPopup(
          null,
          "Housekeeper Register Succesfully",
          null,
          null,
          false,
          false
        ).then((resGetPopup) => { });
  
      })


    }catch(err){
      console.log("err========",err);
    }
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
