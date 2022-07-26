import { Injectable } from '@angular/core';
import{ HttpClient} from '@angular/common/http';
import { Login } from '../model/login';
import { ProjectUrl } from '../project-url';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  url:string=ProjectUrl.getUrl();

  constructor(private http:HttpClient) { }
  public extractCustomer(login:Login):Observable<any>{
    return this.http.post(this.url+"loginCustomer", login, {responseType:'text'})
  }
  public extractAdmin(login:Login):Observable<any>{
    return this.http.post(this.url+"loginAdmin",login,{responseType:'text'})
  }
}
