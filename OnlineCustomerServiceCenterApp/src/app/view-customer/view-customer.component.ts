import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/customer';
import { IssueServiceService } from '../service/issue-service.service';
import { OperatorServiceService } from '../service/operator-service.service';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
customers:Customer[]=[];
  constructor(private os:OperatorServiceService,private is:IssueServiceService,private router:Router) { }
  operatorId:number;
  ngOnInit() {
    this.os.extractCustomer().subscribe(response=>{
      this.customers=response;
      console.log(response);
    })
  }
  public lockCustomer(custmerId:number){
    this.is.findOptByCustId(custmerId).subscribe(response=>{
      this.operatorId=response;
      console.log(this.operatorId);
      //this.router.navigate(['lockCustomer',this.operatorId]);
      this.os.lockCustomer(this.operatorId).subscribe(response=>{
        console.log(response);
        alert("custmer lock");
        window.location.reload();
      })
    });
    
    console.log(this.operatorId);
    
  }
  /*public closeIssue(operatorId:number){
    //this.issue.issueId=this.issueId;
    //this.issue.issueStatus=this.issueStatus;
    this.is.closeCustomerIssue(operatorId).subscribe(response=>{
      console.log(response);
      //this.msg=`${this.issueId}`+" Close";
      //alert(this.msg);
      alert("Issue is close");
      window.location.reload();
    });
  }
   */

}
