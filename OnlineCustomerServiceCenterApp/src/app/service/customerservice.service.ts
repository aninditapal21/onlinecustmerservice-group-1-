import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { EmailDetails } from '../model/email-details';
import { Login } from '../model/login';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {
  url: string = ProjectUrl.getUrl();
  constructor(private http: HttpClient) { 
    }
    public addCustomer(customer: Customer): Observable<any> {
      return this.http.post(this.url + "/createCustomer", customer, { responseType: 'text' });
  }
  public extractIssue(): Observable<any> {
    return this.http.get<any>(this.url+"/getAllIssue");
  }
  public extractIssueById(customerId: number): Observable<any> {
    return this.http.get<any>(this.url + `/viewIssueById/${customerId}`);
  }
  public reopenIssueById(customerId: number): Observable<any> {
    return this.http.get<any>(this.url + `/reopenIssue/${customerId}`);
  }
   public sendpassword(details: EmailDetails, customerId: number): Observable<any> {
     return this.http.put<any>(this.url + `sendEmailPassword/${customerId}`, details);
   }
   public extractPasswordById(cusId:number):Observable<any> {
    console.log(cusId);
    return this.http.get(this.url+`forgotPasswordByID/${cusId}`,{responseType:'text'});
  }
  public changePasswordById(login:Login,customerId: number): Observable<any> {
    return this.http.put(this.url + `changePasswordById/${customerId}`, login,{responseType:'text'});
  }
}
