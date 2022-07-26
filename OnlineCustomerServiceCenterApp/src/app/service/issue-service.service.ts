import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Issue } from '../model/issue';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class IssueServiceService {
  url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }
  public addCustomerIssue(issue:Issue){
    return this.http.post(this.url+"addCustomerIssue",issue,{responseType:'text'});
  }
  public extractIssue():Observable<any>{
    return this.http.get<any>(this.url+"get/allIssue");
  }
  public extractIssueById(optId:number){
    return this.http.get<any>(this.url+`findIssueById/${optId}`);
  }
  public updateIssue(issue:Issue,optId:number){
    return this.http.put<any>(this.url+`modifiCustomerIssue/${optId}`,issue);
  }
  public closeCustomerIssue(optId:number){
    return this.http.get<any>(this.url+`closeCustomerIssue/${optId}`);
  }
  public findOptByCustId(custId:number):Observable<any>{
    return this.http.get<any>(this.url+`findCustomerByOpt/${custId}`);
  }
  
}
