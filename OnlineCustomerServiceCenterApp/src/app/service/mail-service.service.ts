import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EmailDetails } from '../model/email-details';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class MailServiceService {
  url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }
  public sendMdificationMail(details:EmailDetails,custId:number,optId:number){
    return this.http.put<any>(this.url+`sendModificationEmail/${custId}/${optId}`,details);
  }
  public sendIntimationMail(details:EmailDetails,custId:number){
    return this.http.put<any>(this.url+`sendIntimationEmail/${custId}`,details);
  }
}
