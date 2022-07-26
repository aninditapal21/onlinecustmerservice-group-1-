import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../model/department';
import { Operator } from '../model/operator';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class DepartmentserviceService {
  url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }

  public addDepartment(department:Department){
    return this.http.post(this.url+"addDepartment",department,{responseType:'text'});
  }
  public extractDepartment():Observable<any>{
    return this.http.get<any>(this.url+"getAllDepartment");
  }
  public deletedept(deptId:number):Observable<any>{
    return this.http.delete<any>(this.url+`deleteDepartmentById/${deptId}`);
  }
  public extractdeptById(deptId:number):Observable<any>{
    return this.http.get<any>(this.url+`readDepartmentById/${deptId}`);
  }
  public updatedProductById(department:Department,deptId:number){
    return this.http.put<any>(this.url+`updateDepartmentById/${deptId}`,department);
  }
  public extractOperator():Observable<any>{
    return this.http.get<any>(this.url+"getAllOperator");
  }
  public deleteOpt(deptId:number):Observable<any>{
    return this.http.delete<any>(this.url+`removeOperatorById/${deptId}`);
  }
  public extractOptById(deptId:number):Observable<any> 
  {
     return this.http.get<any>(this.url+`findOperatorById/${deptId}`);
  }
  public updatedOperatorById(operator:Operator,deptId:number):Observable<any>{
    return this.http.put<any>(this.url+`/modifyOperatorById/${deptId}`,operator);
  }
  public addOperator(operator:Operator):Observable<any>
  {
    console.log(operator.firstName);
    return this.http.post(this.url+"addOperator", operator,{responseType:'text'}); 
  }
}
