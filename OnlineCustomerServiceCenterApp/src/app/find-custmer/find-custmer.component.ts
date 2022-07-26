import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer';
import { OperatorServiceService } from '../service/operator-service.service';

@Component({
  selector: 'app-find-custmer',
  templateUrl: './find-custmer.component.html',
  styleUrls: ['./find-custmer.component.css']
})
export class FindCustmerComponent implements OnInit {
  operatorId:number;
  firstName:string;
  email:string;
  customer:Customer;
  constructor(private os:OperatorServiceService) { }

  ngOnInit() {
  }
  public searchcustById(){
    this.os.extractCustomerById(this.operatorId).subscribe(response=>{
      this.customer=response;
      console.log(response);
    })
  }
  public searchcustByName(){
    this.os.extractCustomerByName(this.firstName).subscribe(response=>{
      this.customer=response;
      console.log(response);
    })
  }
  public searchcustByEmail(){
    this.os.extractCustomerByEmail(this.email).subscribe(response=>{
      this.customer=response;
      console.log(response);
    })
  }


}
