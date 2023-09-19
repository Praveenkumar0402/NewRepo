import { Component, OnInit } from '@angular/core';
import { CommonService } from "../services/common.service";
import { HttpService } from "../services/http.service";

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {
  hdata = [
    { "hname": "Gaensh Raut", "room": "Room12", "date": new Date().toISOString(), "timere": "12:20AM", "tin": "12:30AM", "tout": "1:30Am" },
    { "hname": "Dipak Kalal", "room": "Room13", "date": new Date().toISOString(), "timere": "12:20AM", "tin": "12:30AM", "tout": "1:30Am" },
    { "hname": "Balaji Swami", "room": "Room14", "date": new Date().toISOString(), "timere": "12:20AM", "tin": "12:30AM", "tout": "1:30Am" }

  ]
  complaints: any = [];
  count: number = 0;

  constructor(public https: HttpService, public common: CommonService) {
    console.log("usertype ===", sessionStorage.getItem('flag'))
    if (sessionStorage.getItem('flag') == "true") {
      window.location.reload(true);
      sessionStorage.setItem('flag', 'false');
    }
  }

  ngOnInit(): void {
    this.getcomplaints();
  }

  getcomplaints() {
    try {
      this.https.commonGet("/api/cleanRequests").subscribe((res) => {
        console.log("res =====================", res);
        this.complaints = JSON.parse(res);
        this.count = this.complaints?this.complaints.length:0;

        console.log("comp====================", this.complaints);

      })

    } catch (err) {
      console.log("err====", err);
    }
  }


}
