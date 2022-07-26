import { Component, OnInit } from '@angular/core';
import { Login } from '../model/login';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-forgot-pass-word',
  templateUrl: './forgot-pass-word.component.html',
  styleUrls: ['./forgot-pass-word.component.css']
})
export class ForgotPassWordComponent implements OnInit {
  customerId: number;
  login: Login;
  constructor(private cs: CustomerserviceService) { }

  ngOnInit() {
  }
  public forgotpassword() {
    console.log(this.customerId)
    this.cs.extractPasswordById(this.customerId).subscribe(response => {
      this.login = response;
      console.log(this.login);
    });
  }

}
