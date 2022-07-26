import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/customer';
import { Login } from '../model/login';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  customerId: number;
  // cId: number;
  password: string;
  username: number;
  login: Login = new Login();
  customer: Customer;
  constructor(private r: ActivatedRoute, private cs:CustomerserviceService, private router: Router) { }

  ngOnInit() {
  }
  public updatePassword() {
    this.login.password = this.password;
    this.login.username = this.username;
    this.cs.changePasswordById(this.login, this.customerId).subscribe(response => {
      console.log(response);
      alert("password changed")
      this.router.navigate(['login']);
    })
  }

}
