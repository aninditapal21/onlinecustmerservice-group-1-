import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../service/loginservice.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private loginService:LoginserviceService) { }

  ngOnInit() {
    this.loginService.invokeLogout();
  }

}
