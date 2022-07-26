import { Injectable } from '@angular/core';
import { Login } from '../model/login';
import { UserType } from '../model/user-type.enum';
import { UserServiceService } from './user-service.service';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
login:Login;
custMsg:string="";
adminMsg:string="";
  constructor(private userService:UserServiceService) { }
  public doLogin(login:Login):boolean{
    //login.type='CUSTOMER';
    
    if(login.type=='CUSTOMER'){
    this.userService.extractCustomer(login).subscribe(response=>{
      this.custMsg=response;
      //console.log(this.msg);
    });
    }
    else if(login.type=='ADMIN'){
      //login.type='ADMIN';
      this.userService.extractAdmin(login).subscribe(response=>{
      this.adminMsg=response;
    });
    }
    if(this.custMsg=='Login'){
        console.log(this.custMsg);
        sessionStorage.setItem('custName',login.username.toString());
        sessionStorage.setItem('custPassword',login.password);
        return true;
    }
    if(this.adminMsg=='Admin Login'){
        console.log(this.adminMsg);
        sessionStorage.setItem('adminName',login.username.toString());
        sessionStorage.setItem('adminPassword',login.password);
        return true;
    }
    else{
      return false;
    }
  }
  public isAdmin():boolean{
    let adminName=sessionStorage.getItem('adminName');
    //let adminPassword=sessionStorage.getItem('adminPassword');
    return !(adminName==null);
  }
  public isCustomer():boolean{
    let custName=sessionStorage.getItem('custName');
    //let custPassword=sessionStorage.getItem('custPassword');
    return !(custName==null)
  }
  public invokeLogout(){
    sessionStorage.removeItem('custName');
    sessionStorage.removeItem('adminPassword');
    sessionStorage.removeItem('custPassword');
    sessionStorage.removeItem('adminName');
  }
}
