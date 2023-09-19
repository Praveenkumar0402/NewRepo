import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class HttpService {
  constructor(private http: HttpClient) {}
  serverurl: any = "http://localhost:8080"; // local server url


  commonAPICall(data,path): Observable<any> {
    return this.http.post(this.serverurl + path, data);
  }

  commonGetAPICall = (path): Observable<any> => {
    try {
      return this.http.get<any>(this.serverurl + path);
    } catch (error) {}
  };


  verifyadmin(data,path) {
    return this.http.post(this.serverurl+path, data, { responseType: 'text' })
  }

  commonPost(data,path){
    return this.http.post(this.serverurl+path, data, { responseType: 'text' })
  }

  commonGet(path){
    return this.http.get(this.serverurl+path, { responseType: 'text' })
  }
  
}
