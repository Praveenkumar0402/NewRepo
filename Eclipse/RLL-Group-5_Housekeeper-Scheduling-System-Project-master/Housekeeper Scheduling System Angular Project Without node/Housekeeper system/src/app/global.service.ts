import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  public datashare = '';

  constructor() { }

  dataincomming = () => {
    return this.datashare;
  }

  dataoutgoing = (postvalue) => {
    this.datashare = postvalue;
    console.log("Data Outgoing =================",this.datashare);
  }
}

  
  
 