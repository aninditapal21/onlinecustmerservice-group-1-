import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerserviceService } from '../service/customerservice.service';
import { LoginserviceService } from '../service/loginservice.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  name: string = "";
  msg: string = "";
  adminFlag: boolean;
  customerFlag: boolean;
  constructor(private route: ActivatedRoute, private cs: CustomerserviceService, private loginservice:LoginserviceService) { }

  ngOnInit() {
    this.name = this.route.snapshot.params['name']
    this.adminFlag = this.loginservice.isAdmin();
    this.customerFlag = this.loginservice.isCustomer();
    console.log( this.customerFlag );

  }

}
