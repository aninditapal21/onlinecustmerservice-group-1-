import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OperatorServiceService } from '../service/operator-service.service';

@Component({
  selector: 'app-lock-customer',
  templateUrl: './lock-customer.component.html',
  styleUrls: ['./lock-customer.component.css']
})
export class LockCustomerComponent implements OnInit {
p:number;
flag:boolean;
  constructor(private r:ActivatedRoute,private os:OperatorServiceService,private router:Router) { }

  ngOnInit() {
    this.p=this.r.snapshot.params['optId'];
    console.log(this.p);
    this.os.lockCustomer(this.p).subscribe(response=>{
    this.flag=response;
    console.log(this.flag);
    if(this.flag)
      alert("customer lock");
    this.router.navigate(['viewCustomer']);
    })
  }

}
