import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../model/login';
import { LoginserviceService } from '../service/loginservice.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  login:Login=new Login();
  userName:number;
  password:string="";
  type:string="";
  constructor(private loginService:LoginserviceService,private router:Router) { }

  ngOnInit() {
  }
  public handleLogin(){
    this.login.username=this.userName;
    this.login.password=this.password;
    this.login.type=this.type;
    console.log(this.login);
    if(this.loginService.doLogin(this.login)){
      console.log("Welcome "+this.login.username.toString());
      this.router.navigate(["Menu",this.login.username]);
    }
  }

}
