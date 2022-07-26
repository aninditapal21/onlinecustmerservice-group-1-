import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../service/loginservice.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  name:string;
  adminFlag:boolean;
  customerFlag:boolean;
  constructor(private router:ActivatedRoute,private loginServer:LoginserviceService) { }

  ngOnInit() {
    this.name=this.router.snapshot.params['name'];
    this.adminFlag=this.loginServer.isAdmin();
    this.customerFlag=this.loginServer.isCustomer();
    console.log(this.adminFlag);
    console.log(this.customerFlag);
  }

}
