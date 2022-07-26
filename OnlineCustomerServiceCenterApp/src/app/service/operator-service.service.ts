import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class OperatorServiceService {
  url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }

  public extractCustomerById(optId:number):Observable<any>{
    return this.http.get<any>(this.url+`findCustomerById/${optId}`); 
  }
  public extractCustomerByName(optName:string):Observable<any>{
    return this.http.get<any>(this.url+`findCustomerByName/${optName}`); 
  }
  public extractCustomerByEmail(optEmail:string):Observable<any>{
    return this.http.get<any>(this.url+`findCustomerByEmail/${optEmail}`); 
  }
  public extractCustomer():Observable<any>{
    return this.http.get<any>(this.url+"get/allCustomer");
  }
  public lockCustomer(optId:number):Observable<any>{
    return this.http.get<any>(this.url+`/lockCustomer/${optId}`);
  }

  /**public extractdeptById(deptId:number):Observable<any>{
    return this.http.get<any>(this.url+`readDepartmentById/${deptId}`);
  } */
}
